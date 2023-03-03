package sj.servlet;

import sj.dao.CartDao;
import sj.service.CartDaoImpl;
import sj.dao.GoodDao;
import sj.service.GoodDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete")
public class DCartServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8"); //将编码改为utf-8
        resp.setContentType("text/html;charset=utf-8");

        String good = req.getParameter("good");
        req.setAttribute("good",good);

        CartDao cd = new CartDaoImpl();
        if(cd.delete(good)){
            req.getRequestDispatcher("/cart").forward(req,resp);
        }else {
            req.setAttribute("error","删除失败！");
            req.getRequestDispatcher("error.jsp").forward(req,resp);
        }

    }
}
