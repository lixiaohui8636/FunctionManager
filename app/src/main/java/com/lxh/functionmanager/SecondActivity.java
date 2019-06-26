package com.lxh.functionmanager;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.lxh.util.FunctionManager;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec);
        final String tag = "MainActivity";
        final TextView res = findViewById(R.id.result);
        findViewById(R.id.npnt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FunctionManager.getInstance().invokeFunction(tag+"npnt");
            }
        });

        findViewById(R.id.npht).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.User user = FunctionManager.getInstance().invokeFunction(tag+"npht", MainActivity.User.class);
                res.setText("result:"+user.toString());
            }
        });

        findViewById(R.id.hpnt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.User user = new MainActivity.User("有参无返回值的参数","hpnt");
                FunctionManager.getInstance().invokeFunction(tag+"hpnt",user);
            }
        });

        findViewById(R.id.hpht).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.User user = new MainActivity.User("有参有返回值的参数","hpht");
                MainActivity.User user1 = FunctionManager.getInstance().invokeFunction(tag+"hpht",user, MainActivity.User.class);
                res.setText("result:"+user1.toString());

            }
        });
    }
}
