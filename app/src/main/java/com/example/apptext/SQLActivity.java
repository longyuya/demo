package com.example.apptext;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SQLActivity extends AppCompatActivity {

    private Button createDatabase;
    private Button updateDatabase;
    private Button insert;
    private Button update;
    private Button query;
    private Button delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sql_activity);
        creatView();
        setListener();


    }

    private void creatView(){
        createDatabase = (Button)findViewById(R.id.createDatabase);
        updateDatabase = (Button)findViewById(R.id.updateDatabase);
        insert = (Button)findViewById(R.id.insert);
        update = (Button)findViewById(R.id.update);
        query = (Button)findViewById(R.id.query);
        delete = (Button)findViewById(R.id.delete);
    }
    private void setListener(){
        createDatabase.setOnClickListener(new CreateListener());
        updateDatabase.setOnClickListener(new UpdateListener());
        insert.setOnClickListener(new InsertListener());
        update.setOnClickListener(new ModifyListener());
        query.setOnClickListener(new QueryListener());
        delete.setOnClickListener(new DeleteListener());

    }

    class CreateListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            StuDBHelper dbHelper = new StuDBHelper(SQLActivity.this, "stu_db", null, 1);
            SQLiteDatabase db = dbHelper.getReadableDatabase();
        }
    }

    class UpdateListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            StuDBHelper dbHelper = new StuDBHelper(SQLActivity.this, "stu_db", null, 2);
            SQLiteDatabase db = dbHelper.getReadableDatabase();

        }
    }

    class InsertListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            StuDBHelper dbHelper = new StuDBHelper(SQLActivity.this, "stu_db", null, 2);
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            ContentValues cv = new ContentValues();
            cv.put("id", 1);
            cv.put("sname", "zhangsan");
            cv.put("sage", 18);
            cv.put("ssex", "male");
            db.insert("stu_table", null, cv);
            db.close();

        }
    }
    class QueryListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            StuDBHelper dbHelper = new StuDBHelper(SQLActivity.this, "stu_db", null, 2);
            SQLiteDatabase db = dbHelper.getReadableDatabase();
            Cursor cursor = db.query("stu_table", new String[]{"id", "sname", "sage", "ssex"}, "id=?", new String[]{"1"}, null, null, null);

            while (cursor.moveToNext()) {
                String name = cursor.getString(cursor.getColumnIndex("sname"));
                String age = cursor.getString(cursor.getColumnIndex("sage"));
                String sex = cursor.getString(cursor.getColumnIndex("ssex"));
                System.out.println("query------>"+"姓名："+name+"  "+"年龄："+age+"  "+"性别："+sex);
            }
            db.close();
        }
    }
    class ModifyListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            StuDBHelper dbHelper = new StuDBHelper(SQLActivity.this, "stu_db", null, 2);
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            ContentValues cv = new ContentValues();
            cv.put("sage", "25");
            String whereClause = "id=?";
            String[] whereArgs = {String.valueOf(1)};
            db.update("stu_table", cv, whereClause, whereArgs);

        }
    }

    class DeleteListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            StuDBHelper dbHelper = new StuDBHelper(SQLActivity.this, "stu_db", null, 2);
            SQLiteDatabase db = dbHelper.getReadableDatabase();
            String whereClause = "id=?";
            String[] whereArgs = {String.valueOf(2)};
            db.delete("stu_table", whereClause, whereArgs);
        }
    }

}