package com.example.wsg.ui;

import android.os.Bundle;
import android.text.format.Time;
import android.widget.ListView;

import com.example.wsg.R;
import com.example.wsg.adapter.TodayAdapter;
import com.example.wsg.entity.TodayData;
import com.example.wsg.utils.StaticClass;
import com.kymjs.rxvolley.RxVolley;
import com.kymjs.rxvolley.client.HttpCallback;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 项目名：App
 * 包名：com.example.wsg.app.ui
 * 文件名：TodayActivity
 * 创建者：wsg
 * 创建时间：2017/3/18  13:30
 * 描述：TODO
 */

public class TodayActivity extends BaseActivity {

    private ListView mListView;
    private List<TodayData> mList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_today);
        initView();
    }

    private void initView() {

        mListView=(ListView)findViewById(R.id.mListView1);
//        获取今天日期
        Time t=new Time(); // or Time t=new Time("GMT+8"); 加上Time Zone资料。
        t.setToNow(); // 取得系统时间。
        int year = t.year;
        int month = t.month+1;
        int date = t.monthDay;


        //1.拼接我们的url
        String url="http://api.juheapi.com/japi/toh?key="+ StaticClass.TODAY_KEY+"&v=1.0&month="+month+"&day="+date;
        //2.拿到数据去请求数据（Json）
        RxVolley.get(url, new HttpCallback() {
            @Override
            public void onSuccess(String t) {
//                Toast.makeText(TodayActivity.this,t,Toast.LENGTH_LONG).show();
                parsingJson(t);
            }
        });
    }

    private void parsingJson(String t) {
        try{
            JSONObject jsonObject = new JSONObject(t);
//            JSONObject jsonResult = jsonObject.getJSONObject("{");
            JSONArray jsonArray = jsonObject.getJSONArray("result");


            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject json = (JSONObject) jsonArray.get(i);
                TodayData data=new TodayData();
                data.setTitle(json.getString("title"));
                data.setDes(json.getString("des"));
                data.setLunar(json.getString("lunar"));
                mList.add(data);
            }


            //倒序
            Collections.reverse(mList);

            TodayAdapter adapter=new TodayAdapter(this,mList);
            mListView.setAdapter(adapter);



        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
