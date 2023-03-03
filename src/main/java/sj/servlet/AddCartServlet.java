package sj.servlet;

import sj.beans.Cart;
import sj.dao.CartDao;
import sj.service.CartDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/addcart")
public class AddCartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8"); //将编码改为utf-8
        resp.setContentType("text/html;charset=utf-8");

        String good = req.getParameter("good");
        int num = Integer.parseInt(req.getParameter("num"));
        int price = Integer.parseInt(req.getParameter("price"));

        Cart cart = new Cart();
        cart.setGood(good);
        cart.setNum(num);
        cart.setPrice(price);

        System.out.println(num);

        CartDao cd = new CartDaoImpl();

        try {
            if(cd.search(cart)){
               boolean flag =  cd.update(cart);
               if(flag){
                   req.getRequestDispatcher("/cart").forward(req,resp);
               }else{
                   req.setAttribute("error","商品"+good+"添加到购物车失败！");
                   req.getRequestDispatcher("error.jsp").forward(req,resp);
               }
            }else if(cd.insert(cart)) {
                req.getRequestDispatcher("/cart").forward(req,resp);
            }else{
                req.setAttribute("error","商品"+good+"添加失败！");
                req.getRequestDispatcher("error.jsp").forward(req,resp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

//        if(cd.insert(cart)){
//            req.setAttribute("success","已将商品"+good+"加入购物车！");
//            req.getRequestDispatcher("/cart").forward(req,resp);
//        }else {
//            req.setAttribute("error","商品"+good+"添加失败！");
//            resp.sendRedirect("error.jsp");
//        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }

}
