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

@WebServlet("/insert")
public class InsertGoodServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8"); //将编码改为utf-8
        resp.setContentType("text/html;charset=utf-8");

        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        int price = Integer.parseInt(req.getParameter("price"));
        int num = Integer.parseInt(req.getParameter("num"));
        String introduce = req.getParameter("introduce");

        Good good= new Good();
        good.setId(id);
        good.setName(name);
        good.setPrice(price);
        good.setNum(num);
        good.setIntroduce(introduce);
        GoodDao gd = new GoodDaoImpl();

        if(gd.insert(good)){
            req.setAttribute("mess","商品"+name+"添加成功！");
            req.getRequestDispatcher("/admin").forward(req,resp);
        }else {
            resp.sendRedirect("admin.jsp");
        }
    }
}
