package com.example.frontend.api.services;

import com.example.frontend.models.user.User;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface UserService {
    @GET ("users")
    Call<List<User>> getUsers();

}
