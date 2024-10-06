package com.example.apptext;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.annotation.Nullable;
import androidx.fragment.app.ListFragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ItemFragment extends ListFragment {
    private String[]items = new String[]{"中国","法国","韩国","巴基斯坦","德国"};
    private IItemClickListener itemClickListener;

    public void onAttach(Context context){
        super.onAttach(context);
        try {
            itemClickListener = (IItemClickListener) context;

        }catch (ClassCastException e){
            throw new ClassCastException(context.toString()+"must implement OnArticleSelectedListener");
        }
    }
    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        List<Map<String,String>>datas = new ArrayList<>();
        for (String item:items){
            Map<String,String>map = new HashMap<>();
            map.put("countryName",item);
            datas.add(map);
        }
        SimpleAdapter adapter = new SimpleAdapter(this.getContext(),datas, android.R.layout.simple_list_item_1,new String[]{"countryName"},new int[]{android.R.id.text1});
        this.setListAdapter(adapter);
    }
    public void onListItemClick(ListView l, View v,int position,long id){
        super.onListItemClick(l,v,position,id);
    Map<String,String> item = (Map<String, String>)l.getAdapter().getItem(position);
        String countryName = item.get("countryName");
        itemClickListener.onItemClick(countryName);
    }
        public interface IItemClickListener{
            public void onItemClick(String countryName);
        }
}
