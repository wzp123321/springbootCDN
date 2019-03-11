package com.springboot.demo.mapper;


import com.springboot.demo.entity.Manager;
import com.springboot.demo.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;


public interface UserMapper {
    @Select("select * from user where username = #{username}")
    public User findUserByUsername(String username);

    @Select("select password from user where username = #{username}")
    public String findPwdByUsername(String username);

    @Select("select password from user where userId = #{userId}")
    public String findPwdByUserId(Integer userId);

    @Insert("insert into user(username,password,gender,address,birthday,user_avatar,user_desc,create_user,update_user) values(#{username}," +
            "#{password},#{gender},#{address},#{birthday},#{user_avatar},#{user_desc},#{create_user},#{update_user})")
    public int addUser(String username,String password,Integer gender,String address ,String birthday,String user_avatar,
                       String user_desc,String create_user,String update_user);
    @Update("update user set username=#{username} , birthday = #{birthday} , gender = #{gender} , address = #{address}, user_desc = #{user_desc} where userId = #{userId}")
    public int updateuserinfo(Integer userId ,String username,String birthday,Integer gender ,String address , String user_desc);

    @Update("update user set password = #{newpassword} where userId = #{userId}")
    public int updateuserpwd(Integer userId , String newpassword);

    /*
    以下是测试manager表的sql语句
     */
    @Select("select * from manager")
    public List<Manager> findAllManager();

    // 启用
    @Update("update manager set status =0 where userId = #{userId}")
    public int updateUserCanStatus(String userId);

    // 停用
    @Update("update manager set status =1 where userId = #{userId}")
    public int updateUserNotCanStatus(String userId);

    // 删除
    @Delete("delete from manager where userId = #{userId}")
    public int deleteManger(String userId);

}
