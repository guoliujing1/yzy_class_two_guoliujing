package com.example.book;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MM extends AppCompatActivity {

    Button register;
    EditText user_name,pass_word,pass_word2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mm);
        init();
    }
    private void init() {
        register = findViewById(R.id.register);

        user_name = findViewById(R.id.user_name);
        pass_word = findViewById(R.id.pass_word);
        pass_word2 = findViewById(R.id.pass_word2);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (pass_word.getText().toString().equals("") && pass_word.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"密码不能为空",Toast.LENGTH_SHORT).show();
                }else if(pass_word.getText().toString().equals(pass_word2.getText().toString())){
                    Toast.makeText(getApplication(),"注册成功",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MM.this, TT.class);
                    intent.putExtra("username", user_name.getText().toString());
                    intent.putExtra("password", pass_word.getText().toString());
                    startActivity(intent);
                }else if (pass_word.equals("") != pass_word2.equals("")){
                    Toast.makeText(getApplication(),"密码不一致，请重新输入",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
