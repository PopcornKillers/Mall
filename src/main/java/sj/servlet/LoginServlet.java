package sj.servlet;

import sj.dao.AdminDao;
import sj.service.AdminDaoImpl;
import sj.dao.UserDao;
import sj.service.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {  //需要继承HttpServlet  并重写doGet  doPost方法
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        this.doPost(req, resp);  //将信息使用doPost方法执行   对应jsp页面中的form表单中的method
    }
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("utf-8"); //将编码改为utf-8
        resp.setContentType("text/html;charset=utf-8");

        String name = req.getParameter("name"); //得到jsp页面传过来的参数
        String pwd = req.getParameter("pwd");

        AdminDao ad = new AdminDaoImpl();
        UserDao ud = new UserDaoImpl();
//        登录判断
        if (ud.login(name, pwd)) {
            //向request域中放置信息
            req.setAttribute("success", name);
            req.getRequestDispatcher("/display").forward(req, resp);//转发到displayservlet
        } else if(ad.login(name,pwd)){
            resp.sendRedirect("/admin"); //重定向到后台
        }else {
            req.setAttribute("error",
                    "登录失败，账号或密码不正确！"+
                    "<span>" +
                        "<a href=\"login.jsp\">返回登录页</a>" +
                    "</span>");
            req.getRequestDispatcher("error.jsp").forward(req,resp);
        }


    }

}