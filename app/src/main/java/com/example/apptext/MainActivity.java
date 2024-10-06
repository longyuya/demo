package com.example.apptext;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

//Fragment实例
public class MainActivity extends AppCompatActivity implements ItemFragment.IItemClickListener {
    private TextView tvCountry;
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.tvCountry = (TextView) this.findViewById(R.id.tvCountry);
    }

    @Override
    public void onItemClick(String countryName) {
        this.tvCountry.setText(countryName);

    }

//带返回结果的Activity
 /* public class MainActivity extends AppCompatActivity{
   private Button btn;
    private static final int REQUESTCODE=1;
    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.btn = this.findViewById(R.id.btnRes);
        this.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("first",4);
                bundle.putInt("second",5);
                intent.putExtra("parameter",bundle);
                startActivityForResult(intent,REQUESTCODE,bundle);
            }
        });
        this.tv = this.findViewById(R.id.tvResult);
        

    }
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if (requestCode ==REQUESTCODE && resultCode==2){
            int result = data.getIntExtra("result",0);
            this.tv.setText("4+5="+result);
        }
    }*/
/*
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        String []countries = new String[]{"中国","俄罗斯","印度","美国","英国"};
            MyAdapter adapter = new MyAdapter(countries);
            recyclerView.setAdapter(adapter);
    }*/
}