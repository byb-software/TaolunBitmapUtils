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

public class MainActivity extends AppCompatActivity {


    private int[] id = {R.id.qq1,R.id.qq2,R.id.qq3,R.id.qq4,R.id.qq5,R.id.qqb1,R.id.qqb2,R.id.qqb3,R.id.qqb4,R.id.qqb5};
    private ImageView[] name =new ImageView[id.length];
    private List<Bitmap> qq = new ArrayList<>();//作为QQ群头像的数据源

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initView();//控件初始化
        initQQData();//展示QQ的头像实例

    }



    private void initQQData() {
      //QQ1个头像
       Bitmap bitmap1 = BitmapFactory.decodeResource(getResources(),R.mipmap.a1);
        qq.add(bitmap1);
       Bitmap data = TaolunBitmapUtils.CircleTaolunBitmap(150,150,qq);
        name[0].setImageBitmap(data);
         //改变头像背景
        Bitmap datas = TaolunBitmapUtils.CircleTaolunBitmap(150,150,qq, Color.parseColor("#FFFF0000"));
        name[5].setImageBitmap(datas);


     //QQ2个头像
        Bitmap bitmap2 = BitmapFactory.decodeResource(getResources(),R.mipmap.a1);
        Bitmap bitmap3 = BitmapFactory.decodeResource(getResources(),R.mipmap.a2);
        qq.clear();
        qq.add(bitmap2);
        qq.add(bitmap3);
        Bitmap data1 = TaolunBitmapUtils.CircleTaolunBitmap(150,150,qq);
        name[1].setImageBitmap(data1);
           //改变头像背景
        Bitmap datas1 = TaolunBitmapUtils.CircleTaolunBitmap(150,150,qq, Color.parseColor("#545d97"));
        name[6].setImageBitmap(datas1);


        //QQ3个头像
        Bitmap bitmap4 = BitmapFactory.decodeResource(getResources(),R.mipmap.a1);
        Bitmap bitmap5 = BitmapFactory.decodeResource(getResources(),R.mipmap.a2);
        Bitmap bitmap6 = BitmapFactory.decodeResource(getResources(),R.mipmap.a3);
        qq.clear();
        qq.add(bitmap4);
        qq.add(bitmap5);
        qq.add(bitmap6);
        Bitmap data2 = TaolunBitmapUtils.CircleTaolunBitmap(150,150,qq);
        name[2].setImageBitmap(data2);
           //改变头像背景
        Bitmap datas2 = TaolunBitmapUtils.CircleTaolunBitmap(150,150,qq, Color.parseColor("#cc805f"));
        name[7].setImageBitmap(datas2);


        //QQ4个头像
        Bitmap bitmap7 = BitmapFactory.decodeResource(getResources(),R.mipmap.a1);
        Bitmap bitmap8 = BitmapFactory.decodeResource(getResources(),R.mipmap.a2);
        Bitmap bitmap9 = BitmapFactory.decodeResource(getResources(),R.mipmap.a3);
        Bitmap bitmap10 = BitmapFactory.decodeResource(getResources(),R.mipmap.a4);
        qq.clear();
        qq.add(bitmap7);
        qq.add(bitmap8);
        qq.add(bitmap9);
        qq.add(bitmap10);
        Bitmap data3 = TaolunBitmapUtils.CircleTaolunBitmap(150,150,qq);
        name[3].setImageBitmap(data3);
           //改变头像背景
        Bitmap datas3 = TaolunBitmapUtils.CircleTaolunBitmap(150,150,qq, Color.parseColor("#30a399"));
        name[8].setImageBitmap(datas3);


        //QQ5个头像
        Bitmap bitmap11 = BitmapFactory.decodeResource(getResources(),R.mipmap.a1);
        Bitmap bitmap12 = BitmapFactory.decodeResource(getResources(),R.mipmap.a2);
        Bitmap bitmap13 = BitmapFactory.decodeResource(getResources(),R.mipmap.a3);
        Bitmap bitmap14 = BitmapFactory.decodeResource(getResources(),R.mipmap.a4);
        Bitmap bitmap15 = BitmapFactory.decodeResource(getResources(),R.mipmap.a5);
        qq.clear();
        qq.add(bitmap11);
        qq.add(bitmap12);
        qq.add(bitmap13);
        qq.add(bitmap14);
        qq.add(bitmap15);
        Bitmap data4 = TaolunBitmapUtils.CircleTaolunBitmap(150,150,qq);
        name[4].setImageBitmap(data4);
            //改变头像背景
        Bitmap datas4 = TaolunBitmapUtils.CircleTaolunBitmap(150,150,qq, Color.parseColor("#6f1e97"));
        name[9].setImageBitmap(datas4);

    }

    private void initView() {
        for (int i = 0; i < 10; i++) {
           name[i] = (ImageView) findViewById(id[i]);
        }

    }


    //点击跳转到微信头像的显示界面
    public void click(View view) {
        Intent intent = new Intent(this,Main2Activity.class);
        this.startActivity(intent);
    }
}
