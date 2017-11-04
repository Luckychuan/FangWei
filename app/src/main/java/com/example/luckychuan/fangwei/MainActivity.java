package com.example.luckychuan.fangwei;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Luckychuan on 2017/11/3.
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editText = (EditText) findViewById(R.id.edit_text);
        editText.setText("e9ry5edurfni");
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String code = editText.getText().toString();
                if(code.equals("")){
                    Toast.makeText(MainActivity.this, "防伪码不能为空", Toast.LENGTH_SHORT).show();
                }else if(code.length() != 12){
                    Toast.makeText(MainActivity.this, "输入的防伪码不是12位", Toast.LENGTH_SHORT).show();
                }else{
                    Intent intent = new Intent(MainActivity.this,ResultActivity.class);
                    intent.putExtra("code",code);
                    startActivity(intent);
                }
            }
        });

    }
}
