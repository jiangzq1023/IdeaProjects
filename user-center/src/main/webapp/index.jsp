<!DOCTYPE html>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<body>
<h2>Hello World!</h2>
<shiro:guest><a href="${ctx}/login">登录</a></shiro:guest>
<shiro:user>你好, <shiro:principal property="name"/><a href="${ctx}/logout">退出登录</a></shiro:user>

需要登录的页面
</body>
</html>
