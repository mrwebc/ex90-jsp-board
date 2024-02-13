<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>

    <%@include file="../fragment/header.jsp"  %>
    
    <h1>게시글리스트-listAll</h1>
    
    <table>
        <thead>
            <tr>
                <th>No</th>
                <th>제목</th>
                <th>작성자</th>
                <th>등록일</th>
                <th>조회수</th>
            </tr>
        </thead>
        
        <tbody>
           <c:forEach items="${list}" var="dto">
            <tr>
                <th>${dto.bno}</th>
                <th><a href="${pageContext.request.contextPath}/board/read.do?bno=${dto.bno}">${dto.title}</a></th>
                <th>${dto.writer}</th>
                <th><fmt:formatDate value="${dto.regdate}" pattern="yyyy-MM-dd" /></th>
                <th>${dto.viewcnt}</th>
            </tr>
           </c:forEach>
        </tbody>
    </table>
    
    <%@include file="../fragment/footer.jsp"  %>

</body>
</html>