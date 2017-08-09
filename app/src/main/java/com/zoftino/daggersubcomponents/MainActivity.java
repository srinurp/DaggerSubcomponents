package com.zoftino.daggersubcomponents;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.zoftino.daggersubcomponents.data.StoreMessage;
import com.zoftino.daggersubcomponents.di.DaggerAppComponent;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {
    @Inject
    StoreMessage storeMessage;

    private FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       DaggerAppComponent.create().inject(this);

        ((TextView)this.findViewById(R.id.header)).setText(storeMessage.getMsg());

        fm = getSupportFragmentManager();

        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.content, new StoreFragment());
        ft.commit();
    }

    public void getStore(View view){
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.content, new StoreFragment());
        ft.commit();
    }
    public void getCoupon(View view){
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.content, new ToCouponFragment());
        ft.commit();
    }
}
