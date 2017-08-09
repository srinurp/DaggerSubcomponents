package com.zoftino.daggersubcomponents.data;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class StoreMessage {
    @Inject
    public StoreMessage(){}

    public String getMsg(){
        return "View latest store and coupon";
    }
    public String getMsgCoupon(){
        return "View latest coupon";
    }
    public String getMsgStore(){
        return "View store details";
    }
}
