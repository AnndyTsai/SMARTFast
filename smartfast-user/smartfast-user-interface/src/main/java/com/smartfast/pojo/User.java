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
    private Integer isEnable;
    //当前用户所属的组
    @ApiModelProperty(value = "当前用户所属的组")
    private Long group;
    //当前用户的角色
    @ApiModelProperty(value = "当前用户的角色")
    private Long role;
    //当前用户的虚拟组
    @ApiModelProperty(value = "当前用户的虚拟组")
    private String virtualGroup;
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
    private String jenkinsCount;
    //当前用户jenkins账号的昵称
    @ApiModelProperty(value = "当前用户jenkins账号的昵称")
    private String jenkinsType;
    //当前用户的企业微信账号id
    @ApiModelProperty(value = "当前用户的企业微信账号id")
    private String weChartCount;
    //当前用户的企业微信绑定的电话号码
    @ApiModelProperty(value = "前用户的企业微信绑定的电话号码")
    private String weChartPhone;
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

    public Integer getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(Integer isEnable) {
        this.isEnable = isEnable;
    }

    public Long getGroup() {
        return group;
    }

    public void setGroup(Long group) {
        this.group = group;
    }

    public Long getRole() {
        return role;
    }

    public void setRole(Long role) {
        this.role = role;
    }

    public String getVirtualGroup() {
        return virtualGroup;
    }

    public void setVirtualGroup(String virtualGroup) {
        this.virtualGroup = virtualGroup;
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

    public String getJenkinsCount() {
        return jenkinsCount;
    }

    public void setJenkinsCount(String jenkinsCount) {
        this.jenkinsCount = jenkinsCount;
    }

    public String getJenkinsType() {
        return jenkinsType;
    }

    public void setJenkinsType(String jenkinsType) {
        this.jenkinsType = jenkinsType;
    }

    public String getWeChartCount() {
        return weChartCount;
    }

    public void setWeChartCount(String weChartCount) {
        this.weChartCount = weChartCount;
    }

    public String getWeChartPhone() {
        return weChartPhone;
    }

    public void setWeChartPhone(String weChartPhone) {
        this.weChartPhone = weChartPhone;
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
                ", isEnable=" + isEnable +
                ", group=" + group +
                ", role=" + role +
                ", virtualGroup='" + virtualGroup + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", headportrait='" + headportrait + '\'' +
                ", jenkinsCount='" + jenkinsCount + '\'' +
                ", jenkinsType='" + jenkinsType + '\'' +
                ", weChartCount='" + weChartCount + '\'' +
                ", weChartPhone='" + weChartPhone + '\'' +
                ", lastload_time=" + lastload_time +
                ", update_time=" + update_time +
                '}';
    }
}
