package com.ligouzi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.ligouzi.fragment.CartFragment;
import com.ligouzi.fragment.CenterFragment;
import com.ligouzi.fragment.HomeFragment;
import com.ligouzi.fragment.OrderFragment;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener{

    LinearLayout home_LinearLayout;
    LinearLayout cart_LinearLayout;
    LinearLayout order_LinearLayout;
    LinearLayout center_LinearLayout;

    public static final String HOMEFRAGMENT_TAG="HOME";
    public static final String CARTFRAGMENT_TAG="CART";
    public static final String ORDERFRAGMENT_TAG="ORDER";
    public static final String CENTERFRAGMENT_TAG="CENTER";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        home_LinearLayout=(LinearLayout)findViewById(R.id.home);
        cart_LinearLayout=(LinearLayout)findViewById(R.id.cart);
        order_LinearLayout=(LinearLayout)findViewById(R.id.order);
        center_LinearLayout=(LinearLayout)findViewById(R.id.center);

        home_LinearLayout.setOnClickListener(this);
        cart_LinearLayout.setOnClickListener(this);
        order_LinearLayout.setOnClickListener(this);
        center_LinearLayout.setOnClickListener(this);
//        ImageView img=(ImageView)findViewById(R.id.img);
//        img.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent it=new Intent(HomeActivity.this,LoginActivity.class);
//                startActivity(it);
//            }
//        });
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.home:
                attachFragment(HOMEFRAGMENT_TAG);
                break;
            case R.id.cart:
                attachFragment(CARTFRAGMENT_TAG);
                break;
            case R.id.order:
                attachFragment(ORDERFRAGMENT_TAG);
                break;
            case R.id.center:
                attachFragment(CENTERFRAGMENT_TAG);
                break;
        }

    }

    private void attachFragment(String fragmentTag){

        //1、获取Fragment管理器
        FragmentManager fragmentManager=getSupportFragmentManager();
        //2、开启事务
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        //3、判断管理器有没有这个Fragment，没有则添加Fragment
        Fragment fragment=fragmentManager.findFragmentByTag(fragmentTag);
        if(fragment==null){
            if(fragmentTag.equals(HOMEFRAGMENT_TAG)){
                fragment=new HomeFragment();
                fragmentTransaction.add(fragment,HOMEFRAGMENT_TAG);
            }else if(fragmentTag.equals(CARTFRAGMENT_TAG)){
                fragment=new CartFragment();
                fragmentTransaction.add(fragment,CARTFRAGMENT_TAG);
            }else if(fragmentTag.equals(ORDERFRAGMENT_TAG)){
                fragment=new OrderFragment();
                fragmentTransaction.add(fragment,ORDERFRAGMENT_TAG);
            }else if(fragmentTag.equals(CENTERFRAGMENT_TAG)){
                fragment=new CenterFragment();
                fragmentTransaction.add(fragment,CENTERFRAGMENT_TAG);
            }
        }
        //4、显示对应布局
        fragmentTransaction.replace(R.id.content,fragment,fragmentTag);
        //5、提交
        fragmentTransaction.commit();

    }

}
