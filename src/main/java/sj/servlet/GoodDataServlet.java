package sj.servlet;

import sj.beans.Good;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/information")
public class GoodDataServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String introduce = req.getParameter("introduce");
        int price = Integer.parseInt(req.getParameter("price"));
        int num = Integer.parseInt(req.getParameter("num"));

        Good good = new Good();
        good.setName(name);
        good.setIntroduce(introduce);
        good.setPrice(price);
        good.setNum(num);

        req.setAttribute("good",good);
        System.out.println(name);
        req.getRequestDispatcher("good.jsp").forward(req,resp);

    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    super.doPost(req,resp);

    }
}
