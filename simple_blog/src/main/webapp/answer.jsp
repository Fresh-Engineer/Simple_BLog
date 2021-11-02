<%--
  Created by IntelliJ IDEA.
  User: shxsh
  Date: 2021/11/1
  Time: 23:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>回复</title>
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
    <c:if test="${empty requestScope.blogFatherList}"><c:redirect url="ShowAnswerServlet"/></c:if>
    <c:forEach var="blogFatherList" items="${requestScope.blogFatherList}">
        <div class="blog">
            <div class="blog_input">
                <form class="blog_text" action="UpdateServlet" method="post">
                    <label>
                        <input type="text" placeholder="请输入昵称，不超过十位" readonly="readonly"
                               value="${blogFatherList.user_name}"
                               maxlength="10" autocomplete="off" name="user_name"
                               class="user_name" style="width: 760px">
                    </label>
                    <label>
                        <textarea maxlength="80" rows="2" cols="42" name="blog_content" class="blog_content"
                                  readonly="readonly">${blogFatherList.blog_content}</textarea>
                    </label>
                </form>
            </div>
        </div>
        <div>
            <h1 style="text-align: center">你的回复</h1>
        </div>
        <div class="blog">
            <div class="blog_input">
                <form class="blog_text" action="AddSonServlet" method="post">
                    <label>
                    <textarea maxlength="80" rows="2" cols="42" name="blog" placeholder="请在此输入你的回复"
                              onkeyup="wordStatic(this)" class="blog_content" id="blog" required="required"></textarea>
                        <span id="wordsLength" class="words_length">0/80</span>
                    </label>
                    <label>
                        <input type="text" placeholder="请输入昵称，不超过十位" maxlength="10" autocomplete="off" name="user_name"
                               class="user_name" id="user_name" required="required">
                        <input type="submit" style="color: white" class="blog_sent" value="发送">
                        <input type="button" style="color: white" class="reset" value="重置"
                               onclick="clearTextArea(); this.form.blog.value='';this.form.user_name.value='';">
                        <input name="father_id" type="text" readonly="readonly" value="${blogFatherList.father_id}" hidden="hidden">
                    </label>
                </form>
            </div>
        </div>

    </c:forEach>
</div>

<script src="js/jquery-3.5.1.js"></script>
<script src="js/index.js"></script>
</body>
</html>
