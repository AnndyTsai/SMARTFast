package com.smartfast.service;

import com.smartfast.common.pojo.PageResult;
import com.smartfast.pojo.User;

import java.util.List;

public interface UserService {

    /**
     * 根据用户id查询用户信息
     * @param id
     * @return
     */
    User queryUserById(Long id);

    /**
     * 查询最后一个user的用户的信息
     * */
    User queryLast();

    /**
     * 升序查询全部User
     * */
    List<User> queryUsersAsc();

    /**
     * 降序查询全部User
     * */
    List<User> queryUsersDesc();

    /**
     * 根据id禁用用户
     * */
    void disableUserById(Long id);

    /**
     * 根据id启用用户
     * */
    void enableUserById(Long id);

    /**
     * 根据id查询用户的isEnable状态
     * */
    Boolean queryUserStatusById(Long id);
    /**
     * 查询启用/禁用状态的用户
     * */
    List<User> queryStatusUsers(Boolean status);
    /**
     * 分页查询、排序、模糊搜索等...
     * */
    PageResult<User> queryUserByPage(Integer page, Integer rows, String sortBy, Boolean desc, String key);
}
