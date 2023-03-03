package sj.service;

import sj.beans.Good;
import sj.dao.GoodDao;
import sj.util.DBconn;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GoodDaoImpl implements GoodDao {
    @Override
    public boolean insert(Good good) {
        boolean flag = false;
        DBconn.init();
        int i = DBconn.addUpdDel("insert into good(id,name,price,num,introduce) " +
                "values('"+good.getId()+"','"+good.getName()+"','"+good.getPrice()+"','"+good.getNum()+"','"+good.getIntroduce()+"')");
        if (i>0){
            flag = true;
        }
        DBconn.closeConn();
        return flag;
    }

    public List<Good> getGoodAll() {
        List<Good> list = new ArrayList<>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from good");
            while(rs.next()){
                Good good = new Good();
                good.setId(rs.getInt("id"));
                good.setName(rs.getString("name"));
                good.setPrice(rs.getInt("price"));
                good.setIntroduce(rs.getString("introduce"));
                good.setNum(rs.getInt("num"));
                list.add(good);
            }
            DBconn.closeConn();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //更新商品信息
    @Override
    public boolean update(Good good) {
        boolean flag = false;
        DBconn.init();
        String sql ="update good set name = '"+good.getName()
                +"', num = '" +good.getNum()
                +"', price = '"+good.getPrice()
                +"' where id = "+good.getId();
        int i =DBconn.addUpdDel(sql);
        if(i>0){
            flag = true;
        }
        DBconn.closeConn();
        return flag;
    }


    public boolean delete(int id) {
        boolean flag = false;
        DBconn.init();
        String sql = "delete from good where id="+id;
        int i =DBconn.addUpdDel(sql);
        if(i>0){
            flag = true;
        }
        DBconn.closeConn();
        return flag;
    }

}
