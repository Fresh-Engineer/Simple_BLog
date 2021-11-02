package blog.dao;

import blog.model.BlogSon;

import java.util.List;

public interface BlogSonDao {
    List<BlogSon> selectAll();
    boolean insert(BlogSon blogSon);
    boolean delete(int user_id);
    boolean update(BlogSon blogSon);
    List<BlogSon> selectByID(int user_id);
}
