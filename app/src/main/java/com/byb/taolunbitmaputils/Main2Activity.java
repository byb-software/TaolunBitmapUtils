package com.byb.taolunbitmaputils;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import utils.TaolunBitmapUtils;

public class Main2Activity extends AppCompatActivity {

    private int[] id = { R.id.wx1,R.id.wx2,R.id.wx3,R.id.wx4,R.id.wx5,R.id.wx6,R.id.wxb1,R.id.wxb2,R.id.wxb3,R.id.wxb4,R.id.wxb5,R.id.wxb6};
    private ImageView[] name =new ImageView[id.length];
    private List<Bitmap> wx = new ArrayList<>();//作为微信讨论组头像的数据源

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);



        initView();
        initWXData();//微信头像的显示方法

    }

    private void initView() {
        for (int i = 0; i < 12; i++) {
            name[i] = (ImageView) findViewById(id[i]);
        }
    }


    private void initWXData() {

        //微信1个头像
        Bitmap bitmap1 = BitmapFactory.decodeResource(getResources(),R.mipmap.a1);
        wx.add(bitmap1);
        Bitmap data1 = TaolunBitmapUtils.SquareTaolunzuBitmap(this,150,150,wx);
        name[0].setImageBitmap(data1);
        //改变头像背景
        Bitmap datas1 = TaolunBitmapUtils.SquareTaolunzuBitmap(this,150,150,wx, Color.parseColor("#FFFF0000"));
        name[6].setImageBitmap(datas1);


        //微信2个头像
        Bitmap bitmap21 = BitmapFactory.decodeResource(getResources(),R.mipmap.a1);
        Bitmap bitmap22 = BitmapFactory.decodeResource(getResources(),R.mipmap.a2);
        wx.clear();
        wx.add(bitmap21);
        wx.add(bitmap22);
        Bitmap data2 = TaolunBitmapUtils.SquareTaolunzuBitmap(this,150,150,wx);
        name[1].setImageBitmap(data2);
        //改变头像背景
        Bitmap datas2 = TaolunBitmapUtils.SquareTaolunzuBitmap(this,150,150,wx, Color.parseColor("#545d97"));
        name[7].setImageBitmap(datas2);


        //微信3个头像
        Bitmap bitmap31 = BitmapFactory.decodeResource(getResources(),R.mipmap.a1);
        Bitmap bitmap32 = BitmapFactory.decodeResource(getResources(),R.mipmap.a2);
        Bitmap bitmap33 = BitmapFactory.decodeResource(getResources(),R.mipmap.a3);
        wx.clear();
        wx.add(bitmap31);
        wx.add(bitmap32);
        wx.add(bitmap33);
        Bitmap data3 = TaolunBitmapUtils.SquareTaolunzuBitmap(this,150,150,wx);
        name[2].setImageBitmap(data3);
        //改变头像背景
        Bitmap datas3 = TaolunBitmapUtils.SquareTaolunzuBitmap(this,150,150,wx, Color.parseColor("#cc805f"));
        name[8].setImageBitmap(datas3);


        //微信4个头像
        Bitmap bitmap41 = BitmapFactory.decodeResource(getResources(),R.mipmap.a1);
        Bitmap bitmap42 = BitmapFactory.decodeResource(getResources(),R.mipmap.a2);
        Bitmap bitmap43 = BitmapFactory.decodeResource(getResources(),R.mipmap.a3);
        Bitmap bitmap44 = BitmapFactory.decodeResource(getResources(),R.mipmap.a4);
        wx.clear();
        wx.add(bitmap41);
        wx.add(bitmap42);
        wx.add(bitmap43);
        wx.add(bitmap44);
        Bitmap data4 = TaolunBitmapUtils.SquareTaolunzuBitmap(this,150,150,wx);
        name[3].setImageBitmap(data4);
        //改变头像背景
        Bitmap datas4 = TaolunBitmapUtils.SquareTaolunzuBitmap(this,150,150,wx, Color.parseColor("#30a399"));
        name[9].setImageBitmap(datas4);


        //微信5个头像
        Bitmap bitmap51 = BitmapFactory.decodeResource(getResources(),R.mipmap.a1);
        Bitmap bitmap52 = BitmapFactory.decodeResource(getResources(),R.mipmap.a2);
        Bitmap bitmap53 = BitmapFactory.decodeResource(getResources(),R.mipmap.a3);
        Bitmap bitmap54 = BitmapFactory.decodeResource(getResources(),R.mipmap.a4);
        Bitmap bitmap55 = BitmapFactory.decodeResource(getResources(),R.mipmap.a5);
        wx.clear();
        wx.add(bitmap51);
        wx.add(bitmap52);
        wx.add(bitmap53);
        wx.add(bitmap54);
        wx.add(bitmap55);
        Bitmap data5 = TaolunBitmapUtils.SquareTaolunzuBitmap(this,150,150,wx);
        name[4].setImageBitmap(data5);
        //改变头像背景
        Bitmap datas5 = TaolunBitmapUtils.SquareTaolunzuBitmap(this,150,150,wx, Color.parseColor("#6f1e97"));
        name[10].setImageBitmap(datas5);


        //微信6个头像
        Bitmap bitmap61 = BitmapFactory.decodeResource(getResources(),R.mipmap.a1);
        Bitmap bitmap62 = BitmapFactory.decodeResource(getResources(),R.mipmap.a2);
        Bitmap bitmap63 = BitmapFactory.decodeResource(getResources(),R.mipmap.a3);
        Bitmap bitmap64 = BitmapFactory.decodeResource(getResources(),R.mipmap.a4);
        Bitmap bitmap65 = BitmapFactory.decodeResource(getResources(),R.mipmap.a5);
        Bitmap bitmap66 = BitmapFactory.decodeResource(getResources(),R.mipmap.a6);
        wx.clear();
        wx.add(bitmap61);
        wx.add(bitmap62);
        wx.add(bitmap63);
        wx.add(bitmap64);
        wx.add(bitmap65);
        wx.add(bitmap66);
        Bitmap data6 = TaolunBitmapUtils.SquareTaolunzuBitmap(this,150,150,wx);
        name[5].setImageBitmap(data6);
        //改变头像背景
        Bitmap datas6 = TaolunBitmapUtils.SquareTaolunzuBitmap(this,150,150,wx, Color.parseColor("#745d97"));
        name[11].setImageBitmap(datas6);


    }


    public void clicks(View view) {
        Intent intent = new Intent(this,Main3Activity.class);
        this.startActivity(intent);
    }
}
