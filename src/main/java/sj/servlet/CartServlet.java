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
import java.util.List;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8"); //将编码改为utf-8
        resp.setContentType("text/html;charset=utf-8");

        CartDao cd = new CartDaoImpl();
        List<Cart> cart = cd.getallcart();
        req.setAttribute("cart",cart);

        req.getRequestDispatcher("cart.jsp").forward(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
