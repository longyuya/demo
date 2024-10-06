package com.example.apptext.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.apptext.entity.User;

import java.util.List;

@Dao
public interface UserDao {
    @Query("SELECT * FROM user")
    LiveData<List<User>> getAllUser();

    @Query("SELECT * FROM user WHERE id IN (:userIds)")
    LiveData<User> getUserById(int userIds);


    @Query("SELECT * FROM user WHERE first_name LIKE :name OR last_name LIKE :name")
    LiveData<List<User>> findUsersByName(String name);

    @Insert
    void insert(User user);

    @Query("DELETE FROM user WHERE id = :userIds")
    void deleteUserById(int userIds);

    @Delete
    void delete(User user);

    @Update
    void update(User user);
}