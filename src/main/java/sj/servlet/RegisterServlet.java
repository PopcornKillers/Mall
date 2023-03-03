package sj.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sj.dao.UserDao;
import sj.service.UserDaoImpl;
import sj.beans.User;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doPost(req, resp);
    }
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String name = req.getParameter("name"); //获取jsp页面传过来的参数
        String pwd = req.getParameter("pwd");

        User user = new User(); //实例化一个对象，组装属性
        user.setName(name);
        user.setPwd(pwd);

        UserDao ud = new UserDaoImpl();

        if(ud.register(user)){
            req.setAttribute("username", name);  //向request域中放置参数
            req.getRequestDispatcher("login.jsp").forward(req, resp);  //转发到登录页面
        }else{
            resp.sendRedirect("register.jsp");//重定向到首页
        }
    }
}