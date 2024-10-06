package com.example.apptext;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ResultActivity extends AppCompatActivity {
    public static final int RESULTCODE=2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resultactivity_layout);
        Bundle bundle = this.getIntent().getBundleExtra("parameter");
        int first = bundle.getInt("first");
        int second = bundle.getInt("second");
        final int result = first + second;
        Button btnClose = this.findViewById(R.id.button2);
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("result",result);
                setResult(RESULTCODE,intent);
                finish();
            }
        });
    }
}