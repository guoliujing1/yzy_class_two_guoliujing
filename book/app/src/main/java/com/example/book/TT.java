package com.example.book;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TT extends AppCompatActivity {
    private EditText editText1;
    private EditText editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tt);

        TextView userName=findViewById(R.id.username);
        TextView password=findViewById(R.id.password);
        Button bt1 = findViewById(R.id.login);
        Button bt2 = findViewById(R.id.register);

        String userName_1 = getIntent().getStringExtra("userName_1");
        String password_2 = getIntent().getStringExtra("password_2");
        userName.setText(userName_1);
        password.setText(password_2);

        bt1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                editText1 = findViewById(R.id.username);
                editText2 = findViewById(R.id.password);
                String u = editText1.getText().toString();
                String p = editText2.getText().toString();
                Toast.makeText(TT.this,u + p,Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(TT.this, com.example.book.MyDatabaseHelper.class);
                startActivity(intent);
            }
        });
        bt2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(TT.this, com.example.book.MM.class);
                startActivity(intent);
            }
        });
    }
}
