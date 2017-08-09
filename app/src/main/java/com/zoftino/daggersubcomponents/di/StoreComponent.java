package com.zoftino.daggersubcomponents.di;

import com.zoftino.daggersubcomponents.StoreFragment;

import dagger.Subcomponent;

@StoreScope
@Subcomponent(modules = StoreModule.class)
public interface StoreComponent {
    @Subcomponent.Builder
    interface Builder {
        StoreComponent.Builder storeModule(StoreModule module);
        StoreComponent build();
    }
    public void inject(StoreFragment fragment);
}
