package com.zoftino.daggersubcomponents.data;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface CouponApi {
    @GET("topCoupon/")
    Observable<Coupon> getTopCoupon();
}
