package com.wingsofts.eventbuslite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button mButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EventBusLite.getDefault().register(this);
        mButton = (Button) findViewById(R.id.btn);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EventBusLite.getDefault().post("hi");
            }
        });

    }



    public void onEvent(String str){
        Toast.makeText(MainActivity.this, str, Toast.LENGTH_SHORT).show();
    }
}
