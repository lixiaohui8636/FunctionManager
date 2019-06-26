package com.lxh.functionmanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.lxh.util.FunctionManager;
import com.lxh.util.function.HasParamHasResultFunction;
import com.lxh.util.function.HasParamNoResultFunction;
import com.lxh.util.function.NoParamHasResultFunction;
import com.lxh.util.function.NoParamNoResultFunction;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String tag = "MainActivity";
        FunctionManager.getInstance().addFunction(new NoParamNoResultFunction(tag+"npnt") {
            @Override
            public void function() {
                Toast.makeText(MainActivity.this,"接受到无参无返回值的消息",Toast.LENGTH_SHORT).show();
            }
        });

        FunctionManager.getInstance().addFunction(new NoParamHasResultFunction<User>(tag+"npht") {
            @Override
            public User function() {
                Toast.makeText(MainActivity.this,"接受到无参有返回值的消息",Toast.LENGTH_SHORT).show();
                return new User("无参有返回值的返回值","npht");
            }
        });

        FunctionManager.getInstance().addFunction(new HasParamNoResultFunction<User>(tag+"hpnt") {
            @Override
            public void function(User o) {
                Toast.makeText(MainActivity.this,"接受到有参无返回值的消息:"+o.toString(),Toast.LENGTH_SHORT).show();
            }
        });

        FunctionManager.getInstance().addFunction(new HasParamHasResultFunction<User,User>(tag+"hpht") {
            @Override
            public User function(User o) {
                Toast.makeText(MainActivity.this,"接受到有参有返回值的消息:"+o.toString(),Toast.LENGTH_SHORT).show();
                User user = new User("有参有返回值的返回值","hpht");
                return user;
            }
        });

        startActivity(new Intent(this,SecondActivity.class));
    }


   public static class User{
        private String userName;
        private String phone;

        public User(String userName, String phone) {
            this.userName = userName;
            this.phone = phone;
        }

        @Override
        public String toString() {
            return "User{" +
                    "userName='" + userName + '\'' +
                    ", phone='" + phone + '\'' +
                    '}';
        }
    }
}
