<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
<style>a.on{color:red}</style>
</head>
<body>

    <%@include file="../fragment/header.jsp"  %>
    
    <h1>게시글리스트-listPaging</h1>
        
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
        
        <c:set var="contextPath" value="${pageContext.request.contextPath}" />
	
	    <c:set var="page" value="${pagiMaker.cri.page}" />
	    <c:set var="spp" value="${pagiMaker.cri.spp}" />
	    <c:set var="startPage" value="${pagiMaker.startPage}" />
	    <c:set var="endPage" value="${pagiMaker.endPage}" />
	    <c:set var="prev" value="${pagiMaker.prev}" />
	    <c:set var="next" value="${pagiMaker.next}" />
	            
        <tbody>
           <c:forEach items="${list}" var="dto">
            <tr>
                <th>${dto.bno}</th>
                <th>
                    <a href="${contextPath}/board/readPage.do?bno=${dto.bno}&page=${page}&spp=${spp}">${dto.title}</a>
                </th>
                <th>${dto.writer}</th>
                <th><fmt:formatDate value="${dto.regdate}" pattern="yyyy-MM-dd" /></th>
                <th>${dto.viewcnt}</th>
            </tr>
           </c:forEach>
        </tbody>
    </table>
    

    <div>
      <c:if test="${prev}">
           <a href="listPaging.do?page=${startPage-1}&spp=${spp}">◀◀</a>
      </c:if>
      <c:if test="${!prev}">
           <span>◀◀</span>
      </c:if>
      
      <c:if test="${page gt startPage}">
           <a href="listPaging.do?page=${page-1}&spp=${spp}">◀</a>
      </c:if>      
      
      <c:if test="${page le startPage}">
           <span>◀</span>
      </c:if>
      
      
      
      <c:forEach var="idx" begin="${startPage}" end="${endPage}">
        <a 
         <c:out value="${idx==page ? 'class=on' : ''}" />
         href="listPaging.do?page=${idx}&spp=${spp}">${idx}</a>
      </c:forEach>
      

      
      <c:if test="${page ge endPage}">
           <span>▶</span>
      </c:if>
    
      <c:if test="${page lt endPage}">
           <a href="listPaging.do?page=${page+1}&spp=${spp}">▶</a>           
      </c:if>      
                
      <c:if test="${next}">
           <a href="listPaging.do?page=${endPage+1}&spp=${spp}">▶▶</a>
      </c:if>
      <c:if test="${!next}">
           <span>▶▶</span>
      </c:if>

    </div>
    
    
    <%@include file="../fragment/footer.jsp"  %>

</body>
</html>