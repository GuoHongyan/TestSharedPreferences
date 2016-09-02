package com.example.testsharedpreferences;

import android.content.SharedPreferences;
import android.opengl.EGLDisplay;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    //SharedPreferences文件名
    private final static String SharedPreferencesFileName="config";

    private final static String STUDENT_ID="StudentId";
    private final static String NAME="name";

    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preferences = getSharedPreferences(SharedPreferencesFileName, MODE_PRIVATE);

        editor = preferences.edit();
        Button btWrite = (Button) findViewById(R.id.writeButton);
        Button btRead = (Button) findViewById(R.id.readButton);
        btWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //格式化日期，将日期按照年月日时分秒格式转换为字符串形式
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                String strLoginDate = simpleDateFormat.format(new Date());

                editor.putString(STUDENT_ID, "2014011703");
                editor.putString(NAME, "ghy");
                editor.apply();
            }
        });

        btRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = preferences.getString(STUDENT_ID, null);
                String name = preferences.getString(NAME, null);

                if (id != null && name != null)
                    Toast.makeText(MainActivity.this, "学号:" + id +"姓名"+name+ "登录时间:" + name, Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(MainActivity.this, "无数据", Toast.LENGTH_LONG).show();
            }
        });

    }
}
