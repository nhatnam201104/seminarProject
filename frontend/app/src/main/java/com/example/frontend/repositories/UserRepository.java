package com.example.frontend.repositories;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.frontend.api.Api;
import com.example.frontend.api.services.UserService;
import com.example.frontend.models.user.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRepository {
    private final UserService userService;

    public UserRepository() {
        this.userService = Api.createService(UserService.class);
    }

    public MutableLiveData<List<User>> getUsers() {
        MutableLiveData<List<User>> userData = new MutableLiveData<>();

        userService.getUsers().enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    userData.setValue(response.body());
                } else {
                    Log.e("UserRepository", "API error: " + response.code());
                    userData.setValue(null);
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Log.e("UserRepository", "Network error: " + t.getMessage());
                userData.setValue(null);
            }
        });

        return userData;
    }
}
