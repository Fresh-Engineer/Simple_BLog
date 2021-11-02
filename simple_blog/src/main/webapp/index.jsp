<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>留言板</title>
    <style>
        * {
            padding: 0;
            margin: 0;
        }
    </style>
    <link rel="stylesheet" href="css/index.css">
</head>
<body>
<div id="push">
    <h1>我的留言板</h1>
    <marquee direction="left" style="margin: 0 150px; width: 1503px; background: darkgrey" scrollamount="20"
             onmouseout="this.start()" onmouseover="this.stop()">大家好！文明留言，从我做起！
    </marquee>
    <div class="blog">
        <div class="blog_input">
            <form class="blog_text" action="AddServlet" method="post">
                <label>
                    <textarea maxlength="80" rows="2" cols="42" name="blog" placeholder="说点什么吧"
                              onkeyup="wordStatic(this)" class="blog_content" id="blog" required="required"></textarea>
                    <span id="wordsLength" class="words_length">0/80</span>
                </label>
                <label>
                    <input type="text" placeholder="请输入昵称，不超过十位" maxlength="10" autocomplete="off" name="user_name"
                           class="user_name" id="user_name" required="required">
                    <input type="submit" style="color: white" class="blog_sent" value="发送">
                    <input type="button" style="color: white" class="reset" value="重置"
                           onclick="clearTextArea(); this.form.blog.value='';this.form.user_name.value='';">
                </label>
            </form>
        </div>
    </div>

    <div class="blog_body">
        <ul id="ul">
            <c:if test="${empty requestScope.list}"><c:redirect url="ShowServlet"/></c:if>
            <c:forEach items="${requestScope.list}" var="list">
                <li>
                    <div class="blog_father">
                        <h3>${list.user_name}</h3>
                        <p>${list.blog_content}</p>
                        <span>时间： ${list.date}</span>
                        <div class="blog_bottom">
                            <a href="ShowAnswerServlet?father_id=${list.father_id}">回复</a>
                            <a href="ShowUpdateServlet?father_id=${list.father_id}">编辑</a>
                            <a href="DeleteServlet?father_id=${list.father_id}">删除</a>
                        </div>
                        <ul class="blog_son">
                            <c:forEach var="sonList" items="${requestScope.sonlist}">
                                <c:if test="${sonList.father_id==list.father_id}">
                                    <li>
                                        <h3>${sonList.son_name}</h3>
                                        <p>${sonList.blog_content}</p>
                                        <span style="padding: 10px 0">时间： ${sonList.date}</span>
                                        <div class="blog_bottom2">
                                            <a href="ShowUpdateSonServlet?user_id=${sonList.user_id}">编辑</a>
                                            <a href="DeleteSonServlet?user_id=${sonList.user_id}">删除</a>
                                        </div>
                                    </li>
                                </c:if>
                            </c:forEach>
                        </ul>
                    </div>
                </li>
            </c:forEach>
        </ul>
    </div>


    <script src="js/jquery-3.5.1.js"></script>
    <script src="js/index.js"></script>
</div>
</body>
</html>