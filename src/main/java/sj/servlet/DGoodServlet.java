package sj.servlet;

import sj.dao.GoodDao;
import sj.service.GoodDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/dgood")
public class DGoodServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8"); //将编码改为utf-8
        resp.setContentType("text/html;charset=utf-8");

        int id = Integer.parseInt(req.getParameter("id"));
        GoodDao good = new GoodDaoImpl();
        if(good.delete(id)){
            req.setAttribute("delete",2);
            req.getRequestDispatcher("/admin").forward(req,resp);
        }else {
            req.setAttribute("error","商品"+id+"删除失败！");
            req.getRequestDispatcher("error.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
