/*
package com.example.apptext;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private String[] mDataset;
    public MyAdapter(String[] myDataset) {
        mDataset = myDataset;
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public MyViewHolder(TextView v) {
            super(v);
            textView = v;
        }
    }
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        TextView v = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(android.R.layout.simple_list_item_1, viewGroup, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }
    public void onBindViewHolder(@NonNull MyViewHolder viewHolder, int i) {
        viewHolder.textView.setText(mDataset[i]);
    }
    public int getItemCount() {
        return mDataset.length;
    }

}
*/
package com.example.apptext;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Map;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder>{
private List<Map<String,Object>> datas;
public MyAdapter(List<Map<String,Object>> datas){
    this.datas=datas;
}

@NonNull
@Override
public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
    View view = layoutInflater.inflate(R.layout.activity_main2,parent,false);
    TextView tvName = view.findViewById(R.id.text1);
    ImageView imageView = view.findViewById(R.id.imageView);
    TextView tvTel = view.findViewById(R.id.tel);
    MyViewHolder viewHolder = new MyViewHolder(view,tvName,imageView,tvTel);
    return viewHolder;
}

@Override
public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
    Map<String,Object> row = this.datas.get(position);
    holder.tvName.setText((String)row.get("name"));
//    holder.imageView.setImageDrawable((Drawable)row.get("logo"));
    holder.tvTel.setText((String)row.get("tel"));
}
    @Override
    public int getItemCount() {
        return this.datas.size();
    }
}
class MyViewHolder extends RecyclerView.ViewHolder{
    public TextView tvName;
    public ImageView imageView;
    public TextView tvTel;

    public MyViewHolder(@NonNull View itemView, TextView tvName, ImageView imageView, TextView tvTel) {
        super(itemView);
        this.tvName = tvName;
        this.imageView = imageView;
        this.tvTel = tvTel;
    }
}