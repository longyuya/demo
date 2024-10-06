package com.example.apptext;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class AsyncTaskActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn;
    private ImageView imageasync;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.asymctask_layout);
        this.btn = (Button) this.findViewById(R.id.btn);
        this.imageasync = (ImageView) this.findViewById(R.id.imageasync);
        this.btn.setOnClickListener(this);
    }

    public void onClick(View view){
        DownLoadImageTask downLoadImageTask = new DownLoadImageTask();
        downLoadImageTask.execute("https://tse4-mm.cn.bing.net/th/id/OIP-C.Dm6zUqcCqO6DGu3inYBGEAHaHa?rs=1&pid=ImgDetMain");
    }


    private class DownLoadImageTask extends AsyncTask<String,Void, Bitmap>{
        protected Bitmap doInBackground(String... strings){
            try {
                URL url = new URL(strings[0]);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                InputStream is = urlConnection.getInputStream();
                Bitmap bh = BitmapFactory.decodeStream(is);
                return bh;
            }catch (IOException e){
                e.printStackTrace();
                Log.e("tag","run:"+e.getMessage());
            }
            return null;
        }
        protected void onPostExecute(Bitmap bitmap){
            imageasync.setImageBitmap(bitmap);
        }
    }
}