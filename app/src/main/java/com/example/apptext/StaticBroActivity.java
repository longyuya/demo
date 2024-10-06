package com.example.apptext;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class StaticBroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.static_broactivity);
    }
    /*public void sendBC(View view){
        switch (view.getId()){
            case disorder_send_btn:
                sendBroadcast();
                break;

            case R.id.order_send_btn:
                sendOrderedBroadcast();
                break;
        }
    }*/
    public void sendBroadcast(){
        Intent intent = new Intent();
        intent.setAction("com.example.apptext");
        this.sendBroadcast(intent);
    }
    public void sendOrderedBroadcast() {
        Intent intent = new Intent();
        intent.setAction("com.example.apptext");
        this.sendOrderedBroadcast(intent, null);
    }
}