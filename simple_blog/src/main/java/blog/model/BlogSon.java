package blog.model;

import java.io.Serializable;

public class BlogSon implements Serializable {
    private  static final long serialVersionUID = 1L;
    private int user_id;
    private int father_id;
    private String son_name;
    private String blog_content;
    private String date;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getUser_id() {
        return user_id;
    }
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getFather_id() {
        return father_id;
    }
    public void setFather_id(int father_id) {
        this.father_id = father_id;
    }

    public String getSon_name() {
        return son_name;
    }
    public void setSon_name(String son_name) {
        this.son_name = son_name;
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
        return "BlogSon{" +
                "user_id=" + user_id +
                ", father_id=" + father_id +
                ", son_name='" + son_name + '\'' +
                ", blog_content='" + blog_content + '\'' +
                ", date=" + date +
                '}';
    }
}
