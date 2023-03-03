package sj.service;

import sj.beans.Cart;
import sj.beans.Good;
import sj.dao.CartDao;
import sj.util.DBconn;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CartDaoImpl implements CartDao {
    @Override
    public boolean insert(Cart cart) {
        boolean flag = false;
        DBconn.init();
        int i = DBconn.addUpdDel("insert into cart(id,good,num,price)" +
                "values('"+cart.getId()+"','"+cart.getGood()+"','"+cart.getNum()+"','"+cart.getPrice()+"')");
        if (i>0){
            flag = true;
        }
        DBconn.closeConn();
        return flag;
    }

    @Override
    public List<Cart> getallcart() {
        List<Cart> list = new ArrayList<>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from cart");
            while(rs.next()){
                Cart cart = new Cart();
                cart.setGood(rs.getString("good"));
                cart.setNum(rs.getInt("num"));
                cart.setPrice(rs.getInt("price"));
                list.add(cart);
            }
            DBconn.closeConn();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean update(Cart cart){
        boolean flag = false;
        DBconn.init();
        String sql = "update cart set num ='"+cart.getNum()
                +"', price ='"+cart.getPrice()
                +"' where good ='"+cart.getGood()+"'";
        int i = DBconn.addUpdDel(sql);
        if(i>0){
            flag = true;
        }
        DBconn.closeConn();
        return flag;
    }

    @Override
    public boolean search(Cart cart) throws SQLException {
        boolean flag = false;
        DBconn.init();
        ResultSet rs =DBconn.selectSql("select * from cart");
        while(rs.next()){
            if(cart.getGood().equals(rs.getString("good"))) {
                flag = true;
            }
        }
        return flag;
    }

    @Override
    public boolean delete(String good) {
        boolean flag = false;
        DBconn.init();
        String sql = "delete from cart where good ='"+good+"'";
        int i = DBconn.addUpdDel(sql);
        if(i>0){
            flag = true;
        }
        return flag;
    }

}
