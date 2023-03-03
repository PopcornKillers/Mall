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

@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8"); //将编码改为utf-8
        resp.setContentType("text/html;charset=utf-8");

        int id = Integer.parseInt(req.getParameter("id"));
        int num = Integer.parseInt(req.getParameter("num"));
        String name = req.getParameter("name");
        int price = Integer.parseInt(req.getParameter("price"));

        Good good = new Good();
        good.setId(id);
        good.setName(name);
        good.setNum(num);
        good.setPrice(price);

        GoodDao gd = new GoodDaoImpl();

        if(gd.update(good)){
            req.setAttribute("update",3);
            req.getRequestDispatcher("/admin").forward(req,resp);
        }else {
            resp.getWriter().println("失败啦！！！");
        }

        System.out.println(id + " " + num);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
