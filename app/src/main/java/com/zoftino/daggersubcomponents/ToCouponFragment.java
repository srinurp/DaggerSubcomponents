package com.zoftino.daggersubcomponents;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zoftino.daggersubcomponents.data.Coupon;
import com.zoftino.daggersubcomponents.data.CouponApi;
import com.zoftino.daggersubcomponents.data.StoreMessage;
import com.zoftino.daggersubcomponents.di.DaggerAppComponent;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class ToCouponFragment extends Fragment {

    @Inject
    CompositeDisposable compositeDisposable;
    @Inject
    CouponApi couponApi;
    @Inject
    StoreMessage storeMessage;

    private TextView cpn;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        DaggerAppComponent.create().couponBuilder().build().inject(this);

        View view = inflater.inflate(R.layout.tocoupon,
                container, false);
        cpn = (TextView) view.findViewById(R.id.couponInfo);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        compositeDisposable.add(io.reactivex.Observable.just(1)
                .subscribeOn(Schedulers.computation())
                .flatMap(i -> { return couponApi.getTopCoupon();}).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Coupon>() {
                    @Override
                    public void accept(Coupon coupon) throws Exception {
                        cpn.setText(storeMessage.getMsgCoupon()+" "+coupon.toString());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.e("ToCouponFragment", "exception getting coupon", throwable);
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
