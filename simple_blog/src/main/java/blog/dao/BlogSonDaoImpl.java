package blog.dao;

import blog.model.BlogSon;
import blog.util.dbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BlogSonDaoImpl implements BlogSonDao{
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    String sql;

    /**
     * 查询功能实现
     */
    @Override
    public List<BlogSon> selectAll() {
        List<BlogSon> list = new ArrayList<>();
        connection = dbConnection.getConnection();
        sql = "select * from simple_blog.blog_son";
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                BlogSon blogSon = new BlogSon();
                blogSon.setUser_id(resultSet.getInt("user_id"));
                blogSon.setFather_id(resultSet.getInt("father_id"));
                blogSon.setSon_name(resultSet.getString("son_name"));
                blogSon.setBlog_content(resultSet.getString("blog_content"));
                blogSon.setDate(resultSet.getString("date"));
                list.add(blogSon);
            }
            resultSet.close();
            preparedStatement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 添加功能实现
     */
    @Override
    public boolean insert(BlogSon blogSon) {
        sql = "insert into simple_blog.blog_son(user_id,father_id,son_name,blog_content)" +
                "values(default,?,?,?)";
        connection = dbConnection.getConnection();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,blogSon.getFather_id());
            preparedStatement.setString(2,blogSon.getSon_name());
            preparedStatement.setString(3,blogSon.getBlog_content());
            int count = preparedStatement.executeUpdate();
            preparedStatement.close();
            return count > 0;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 删除功能实现
     */
    @Override
    public boolean delete(int user_id) {
        sql = "delete from simple_blog.blog_son where user_id=?";
        connection = dbConnection.getConnection();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,user_id);
            int count = 0;
            count = preparedStatement.executeUpdate();
            preparedStatement.close();
            return count > 0;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    /**
     * 修改功能的实现
     */
    @Override
    public boolean update(BlogSon blogSon) {
        sql = "update simple_blog.blog_son set son_name=?, blog_content=? where user_id=?";
        connection = dbConnection.getConnection();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,blogSon.getSon_name());
            preparedStatement.setString(2,blogSon.getBlog_content());
            preparedStatement.setInt(3,blogSon.getUser_id());
            int count = 0;
            count = preparedStatement.executeUpdate();
            preparedStatement.close();
            return count > 0;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 通过id号查询功能实现
     */
    @Override
    public List<BlogSon> selectByID(int user_id) {
        List<BlogSon>blogSonList = new ArrayList<>();
        connection = dbConnection.getConnection();
        sql = "select * from simple_blog.blog_son where user_id=?";
        BlogSon blogSon = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,user_id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                blogSon = new BlogSon();
                blogSon.setUser_id(resultSet.getInt("user_id"));
                blogSon.setFather_id(resultSet.getInt("father_id"));
                blogSon.setSon_name(resultSet.getString("son_name"));
                blogSon.setBlog_content(resultSet.getString("blog_content"));
                blogSon.setDate(resultSet.getString("date"));
                blogSonList.add(blogSon);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return blogSonList;
    }
}
