package com.zoftino.daggersubcomponents.di;

import com.zoftino.daggersubcomponents.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules={AppModule.class})
public interface AppComponent {
    CouponComponent.Builder couponBuilder();
    StoreComponent.Builder storeBuilder();
    public void inject(MainActivity mainActivity);
}
