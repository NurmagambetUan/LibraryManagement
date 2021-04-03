<%@ page contentType="text/html;charset=UTF-8" language="java" session="true" %>
<%@ include file="header.jsp"%>
<%@ include file="navhome.jsp" %>

<%--Error page--%>

<div class="container">
    <h1>Search result Error</h1>
    <hr>
    <%
        String book = (String) session.getAttribute("book");
    %>
    <h3 class='danger'>Book with name <%=book%> not found</h3>
</div>

<%@ include file="footer.jsp"%>
