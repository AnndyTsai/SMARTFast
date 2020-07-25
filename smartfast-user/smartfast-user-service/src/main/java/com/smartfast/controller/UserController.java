/**
 * 用户，账号相关
 * @ smartfast 2020.07.22
 * @auhtor yangbin
 * */
package com.smartfast.controller;

import com.smartfast.common.pojo.PageResult;
import com.smartfast.pojo.User;
import com.smartfast.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "用户服务接口文档")
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 根据用户id查询用户信息
     * @param id
     * @return
     */
    @ApiOperation(value = "根据Id查询用户信息")
    @ApiImplicitParam(name = "id",paramType ="form",value = "用户id主键", required = true, dataType = "Long")
    @GetMapping("/query")
    public ResponseEntity<User> queryUserById(@RequestParam("id") Long id){

        //如果id为-1,则查询Id最大的User
        if (id == -1){
            User last = this.userService.queryLast();
            return ResponseEntity.ok(last);
        }
        else {
            User user = this.userService.queryUserById(id);
            if (user == null) {
                //没有找到返回404
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
            //找到返回200
            return ResponseEntity.ok(user);
        }
    }
    /**
     * 升序 降序查询全部User用户
     * @param sort ASC：升序 DESC：降序
     * @return
     * */
    @ApiOperation(value = "根据全部用户信息")
    @ApiImplicitParam(name = "sort",paramType ="form",value = "排序(ASC升序、DESC降序)", required = true, dataType = "String")
    @GetMapping("/queryAll")
    public ResponseEntity<List<User>> queryAllUsers(@RequestParam("sort") String sort){
        ResponseEntity<List<User>> body = null;
        if(sort.equalsIgnoreCase("ASC")){
            body = ResponseEntity.ok(this.userService.queryUsersAsc());
        }
        else if(sort.equalsIgnoreCase("DESC")){

            body = ResponseEntity.ok(this.userService.queryUsersDesc());

        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return body;
    }

    /**
     * 启用/禁用用户 如果是启用状态访问则变为禁用状态；如果是禁用状态访问则变成启用状态
     * @param enabled true:启用 false：禁用
     * */
    @ApiOperation("根据Id修改用户的状态")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "enabled",paramType ="form",value = "用户isEnable状态 true/false", required = true , dataType = "Boolean"),
            @ApiImplicitParam(name = "id",paramType ="form",value = "用户主键id", required = true, dataType = "Long")
    })
    @GetMapping("/isEnable")
    public ResponseEntity<Boolean> enableOrDisableUser(@RequestParam("enabled") boolean enabled,@RequestParam("id") Long id){

        if(enabled){
            //启用状态变禁用
            this.userService.disableUserById(id);
        }else {
            //禁用状态变启用
            this.userService.enableUserById(id);
        }
        return ResponseEntity.ok(this.userService.queryUserStatusById(id));
    }

    /**
     * 查询被禁用/启用的用户
     * */
    @ApiOperation(value = "查询启用/禁用的用户")
    @ApiImplicitParam(name = "status",paramType ="form",value = "用户启用状态 true/false", required = true, dataType = "Boolean")
    @GetMapping("/queryStatusUsers")
    public ResponseEntity<List<User>> queryUserById(@RequestParam("status") Boolean status){

        return ResponseEntity.ok(this.userService.queryStatusUsers(status));
    }

    /**
     * 分页查询，模糊检索，排序
     * @param page：第几页
     * @param rows：每页大小
     * @param sortBy：按照什么排序
     * @param desc：降序还是升序
     * @param key：搜索关键字
     * */
    @ApiOperation(value = "分页查询用户/排序/模糊查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page",paramType ="form",value = "页码", defaultValue = "1"),
            @ApiImplicitParam(name = "rows",paramType ="form",value = "每页展示条数", defaultValue = "5"),
            @ApiImplicitParam(name = "sortBy",paramType ="form",value = "排序字段", dataType = "String"),
            @ApiImplicitParam(name = "desc",paramType ="form",value = "排序方式,升序/降序", defaultValue = "false", dataType = "String"),
            @ApiImplicitParam(name = "key",paramType ="form",value = "搜索关键字", dataType = "String")
    })
    @GetMapping("/queryUsers")
    public ResponseEntity<PageResult<User>> queryUsersModel(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "rows", defaultValue = "5") Integer rows,
            @RequestParam(value = "sortBy", required = false) String sortBy,
            @RequestParam(value = "desc", defaultValue = "false") Boolean desc,
            @RequestParam(value = "key", required = false) String key
    ){
        PageResult<User> result = this.userService.queryUserByPage(page,rows,sortBy,desc,key);
        if(result == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(result);
    }
}
