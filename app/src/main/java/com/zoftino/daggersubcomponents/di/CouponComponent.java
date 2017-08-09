package com.zoftino.daggersubcomponents.di;

import com.zoftino.daggersubcomponents.ToCouponFragment;

import dagger.Subcomponent;

@CouponScope
@Subcomponent(modules = CouponModule.class)
public interface CouponComponent {
    public void inject(ToCouponFragment fragment);
    @Subcomponent.Builder
    interface Builder {
        Builder couponModule(CouponModule module);
        CouponComponent build();
    }

}

