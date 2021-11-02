package blog.controller;

import blog.dao.BlogFatherDao;
import blog.dao.BlogFatherDaoImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class DeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idStr = request.getParameter("father_id");
        if (idStr!=null&&!idStr.equals("")){
            int id = Integer.parseInt(idStr);
            BlogFatherDao dao = new BlogFatherDaoImpl();
            dao.delete(id);
            dao.clear(id);
        }
        request.getRequestDispatcher("/index.jsp").forward(request,response);
    }
}
