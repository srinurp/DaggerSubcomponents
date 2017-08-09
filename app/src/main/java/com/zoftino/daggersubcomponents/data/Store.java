package com.zoftino.daggersubcomponents.data;

public class Store {
    private String store;
    private String totalCoupons;
    private String maxCashback;

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public String getTotalCoupons() {
        return totalCoupons;
    }

    public void setTotalCoupons(String totalCoupons) {
        this.totalCoupons = totalCoupons;
    }

    public String getMaxCashback() {
        return maxCashback;
    }

    public void setMaxCashback(String maxCashback) {
        this.maxCashback = maxCashback;
    }
    public String toString(){
        return store+" "+totalCoupons+" "+maxCashback;
    }
}

