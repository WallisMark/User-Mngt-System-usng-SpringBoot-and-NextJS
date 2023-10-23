package com.first.usermgntsystem.service;
import com.first.usermgntsystem.model.UserModel;

import java.util.List;

public interface UserService {
    UserModel saveUser(UserModel userModel);

    List<UserModel> getAllUsers();

    UserModel getUserById(long id);

    boolean deleteUser(Long id);

    UserModel updateUser(Long id, UserModel userModel);
}