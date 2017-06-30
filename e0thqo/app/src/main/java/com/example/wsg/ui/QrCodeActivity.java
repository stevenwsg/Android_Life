package com.example.wsg.ui;

import android.os.Bundle;
import android.widget.ImageView;

import com.example.wsg.R;

/*
 *项目名： SmartButler
 *包名：   com.imooc.smartbutler.ui
 *文件名:  QrCodeActivity
 *创建者:  LGL
 *创建时间:2016/11/2723:05
 *描述:    生成二维码
 */
public class QrCodeActivity extends BaseActivity {

    //我的二维码
    private ImageView iv_qr_code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_code);

        initView();
    }

    private void initView() {

        iv_qr_code = (ImageView) findViewById(R.id.iv_qr_code);
        //屏幕的宽
        int width = getResources().getDisplayMetrics().widthPixels;

//        Bitmap qrCodeBitmap = EncodingUtils.createQRCode("我是智能管家", width / 2, width / 2,
//                BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher));
//        iv_qr_code.setImageBitmap(qrCodeBitmap);
    }
}
