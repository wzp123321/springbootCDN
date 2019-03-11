package com.springboot.demo.entity;

public class Manager {
    private Integer id ;
    private String userId ;
    private String name ;
    private Integer status ;

    public Manager() {
    }

    public Manager(Integer id, String userId, String name, Integer status) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", status=" + status +
                '}';
    }
}
