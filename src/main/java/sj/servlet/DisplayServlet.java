package sj.servlet;

import sj.beans.Good;
import sj.dao.GoodDao;
import sj.service.GoodDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/display")
public class DisplayServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8"); //将编码改为utf-8
        resp.setContentType("text/html;charset=utf-8");

        GoodDao gd = new GoodDaoImpl();
        List<Good> goods = gd.getGoodAll();
        req.setAttribute("goods",goods);

        for (Good g : (List<Good>) req.getAttribute("goods")) {
            System.out.println(g.getName());
        }
        req.getRequestDispatcher("index.jsp").forward(req,resp);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8"); //将编码改为utf-8
        resp.setContentType("text/html;charset=utf-8");

        GoodDao gd = new GoodDaoImpl();
        List<Good> goods = gd.getGoodAll();
        req.setAttribute("goods",goods);

        for (Good g : (List<Good>) req.getAttribute("goods")) {
            System.out.println(g.getName());
        }
        req.getRequestDispatcher("index.jsp").forward(req,resp);
}
}