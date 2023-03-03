package sj.service;

import sj.dao.AdminDao;
import sj.util.DBconn;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDaoImpl implements AdminDao {

    public boolean login(String name, String pwd) {
        boolean flag = false;
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from admin where name='"+name+"' and pwd='"+pwd+"'");
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
