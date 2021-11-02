package blog.controller;

import blog.dao.BlogSonDao;
import blog.dao.BlogSonDaoImpl;
import blog.model.BlogSon;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static java.lang.System.out;

@WebServlet(name = "ShowUpdateSonServlet", value = "/ShowUpdateSonServlet")
public class ShowUpdateSonServlet extends HttpServlet {
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
            List<BlogSon> blogSonList = dao.selectByID(id);
            if (blogSonList == null){
                out.println("null");
            } else {
                request.setAttribute("blogSonList",blogSonList);
                request.getRequestDispatcher("/update_son.jsp").forward(request,response);
            }
        }
    }
}
