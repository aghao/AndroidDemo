package com.aghao.app.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.aghao.app.R;
import com.nostra13.universalimageloader.core.ImageLoader;

public class ShowImageActivity extends AppCompatActivity {

    ImageView iv;
    Button btn;
    TextView tv;

    public static final String imgUrl = "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F01e1af554317290000019ae94fb43a.jpg%401280w_1l_2o_100sh.jpg&refer=http%3A%2F%2Fimg.zcool.cn&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1626533537&t=9b9b5d1c9a3b5b45093f2187c7a021ed";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_image);
        iv = findViewById(R.id.showimg_img);
        btn = findViewById(R.id.showimg_btn);
        tv = findViewById(R.id.showimg_text);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageLoader.getInstance().displayImage(imgUrl, iv);
                tv.setText("图片地址"+'\n'+imgUrl);
            }
        });
    }
}