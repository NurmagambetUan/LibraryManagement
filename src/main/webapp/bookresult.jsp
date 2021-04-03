<%@ page contentType="text/html;charset=UTF-8" language="java" session="true" %>
<%@ include file="header.jsp"%>
<%@ include file="navhome.jsp"%>

<%--Result book page--%>

<div class="container">
    <h1>Result book</h1>
    <hr>
    <%
        String book = (String) session.getAttribute("book");
    %>
    <h3>Book with name <%=book%> found</h3>
    <br>
    <h5><%=request.getParameter("callno")%></h5>
    <br>
    <h2><%=request.getParameter("bookname")%></h2>
    <br>
    <h4><%=request.getParameter("author")%></h4>
    <br>
    <h6>Publisher <%=request.getParameter("publisher")%></h6>
    <br>
    <h6>Quantity <%=request.getParameter("quantity")%></h6>
</div>

<%@ include file="footer.jsp"%>
