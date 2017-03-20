package com.example.materialdesigndemo;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 * Created by Asus on 2017/3/20.
 */

public class BlogActivity extends AppCompatActivity{
    public static final String NAME="name";
    public static final String NAME_ID="name_id";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog);
        Intent intent=getIntent();
        String name=intent.getStringExtra(NAME);
        int res=intent.getIntExtra(NAME_ID,0);
        Toolbar toolbar= (Toolbar) findViewById(R.id.imtoolBar);
        CollapsingToolbarLayout collapsingToolbarLayout= (CollapsingToolbarLayout) findViewById(R.id.collapsing);
        ImageView imageView= (ImageView) findViewById(R.id.image_view);
        TextView textView= (TextView) findViewById(R.id.tv_content);
        setSupportActionBar(toolbar);
        ActionBar actionBar=getSupportActionBar();
        if (actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        collapsingToolbarLayout.setTitle(name);
        Glide.with(this).load(res).into(imageView);
        String content=contentText();
        textView.setText(content);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private String contentText(){
        String text="雷姆，轻小说《Re：从零开始的异世界生活》" +
                "及其衍生作品的主要角色，在罗兹沃尔的宅邸中一" +
                "手担当全部杂务的双胞胎女仆中的妹妹，小时候家" +
                "人被魔女教所杀，姐姐角被斩断，从而憎恨魔女教" +
                "，初识昴因其身上有魔女气味不待见昴，之后解开" +
                "误会被昴拯救，认定昴是她的英雄，一心一意的相" +
                "信并照顾昴，看似毒舌冷漠，其实内心很坚强，很" +
                "温柔。"+"以下全是凑字数以下全是凑字数以下全" +
                "是凑字数以下全是凑字数以下全是凑字数以下全是" +
                "凑字数以下全是凑字数以下全是凑字数以下全是凑" +
                "字数以下全是凑字数以下全是凑字数以下全是凑字" +
                "数以下全是凑字数以下全是凑字数以下全是凑字数" +
                "以下全是凑字数以下全是凑字数以下全是凑字数以" +
                "下全是凑字数以下全是凑字数以下全是凑字数以下" +
                "全是凑字数以下全是凑字数以下全是凑字数以下全" +
                "是凑字数以下全是凑字数以下全是凑字数以下全是" +
                "凑字数以下全是凑字数以下全是凑字数以下全是凑" +
                "字数以下全是凑字数以下全是凑字数";
        return text;
    }
}
