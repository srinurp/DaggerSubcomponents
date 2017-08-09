package com.zoftino.daggersubcomponents;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zoftino.daggersubcomponents.data.Store;
import com.zoftino.daggersubcomponents.data.StoreApi;
import com.zoftino.daggersubcomponents.data.StoreMessage;
import com.zoftino.daggersubcomponents.di.DaggerAppComponent;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class StoreFragment extends Fragment {
    @Inject
    CompositeDisposable compositeDisposable;
    @Inject
    StoreApi storeApi;
    @Inject
    StoreMessage storeMessage;

    private TextView storeTxt;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.store,
                container, false);
        storeTxt = (TextView) view.findViewById(R.id.storeInfo);

        DaggerAppComponent.create().storeBuilder().build().inject(this);

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        compositeDisposable.add(io.reactivex.Observable.just(1)
                .subscribeOn(Schedulers.computation())
                .flatMap(i -> { return storeApi.getStoreInfo();}).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Store>() {
                    @Override
                    public void accept(Store store) throws Exception {
                        storeTxt.setText(storeMessage.getMsgStore()+" "+store.toString());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.e("StoreFragment", "exception getting store", throwable);
                    }
                }));

    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        if(compositeDisposable.isDisposed()){
            compositeDisposable.clear();
        }
    }
}
