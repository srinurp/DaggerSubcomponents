package com.zoftino.daggersubcomponents.di;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module(subcomponents = {CouponComponent.class, StoreComponent.class})
public class AppModule {
    public static final String BASE_URL = "http://www.zoftino.com/api/";

    @Singleton
    @Provides
    public Retrofit getRemoteClient(){
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }
}
