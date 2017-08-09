package com.zoftino.daggersubcomponents.di;

import com.zoftino.daggersubcomponents.data.StoreApi;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;
import retrofit2.Retrofit;

@Module
public class StoreModule {
    @StoreScope
    @Provides
    public StoreApi getStoreClient(Retrofit retrofit){
        return retrofit.create(StoreApi.class);
    }
    @StoreScope
    @Provides
    public CompositeDisposable getComposite(){
        return new CompositeDisposable();
    }
}
