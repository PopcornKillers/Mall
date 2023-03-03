package sj.servlet;

import sj.beans.Good;
import sj.beans.User;
import sj.dao.GoodDao;
import sj.dao.UserDao;
import sj.service.GoodDaoImpl;
import sj.service.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin")
public class AdminServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8"); //将编码改为utf-8
        resp.setContentType("text/html;charset=utf-8");

        GoodDao gd = new GoodDaoImpl();
        List<Good> goods = gd.getGoodAll();
        req.setAttribute("goods",goods);

        UserDao u = new UserDaoImpl();
        List<User> user = u.getuserall();

        req.setAttribute("user",user);



        for (Good g : (List<Good>) req.getAttribute("goods")) {
            System.out.println(g.getName());
        }
        req.getRequestDispatcher("admin.jsp").forward(req,resp);
    }
}
