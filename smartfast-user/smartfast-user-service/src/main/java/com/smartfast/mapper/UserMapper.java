package com.smartfast.mapper;

import com.smartfast.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.additional.idlist.SelectByIdListMapper;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface UserMapper extends Mapper<User>, SelectByIdListMapper<User,Integer> {

    /**
     * 根据id查询User对象
     * */
    @Select("SELECT * FROM user WHERE id = #{id}")
    User queryUserById(@Param("id") Long id);

    /**
     * 查询id最大的User
     * */
    @Select("select * FROM user ORDER BY id DESC LIMIT 1")
    User queryLast();

    /**
     * 查询全部用户按照id降序排列
     * */
    @Select("select * FROM user ORDER BY id DESC")
    List<User> queryAllWithIdDesc();

    /**
     * 查询全部用户按照id降序排列
     * */
    @Select("select * FROM user ORDER BY id ASC")
    List<User> queryAllWithIdAsc();

    /**
     * 启用用户
     * */
    @Update("UPDATE `user` SET isEnable = 1 WHERE id = #{id}")
    void disableUserById(@Param("id") Long id);

    /**
     * 禁用用户
     * */
    @Update("UPDATE `user` SET isEnable = 0 WHERE id = #{id}")
    void enableUserById(@Param("id") Long id);

    /**
     * 根据用户id查询enable状态
     * */
    @Select("SELECT isEnable FROM user WHERE id = #{id}")
    Integer queryUserStatusById(@Param("id") Long id);
    /**
     * 根据用户状态查询用户
     * */
    @Select("SELECT * from user WHERE isEnable = #{status}")
    List<User> queryStatusUsers(int status);
}
