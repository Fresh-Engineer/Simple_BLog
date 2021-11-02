package blog.controller;

import blog.dao.BlogSonDao;
import blog.dao.BlogSonDaoImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class DeleteSonServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idStr = request.getParameter("user_id");
        if (idStr!=null&&!idStr.equals("")){
            int id = Integer.parseInt(idStr);
            BlogSonDao dao = new BlogSonDaoImpl();
            dao.delete(id);
        }
        request.getRequestDispatcher("/index.jsp").forward(request,response);
    }
}
