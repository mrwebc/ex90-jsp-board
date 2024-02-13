
<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
<body>
    <div id="wrap">
        <%@include file="./fragment/header.jsp" %>
    	
    	<section>
    		<h2>Home Page</h2>
            <ul>
                <li><a href="${contextPath}/board/register.jsp">게시글 등록</a></li>
                <li><a href="${contextPath}/board/listAll.do">listAll(목록보기-전체게시물)</a></li>
                <li><a href="${contextPath}/board/listPage.do?page=1">listPage(목록보기-1페이지)</a></li>
                <li><a href="${contextPath}/board/listCri.do?page=1&spp=20">listCri(목록보기-1페이지, 20개의 게시물)</a></li>
                <li><a href="${contextPath}/board/listPaging.do?page=1&spp=20">listPaging(페이징처리)</a></li>
                <li><a href="${contextPath}/sboard/list.do">list(검색처리)</a></li>
            </ul>
    	</section>

        <%@include file="./fragment/footer.jsp" %>
    </div>
</body>
</html>