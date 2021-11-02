package blog.controller;

import blog.dao.BlogFatherDao;
import blog.dao.BlogFatherDaoImpl;
import blog.model.BlogFather;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class AddServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user_name = request.getParameter("user_name");
        String blog  = request.getParameter("blog");
        BlogFather blogFather = new BlogFather();
        blogFather.setUser_name(new String(user_name.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8));
        blogFather.setBlog_content(new String(blog.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8));
        BlogFatherDao blogFatherDao = new BlogFatherDaoImpl();
        blogFatherDao.insert(blogFather);
        request.getRequestDispatcher("/index.jsp").forward(request,response);
    }
}
