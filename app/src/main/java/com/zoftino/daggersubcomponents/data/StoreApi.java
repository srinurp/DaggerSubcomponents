package com.zoftino.daggersubcomponents.data;


import io.reactivex.Observable;
import retrofit2.http.GET;

public interface StoreApi {
    @GET("storeOffers/")
    Observable<Store> getStoreInfo();
}
