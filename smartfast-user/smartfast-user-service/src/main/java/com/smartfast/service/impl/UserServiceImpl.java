package com.smartfast.service.impl;

import com.smartfast.mapper.UserMapper;
import com.smartfast.pojo.User;
import com.smartfast.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User queryUserById(Long id) {

        return this.userMapper.queryUserById(id);
    }

    @Override
    public User queryLast() {
        return this.userMapper.queryLast();
    }

    @Override
    public List<User> queryUsersAsc() {
        return this.userMapper.queryAllWithIdAsc();
    }

    @Override
    public List<User> queryUsersDesc() {
        return this.userMapper.queryAllWithIdDesc();
    }

    @Override
    public void disableUserById(Long id) {
        this.userMapper.disableUserById(id);
    }

    @Override
    public void enableUserById(Long id) {

        this.userMapper.enableUserById(id);
    }

    @Override
    public Boolean queryUserStatusById(Long id) {

        Integer status =  this.userMapper.queryUserStatusById(id);

        if(status == 0){
            return true;
        }
        return false;
    }

    /**
     * 0：禁用
     * 1：启用
     * */
    @Override
    public List<User> queryStatusUsers(Boolean status) {
        int status1 = 0;
        if(status){
            status1 = 1;
        }
        return this.userMapper.queryStatusUsers(status1);
    }
}
