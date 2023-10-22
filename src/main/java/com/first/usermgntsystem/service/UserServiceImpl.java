package com.first.usermgntsystem.service;
import com.first.usermgntsystem.entity.User;
import com.first.usermgntsystem.repositoty.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;
    @Override
    public User saveUser(User user) {
        User userEntity = new User();
        BeanUtils.copyProperties(user,userEntity);
        userRepository.save(userEntity);
        return user;
    }
}
