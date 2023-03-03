package sj.dao;

import sj.beans.Good;

import java.util.List;

public interface GoodDao {

    public boolean insert(Good good);//添加商品信息
    public List<Good> getGoodAll();//返回商品信息集合
    public boolean delete(int ID) ;//根据id删除商品
    public boolean update(Good good);//更新商品信息

}
