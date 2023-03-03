package sj.dao;

import sj.beans.Cart;

import java.sql.SQLException;
import java.util.List;

public interface CartDao {
    public boolean insert(Cart cart);//添加到购物车
    public List<Cart> getallcart();//获取购物车信息
    public boolean update(Cart cart) throws SQLException;//更新购物车信息
    public boolean search(Cart cart) throws SQLException;//查找购物信息
    public boolean delete(String good);//删除一条记录
}
