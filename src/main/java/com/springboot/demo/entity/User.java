package com.springboot.demo.entity;



public class User {
    private Integer userId ;
    private String username ;
    private String password ;
    private Integer gender ;
    private String address ;
    private String birthday ;
    private String user_avatar ;
    private String user_desc ; // 自我描述
    private String create_user ;
    private String update_user ;

    public User() {
    }

    public User(String username, String password, String create_user, String update_user) {
        this.username = username;
        this.password = password;
        this.create_user = create_user;
        this.update_user = update_user;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", gender=" + gender +
                ", address='" + address + '\'' +
                ", birthday='" + birthday + '\'' +
                ", user_avatar='" + user_avatar + '\'' +
                ", user_desc='" + user_desc + '\'' +
                ", create_user='" + create_user + '\'' +
                ", update_user='" + update_user + '\'' +
                '}';
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public User(String username, String password, Integer gender, String address, String birthday, String user_avatar, String user_desc, String create_user, String update_user) {
        this.username = username;
        this.password = password;
        this.gender = gender;
        this.address = address;
        this.birthday = birthday;
        this.user_avatar = user_avatar;
        this.user_desc = user_desc;
        this.create_user = create_user;
        this.update_user = update_user;
    }

    public User(Integer userId, String username, String password, Integer gender, String address, String birthday, String user_avatar, String user_desc, String create_user, String update_user) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.gender = gender;
        this.address = address;
        this.birthday = birthday;
        this.user_avatar = user_avatar;
        this.user_desc = user_desc;
        this.create_user = create_user;
        this.update_user = update_user;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUser_avatar() {
        return user_avatar;
    }

    public void setUser_avatar(String user_avatar) {
        this.user_avatar = user_avatar;
    }

    public String getUser_desc() {
        return user_desc;
    }

    public void setUser_desc(String user_desc) {
        this.user_desc = user_desc;
    }

    public String getCreate_user() {
        return create_user;
    }

    public void setCreate_user(String create_user) {
        this.create_user = create_user;
    }

    public String getUpdate_user() {
        return update_user;
    }

    public void setUpdate_user(String update_user) {
        this.update_user = update_user;
    }

}
