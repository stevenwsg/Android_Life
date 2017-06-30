package com.example.wsg.ui;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.wsg.R;
import com.example.wsg.utils.UtilTools;

import java.util.ArrayList;
import java.util.List;

/*
 *项目名： SmartButler
 *包名：   com.imooc.smartbutler.ui
 *文件名:  AboutActivity
 *创建者:  LGL
 *创建时间:2016/12/1223:00
 *描述:    关于软件
 */
public class AboutActivity extends BaseActivity {

    private ListView mListView;
    private List<String>mList = new ArrayList<>();
    private ArrayAdapter<String>mAdapter;
    private TextView text_love;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        //去除阴影
        getSupportActionBar().setElevation(0);

        initView();
    }

    //初始化View
    private void initView() {
        mListView = (ListView) findViewById(R.id.mListView);
        text_love=(TextView)findViewById(R.id.love);


        mList.add(getString(R.string.text_app_name) + getString(R.string.app_name));
        mList.add(getString(R.string.text_version) + UtilTools.getVersion(this));
        mList.add(getString(R.string.text_website_address));

        mAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,mList);
        //设置适配器
        mListView.setAdapter(mAdapter);
        UtilTools.setFont(this,text_love);

    }
}
