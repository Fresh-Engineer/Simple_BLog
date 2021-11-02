package blog.controller;

import blog.dao.BlogFatherDao;
import blog.dao.BlogFatherDaoImpl;
import blog.dao.BlogSonDao;
import blog.dao.BlogSonDaoImpl;
import blog.model.BlogFather;
import blog.model.BlogSon;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static java.lang.System.out;

public class ShowServlet extends HttpServlet {
    private static final long serialVerionUID = 1L;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        BlogFatherDao dao = new BlogFatherDaoImpl();
        List<BlogFather> list = dao.selectAll();
        BlogSonDao blogSonDao = new BlogSonDaoImpl();
        List<BlogSon> sonList = blogSonDao.selectAll();
        if (list == null && sonList == null) {
            out.println("null");
        } else {
            if (sonList!=null) {
                request.setAttribute("sonlist", sonList);
            }
            if (list!=null) {
                request.setAttribute("list", list);
            }
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }
}
