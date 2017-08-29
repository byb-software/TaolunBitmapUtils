package com.byb.taolunbitmaputils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import utils.TaolunBitmapUtils;

public class Main3Activity extends AppCompatActivity {

    private int[] id = { R.id.wx7,R.id.wx8,R.id.wx9,R.id.wxb7,R.id.wxb8,R.id.wxb9};
    private ImageView[] name =new ImageView[id.length];
    private List<Bitmap> wx = new ArrayList<>();//作为微信讨论组头像的数据源

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);


        initData();//加载数据源
        initWXData();//微信7-9头像的显示
    }

    private void initData() {
        for (int i = 0; i < 6; i++) {
            name[i] = (ImageView) findViewById(id[i]);
        }
    }

    private void initWXData() {

        //微信7个头像
        Bitmap bitmap71 = BitmapFactory.decodeResource(getResources(),R.mipmap.a1);
        Bitmap bitmap72 = BitmapFactory.decodeResource(getResources(),R.mipmap.a2);
        Bitmap bitmap73 = BitmapFactory.decodeResource(getResources(),R.mipmap.a3);
        Bitmap bitmap74 = BitmapFactory.decodeResource(getResources(),R.mipmap.a4);
        Bitmap bitmap75 = BitmapFactory.decodeResource(getResources(),R.mipmap.a5);
        Bitmap bitmap76 = BitmapFactory.decodeResource(getResources(),R.mipmap.a6);
        Bitmap bitmap77 = BitmapFactory.decodeResource(getResources(),R.mipmap.a1);
        wx.clear();
        wx.add(bitmap71);
        wx.add(bitmap72);
        wx.add(bitmap73);
        wx.add(bitmap74);
        wx.add(bitmap75);
        wx.add(bitmap76);
        wx.add(bitmap77);
        Bitmap data7 = TaolunBitmapUtils.SquareTaolunzuBitmap(this,170,170,wx);
        name[0].setImageBitmap(data7);
        //改变头像背景
        Bitmap datas7 = TaolunBitmapUtils.SquareTaolunzuBitmap(this,170,170,wx, Color.parseColor("#545d97"));
        name[3].setImageBitmap(datas7);


        //微信8个头像
        Bitmap bitmap81 = BitmapFactory.decodeResource(getResources(),R.mipmap.a1);
        Bitmap bitmap82 = BitmapFactory.decodeResource(getResources(),R.mipmap.a2);
        Bitmap bitmap83 = BitmapFactory.decodeResource(getResources(),R.mipmap.a3);
        Bitmap bitmap84 = BitmapFactory.decodeResource(getResources(),R.mipmap.a4);
        Bitmap bitmap85 = BitmapFactory.decodeResource(getResources(),R.mipmap.a5);
        Bitmap bitmap86 = BitmapFactory.decodeResource(getResources(),R.mipmap.a6);
        Bitmap bitmap87 = BitmapFactory.decodeResource(getResources(),R.mipmap.a1);
        Bitmap bitmap88 = BitmapFactory.decodeResource(getResources(),R.mipmap.a2);
        wx.clear();
        wx.add(bitmap81);
        wx.add(bitmap82);
        wx.add(bitmap83);
        wx.add(bitmap84);
        wx.add(bitmap85);
        wx.add(bitmap86);
        wx.add(bitmap87);
        wx.add(bitmap88);
        Bitmap data8 = TaolunBitmapUtils.SquareTaolunzuBitmap(this,170,170,wx);
        name[1].setImageBitmap(data8);
        //改变头像背景
        Bitmap datas8 = TaolunBitmapUtils.SquareTaolunzuBitmap(this,170,170,wx, Color.parseColor("#145d97"));
        name[4].setImageBitmap(datas8);


        //微信9个头像
        Bitmap bitmap91 = BitmapFactory.decodeResource(getResources(),R.mipmap.a1);
        Bitmap bitmap92 = BitmapFactory.decodeResource(getResources(),R.mipmap.a2);
        Bitmap bitmap93 = BitmapFactory.decodeResource(getResources(),R.mipmap.a3);
        Bitmap bitmap94 = BitmapFactory.decodeResource(getResources(),R.mipmap.a4);
        Bitmap bitmap95 = BitmapFactory.decodeResource(getResources(),R.mipmap.a5);
        Bitmap bitmap96 = BitmapFactory.decodeResource(getResources(),R.mipmap.a6);
        Bitmap bitmap97 = BitmapFactory.decodeResource(getResources(),R.mipmap.a1);
        Bitmap bitmap98 = BitmapFactory.decodeResource(getResources(),R.mipmap.a2);
        Bitmap bitmap99 = BitmapFactory.decodeResource(getResources(),R.mipmap.a3);
        wx.clear();
        wx.add(bitmap91);
        wx.add(bitmap92);
        wx.add(bitmap93);
        wx.add(bitmap94);
        wx.add(bitmap95);
        wx.add(bitmap96);
        wx.add(bitmap97);
        wx.add(bitmap98);
        wx.add(bitmap99);
        Bitmap data9 = TaolunBitmapUtils.SquareTaolunzuBitmap(this,170,170,wx);
        name[2].setImageBitmap(data9);
        //改变头像背景
        Bitmap datas9 = TaolunBitmapUtils.SquareTaolunzuBitmap(this,170,170,wx, Color.parseColor("#a45d97"));
        name[5].setImageBitmap(datas9);
    }


}
