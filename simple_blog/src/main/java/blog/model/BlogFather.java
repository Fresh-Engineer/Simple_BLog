package blog.model;

import java.io.Serializable;

public class BlogFather implements Serializable {
    private static final long serialVersionUID = 1L;
    private int father_id;
    private String user_name;
    private String blog_content;
    private String date;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getFather_id() {
        return father_id;
    }
    public void setFather_id(int father_id) {
        this.father_id = father_id;
    }

    public String getUser_name() {
        return user_name;
    }
    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getBlog_content() {
        return blog_content;
    }
    public void setBlog_content(String blog_content) {
        this.blog_content = blog_content;
    }

    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "BlogFather{" +
                "father_id=" + father_id +
                ", user_name='" + user_name + '\'' +
                ", blog_content='" + blog_content + '\'' +
                ", date=" + date +
                '}';
    }
}
