package com.springboot.demo.controller;

import com.springboot.demo.components.ResultResponseComponent;
import com.springboot.demo.entity.Manager;
import com.springboot.demo.entity.RegResponse;
import com.springboot.demo.entity.User;
import com.springboot.demo.mapper.UserMapper;
import com.springboot.demo.utlis.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Objects;

@CrossOrigin    // 解决前后端分离的跨域问题
@Controller
public class MySpringBootController {

    @Autowired
    UserMapper userMapper;

    @Autowired
    ResultResponseComponent resultResponseComponent;

    @Autowired
    FileUtils fileUtils ;

    private Logger logger = LoggerFactory.getLogger(MySpringBootController.class);


    /**
     * 处理用户注册
     *
     * @param username 页面上传的用户名
     * @param password 页面上传的用户密码
     * @return 响应请求的json数据
     */
    @RequestMapping(value = "/userreg")
    @ResponseBody
    public RegResponse handleUserReg(@RequestParam(value = "username", required = false) String username,
                                     @RequestParam(value = "password", required = false) String password) {
        if (userMapper.findUserByUsername(username) != null) {
            return resultResponseComponent.getFailResult(201, "不好意思！您输入的用户名已被注册", userMapper.findUserByUsername(username));
        } else {
            userMapper.addUser(username, password, 1, "", "", "", "用户很懒，暂无评价", username, username);
            return resultResponseComponent.getSuccessResult("恭喜你!注册成功");
        }

    }

    /**
     * 处理用户登录
     *
     * @param user    用户上传的信息
     * @param session 绑定用户信息的session
     * @return 响应请求的json数据
     */
    @PostMapping(value = "/userlogin")
    @ResponseBody
    public RegResponse handleUserLogin(User user, HttpSession session) {
        if (userMapper.findUserByUsername(user.getUsername()) != null) {
            if (!userMapper.findPwdByUsername(user.getUsername()).equals(user.getPassword())) {
                // 登录失败 输入的密码错误
                return resultResponseComponent.getFailResult(203, "不好意思!您输入的密码错误");
            } else {
                session.setAttribute("user", userMapper.findUserByUsername(user.getUsername()));
                // 登陆成功 并且绑定用户信息
                return resultResponseComponent.getSuccessResult("恭喜您登陆成功", userMapper.findUserByUsername(user.getUsername()));
            }
        } else {
            // 登录失败 输入的用户名不正确
            return resultResponseComponent.getFailResult(202, "不好意思！您输入的用户不存在");
        }
    }

    /**
     * 修改个人相关信息
     *
     * @param user 上传的用户信息
     * @return 响应状态的json数据
     */
    @PostMapping("/updateinfo")
    @ResponseBody
    public RegResponse handleUpdateUserInfo(User user) {
        Integer num = userMapper.updateuserinfo(user.getUserId(), user.getUsername(), user.getBirthday(), user.getGender(), user.getAddress(), user.getUser_desc());

        return resultResponseComponent.getSuccessResult("恭喜您，更新成功", user);
    }

    /**
     * 修改个人密码
     *
     * @param userId      用户id
     * @param oldpassword 旧密码
     * @param newpassword 新密码
     * @return 响应状态的json数据
     */
    @PostMapping("/updateuserpwd")
    @ResponseBody
    public RegResponse handleUpdateUserPwd(Integer userId, String oldpassword, String newpassword) {
        // 先根据用户id查询密码
        String userPwd = userMapper.findPwdByUserId(userId);
        // 对比数据库中的密码和用户输入的旧密码
        if (userPwd.equals(oldpassword)) {
            userMapper.updateuserpwd(userId, newpassword);
            return resultResponseComponent.getSuccessResult("恭喜您！修改成功", newpassword);
        } else {
            return resultResponseComponent.getFailResult(301, "不好意思！原密码错误");
        }
    }
    /**
     * 实现文件上传
     *
     * @param file
     * @return
     */
    @RequestMapping("/updateuserimg")
    @ResponseBody
    public RegResponse handleUserUpdateImg(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
        if (Objects.isNull(file) || file.isEmpty()) {
            return resultResponseComponent.getFailResult(401, "您上传的文件为空！请重新上传");
        }
        String fileName = file.getOriginalFilename(); // 文件名

        fileUtils.HanleUpload(file,fileName);

        return resultResponseComponent.getSuccessResult("恭喜您上传成功！");
    }


    @RequestMapping("/manager/list")
    @ResponseBody
    public RegResponse handlefindManager() {
        List<Manager> managers = userMapper.findAllManager();
        if (managers != null) {
            return resultResponseComponent.getSuccessResult("查询成功", managers);
        } else {
            return resultResponseComponent.getFailResult(405, "查询失败");
        }
    }

    // 启用
    @RequestMapping("/manager/enable")
    @ResponseBody
    public RegResponse handleCanStatus(String userId) {
        int num = userMapper.updateUserCanStatus(userId);
        System.out.println(num);
        return resultResponseComponent.getSuccessResult("更新成功");
    }

    // 停用
    @RequestMapping("/manager/disable")
    @ResponseBody
    public RegResponse handleCanNotStatus(String userId) {
        int num = userMapper.updateUserNotCanStatus(userId);
        System.out.println(num);
        return resultResponseComponent.getSuccessResult("更新成功");
    }

    // 删除
    @RequestMapping("/manager/delete")
    @ResponseBody
    public RegResponse handledelete(String userId) {
        int num = userMapper.deleteManger(userId);
        System.out.println(num);
        return resultResponseComponent.getSuccessResult("更新成功");
    }

}









