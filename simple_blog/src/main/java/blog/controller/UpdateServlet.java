package blog.controller;

import blog.dao.BlogFatherDao;
import blog.dao.BlogFatherDaoImpl;
import blog.model.BlogFather;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class UpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user_name = request.getParameter("user_name");
        String blog_content = request.getParameter("blog_content");
        String idStr = request.getParameter("father_id");
        BlogFather blogFather = new BlogFather();
        blogFather.setFather_id(Integer.parseInt(idStr));
        blogFather.setUser_name(new String(user_name.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8));
        blogFather.setBlog_content(new String(blog_content.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8));
        BlogFatherDao dao = new BlogFatherDaoImpl();
        dao.update(blogFather);
        request.getRequestDispatcher("/index.jsp").forward(request,response);
    }
}
