package com.example.frontend.viewmodels;

import androidx.lifecycle.LiveData;

import androidx.lifecycle.ViewModel;

import com.example.frontend.models.user.User;
import com.example.frontend.repositories.UserRepository;

import java.util.List;

public class UserViewModel extends ViewModel {
    private final UserRepository userRepository;
    private LiveData<List<User>> users;

    public UserViewModel() {
        this.userRepository = new UserRepository();
        this.users = null;
    }

    public LiveData<List<User>> getUsers() {
        if (users == null) {
            users = userRepository.getUsers();
        }
        return users;
    }
}
