package blog.dao;

import blog.model.BlogFather;

import java.util.List;

public interface BlogFatherDao {
    List<BlogFather> selectAll();
    List<BlogFather> selectByID(int father_id);
    boolean insert(BlogFather blogFather);
    boolean delete(int father_id);
    boolean clear(int father_id);
    boolean update(BlogFather blogFather);
}
