package com.example.apptext;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.room.Room;

import android.app.Application;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.apptext.dao.AppDatabase;
import com.example.apptext.dao.UserDao;
import com.example.apptext.entity.User;

import java.util.List;

public class RoomActivity extends AppCompatActivity {
    private UserDao userDao;
    private LiveData<List<User>> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.room_activity);
        userDao = RoomActivity2.getDatabase(this.getApplication()).userDao();
        users = userDao.getAllUser();

        users.observe(this, this::updateUI);

        Button addButton = findViewById(R.id.addButton);
        addButton.setOnClickListener(v -> {
            User newUser = new User("玛卡巴卡", "唔西迪西");
            new Thread(() -> userDao.insert(newUser)).start();
        });

        Button deleteButton = findViewById(R.id.deleteButton);
        deleteButton.setOnClickListener(v -> {
            if (users.getValue() != null && users.getValue().size() > 0) {
                User userToDelete = users.getValue().get(0);
                new Thread(() -> userDao.delete(userToDelete)).start();
            }
        });

        Button updateButton = findViewById(R.id.updateButton);
        updateButton.setOnClickListener(v -> {
            if (users.getValue() != null && users.getValue().size() > 0) {
                User userToUpdate = users.getValue().get(0);
                userToUpdate.setLastName("张三");
                new Thread(() -> userDao.update(userToUpdate)).start();
            }
        });
    }

    private void updateUI(List<User> userList) {
        TextView textView = findViewById(R.id.textView);
        StringBuilder sb = new StringBuilder();
        for (User user : userList) {
            sb.append(user.getFirstName()).append(" ").append(user.getLastName()).append("\n");
        }
        textView.setText(sb.toString());
    }
}