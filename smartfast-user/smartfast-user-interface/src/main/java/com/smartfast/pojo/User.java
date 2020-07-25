/**
 * yangbin 2020.7.22
 * @ smartfast project
 * */
package com.smartfast.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

// 改实体对应数据库的表名称是"user"
@ApiModel(value = "用户")
@Table(name="user")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @ApiModelProperty(value = "用户id")
    private Long id;
    //标识当前用户是否被禁用
    @ApiModelProperty(value = "标识当前用户是否被禁用")
    private Integer isenable;
    //当前用户所属的组
    @ApiModelProperty(value = "当前用户所属的组")
    private Long groups;
    //当前用户的角色
    @ApiModelProperty(value = "当前用户的角色")
    private Long role;
    //当前用户的虚拟组
    @ApiModelProperty(value = "当前用户的虚拟组")
    private String virtualgroup;
    //当前用户的邮箱地址 作为登录系统的账号使用
    @ApiModelProperty(value = "当前用户的邮箱地址 作为登录系统的账号使用")
    private String email;
    //当前用户的密码
    @ApiModelProperty(value = "当前用户的密码")
    private String password;
    //当前用户的头像
    @ApiModelProperty(value = "当前用户的头像")
    private String headportrait;
    //当前用户对应的jenkins账号
    @ApiModelProperty(value = "当前用户对应的jenkins账号")
    private String jenkinscount;
    //当前用户jenkins账号的昵称
    @ApiModelProperty(value = "当前用户jenkins账号的昵称")
    private String jenkinstype;
    //当前用户的企业微信账号id
    @ApiModelProperty(value = "当前用户的企业微信账号id")
    private String wechartcount;
    //当前用户的企业微信绑定的电话号码
    @ApiModelProperty(value = "前用户的企业微信绑定的电话号码")
    private String phone;
    //最后一次登录时间
    @ApiModelProperty(value = "最后一次登录时间")
    private Date lastload_time;
    //最近的账号更新时间
    @ApiModelProperty(value = "最近的账号更新时间")
    private Date update_time;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getIsenable() {
        return isenable;
    }

    public void setIsenable(Integer isenable) {
        this.isenable = isenable;
    }

    public Long getGroups() {
        return groups;
    }

    public void setGroups(Long groups) {
        this.groups = groups;
    }

    public Long getRole() {
        return role;
    }

    public void setRole(Long role) {
        this.role = role;
    }

    public String getVirtualgroup() {
        return virtualgroup;
    }

    public void setVirtualgroup(String virtualgroup) {
        this.virtualgroup = virtualgroup;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHeadportrait() {
        return headportrait;
    }

    public void setHeadportrait(String headportrait) {
        this.headportrait = headportrait;
    }

    public String getJenkinscount() {
        return jenkinscount;
    }

    public void setJenkinscount(String jenkinscount) {
        this.jenkinscount = jenkinscount;
    }

    public String getJenkinstype() {
        return jenkinstype;
    }

    public void setJenkinsType(String jenkinstype) {
        this.jenkinstype = jenkinstype;
    }

    public String getWechartcount() {
        return wechartcount;
    }

    public void setWechartcount(String wechartcount) {
        this.wechartcount = wechartcount;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getLastload_time() {
        return lastload_time;
    }

    public void setLastload_time(Date lastload_time) {
        this.lastload_time = lastload_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", isenable=" + isenable +
                ", group=" + groups +
                ", role=" + role +
                ", virtualgroup='" + virtualgroup + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", headportrait='" + headportrait + '\'' +
                ", jenkinscount='" + jenkinscount + '\'' +
                ", jenkinsType='" + jenkinstype + '\'' +
                ", wechartcount='" + wechartcount + '\'' +
                ", phone='" + phone + '\'' +
                ", lastload_time=" + lastload_time +
                ", update_time=" + update_time +
                '}';
    }
}
