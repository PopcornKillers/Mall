package sj.service;

import sj.beans.Good;
import sj.beans.User;
import sj.dao.UserDao;
import sj.util.DBconn;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    public boolean register(User user) {
        boolean flag = false;
        DBconn.init();
        int i =DBconn.addUpdDel("insert into user(name,pwd) " +
                "values('"+user.getName()+"','"+user.getPwd()+"')");
        if(i>0){
            flag = true;
        }
        DBconn.closeConn();
        return flag;
    }

    @Override
    public List<User> getuserall() {
        List<User> list = new ArrayList<>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from user");
            while(rs.next()){
                User user = new User();
                user.setName(rs.getString("name"));
                user.setPwd(rs.getString("pwd"));
                list.add(user);
            }
            DBconn.closeConn();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean login(String name, String pwd) {
        boolean flag = false;
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from user where name='"+name+"' and pwd='"+pwd+"'");
            while(rs.next()){
                if(rs.getString("name").equals(name) && rs.getString("pwd").equals(pwd)){
                    flag = true;
                }
            }
            DBconn.closeConn();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }


}