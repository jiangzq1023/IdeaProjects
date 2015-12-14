<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html>
<body>
<h2>Hello World!</h2>
<shiro:guest><a href="${ctx}/login">login</a></shiro:guest>
<shiro:user>hello, <shiro:principal /><a href="${ctx}/logout">logout</a></shiro:user>

需要登录的页面
</body>
</html>
