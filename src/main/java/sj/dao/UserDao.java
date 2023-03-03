package sj.dao;

import sj.beans.User;

import java.util.List;

public interface UserDao {
    public boolean login(String name,String pwd);//登录
    public boolean register(User user);//注册
    public List<User> getuserall();//获取用户信息
}