package com.example.apptext;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class MainActivity2 extends AppCompatActivity {
//    ListView listView;
    RecyclerView rv;
    RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv = findViewById(R.id.rv);
        rv.setHasFixedSize(true);
        layoutManager = new GridLayoutManager(this, 2,RecyclerView.VERTICAL,false);
//                new LinearLayoutManager(this);
        rv.setLayoutManager(layoutManager);
        List<Map<String, Object>> datas = new ArrayList<>();
        Map<String, Object> rowmap = new HashMap<>();
        rowmap.put("name", "张三");
        rowmap.put("logo", R.drawable.ic_launcher_background);
        rowmap.put("tel", "tel:18457895682");
        Map<String, Object> rowmap1 = new HashMap<>();
        rowmap1.put("name", "李四");
//        rowmap1.put("logo", R.drawable.qq);
        rowmap1.put("tel", "tel:15895684586");
        Map<String, Object> rowmap2 = new HashMap<>();
        rowmap2.put("name", "王五");
//        rowmap2.put("logo", R.drawable.yx);
        rowmap2.put("tel", "tel:13985685975");

        datas.add(rowmap);
        datas.add(rowmap1);
        datas.add(rowmap2);

        MyAdapter adapter = new MyAdapter(datas);
        rv.setAdapter(adapter);













       /* this.listView = findViewById(R.id.listview);
        List<Map<String, Object>> datas = new ArrayList<>();
        Map<String, Object> rowmap = new HashMap<>();
        rowmap.put("name", "张三");
        rowmap.put("logo", R.drawable.wx);
        rowmap.put("tel", "18457895682");
        Map<String, Object> rowmap1 = new HashMap<>();
        rowmap1.put("name", "李四");
        rowmap1.put("logo", R.drawable.qq);
        rowmap1.put("tel", "15895684586");
        Map<String, Object> rowmap2 = new HashMap<>();
        rowmap2.put("name", "王五");
        rowmap2.put("logo", R.drawable.yx);
        rowmap2.put("tel", "13985685975");

        datas.add(rowmap);
        datas.add(rowmap1);
        datas.add(rowmap2);


        SimpleAdapter simpleAdapter = new SimpleAdapter(this, datas, R.layout.activity_main2, new String[]{"name", "logo","tel"}, new int[]{R.id.text1, R.id.imageView,R.id.tel});

        listView.setAdapter(simpleAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Map<String, Object> map = datas.get(position);
                Toast.makeText(MainActivity2.this, (String)map.get("name"), Toast.LENGTH_SHORT).show();
            }
        });*/
    }
}