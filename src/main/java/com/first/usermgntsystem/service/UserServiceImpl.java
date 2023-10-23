package com.first.usermgntsystem.service;
import com.first.usermgntsystem.entity.User;
import com.first.usermgntsystem.model.UserModel;
import com.first.usermgntsystem.repositoty.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class UserServiceImpl implements UserService{
    private UserRepository userRepository;
    @Override
    public UserModel saveUser(UserModel userModel) {

        // we need to map the user model data to user entity so that we do not expose our entity directly.
        User user = new User();
        BeanUtils.copyProperties(userModel,user);
        userRepository.save(user);
        return userModel;
    }

    @Override
    public List<UserModel> getAllUsers() {

        // we need to get the list of users that we stored in the database and map them into a list of user model
        List<User> users = userRepository.findAll();
        List<UserModel> userModels = users.stream().map(user -> new UserModel(
                user.getId(),
                user.getUserName(),
                user.getUserLastname(),
                user.getUserEmail()
                ))
                .collect(Collectors.toList());


        return userModels;
    }

    @Override
    public UserModel getUserById(long id) {
        User user = userRepository.findById(id).get();
        UserModel userModel = new UserModel();
        BeanUtils.copyProperties(user,userModel);
        return userModel;
    }

    @Override
    public boolean deleteUser(Long id) {
        User user = userRepository.findById(id).get();
        userRepository.delete(user);
        return true;
    }

    @Override
    public UserModel updateUser(Long id, UserModel userModel) {
        User user = userRepository.findById(id).get();
        user.setUserName(userModel.getUserName());
        user.setUserLastname(userModel.getUserLastname());
        user.setUserEmail(userModel.getUserEmail());
        userRepository.save(user);
        return userModel;
    }
}
