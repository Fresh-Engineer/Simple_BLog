package blog.dao;

import blog.model.BlogFather;
import blog.util.dbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BlogFatherDaoImpl implements BlogFatherDao{
    BlogFather blogFather;
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    String sql;

    /**
     * 查询功能实现
     */
    @Override
    public List<BlogFather> selectAll() {
        List<BlogFather> list = new ArrayList<>();
        sql = "select * from simple_blog.blog_father";
        try {
            connection = dbConnection.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                blogFather = new BlogFather();
                blogFather.setFather_id(resultSet.getInt("father_id"));
                blogFather.setUser_name(resultSet.getString("user_name"));
                blogFather.setBlog_content(resultSet.getString("blog_content"));
                blogFather.setDate(resultSet.getString("date"));

                list.add(blogFather);
            }
            connection.close();
            preparedStatement.close();
            resultSet.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 添加功能实现
     */
    @Override
    public boolean insert(BlogFather blogFather) {
        sql = "insert into simple_blog.blog_father(father_id,user_name,blog_content)" +
                "values(default,?,?)";
        connection = dbConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,blogFather.getUser_name());
            preparedStatement.setString(2,blogFather.getBlog_content());
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
    public boolean delete(int father_id) {
        sql = "delete from simple_blog.blog_father where father_id = ?";
        connection = dbConnection.getConnection();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,father_id);
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
     * 同步删除回复功能实现
     */
    @Override
    public boolean clear(int father_id) {
        sql = "delete from simple_blog.blog_son where father_id = ?";
        connection = dbConnection.getConnection();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,father_id);
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
     * 修改评论功能实现
     */
    @Override
    public boolean update(BlogFather blogFather) {
        sql = "update simple_blog.blog_father set user_name=?, blog_content=? where father_id=?";
        connection = dbConnection.getConnection();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,blogFather.getUser_name());
            preparedStatement.setString(2,blogFather.getBlog_content());
            preparedStatement.setInt(3,blogFather.getFather_id());
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
    public List<BlogFather> selectByID(int father_id) {
        connection = dbConnection.getConnection();
        List<BlogFather>blogFatherList = new ArrayList<>();
        sql = "select * from simple_blog.blog_father where father_id=?";
        BlogFather blogFather = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,father_id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                blogFather = new BlogFather();
                blogFather.setFather_id(resultSet.getInt("father_id"));
                blogFather.setUser_name(resultSet.getString("user_name"));
                blogFather.setBlog_content(resultSet.getString("blog_content"));
                blogFather.setDate(resultSet.getString("date"));
                blogFatherList.add(blogFather);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return blogFatherList;
    }
}
