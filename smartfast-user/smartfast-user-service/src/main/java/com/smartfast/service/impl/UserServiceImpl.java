package com.smartfast.service.impl;

import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.smartfast.common.pojo.PageResult;
import com.smartfast.mapper.UserMapper;
import com.smartfast.pojo.User;
import com.smartfast.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

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
    /**
     * 分页、排序、模糊查询
     * */
    @Override
    public PageResult<User> queryUserByPage(Integer page, Integer rows, String sortBy, Boolean desc, String key) {
        //1.分页
        PageHelper.startPage(page,rows);

        //2.排序
        Example example = new Example(User.class);
        if (StringUtils.isNotBlank(sortBy)){
            example.setOrderByClause(sortBy+(desc? " DESC":" ASC"));
        }
        // 3.查询
        if(StringUtils.isNotBlank(key)) {
            example.createCriteria().orLike("email", key+"%")
                    .orEqualTo("email", key.toUpperCase())
                    .orLike("jenkinstype",key+"%")
                    .orEqualTo("jenkinstype", key.toUpperCase())
                    .orLike("wechartcount",key+"%")
                    .orEqualTo("wechartcount", key.toUpperCase())
                    .orLike("phone",key+"%")
                    .orEqualTo("phone", key.toUpperCase());
        }

        List<User> list = this.userMapper.selectByExample(example);
        //4.创建PageInfo
        PageInfo<User> pageInfo = new PageInfo<>(list);

        //5.返回分页结果
        return new PageResult<>(pageInfo.getTotal(),pageInfo.getPages(),pageInfo.getList());
    }
}
