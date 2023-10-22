package com.first.usermgntsystem.service;
import com.first.usermgntsystem.entity.User;
import com.first.usermgntsystem.model.UserModel;
import com.first.usermgntsystem.repositoty.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;



@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    @Override
    public UserModel saveUser(UserModel userModel) {
        User user = new User();
        BeanUtils.copyProperties(userModel,user);
        userRepository.save(user);

        return userModel;
    }
}
