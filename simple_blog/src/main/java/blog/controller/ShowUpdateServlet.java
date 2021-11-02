package blog.controller;

import blog.dao.BlogFatherDao;
import blog.dao.BlogFatherDaoImpl;
import blog.model.BlogFather;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

import static java.lang.System.out;

@WebServlet(name = "ShowUpdateServlet", value = "/ShowUpdateServlet")
public class ShowUpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idStr = request.getParameter("father_id");
        if (idStr!=null&&!idStr.equals("")) {
            int id = Integer.parseInt(idStr);
            BlogFatherDao dao = new BlogFatherDaoImpl();
            List<BlogFather> blogFather = dao.selectByID(id);
            if (blogFather == null) {
                out.println("null");
            } else {
                request.setAttribute("blogFather", blogFather);
                request.getRequestDispatcher("/update.jsp").forward(request,response);
            }
        }
    }
}
