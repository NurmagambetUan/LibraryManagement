<%@ page import="com.example.LibraryManagement.objects.Books" %>
<%@ page import="com.example.LibraryManagement.dao.BookDao" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="true" %>
<%@ include file="header.jsp" %>
<%@ include file="navhome.jsp" %>

<%--Search result--%>

<div class="container">
    <h1>Search result</h1>
    <hr>
    <%
        String bookName = request.getParameter("bookName");
        List<Books> list = BookDao.view();
        Books book = null;
        for(Books bean: list) {
            if (bean.getName().equals(bookName)) {
                book = bean;
                break;
            }
        }
        session.setAttribute("book", bookName);
        if (book == null) {
        response.sendRedirect("errorpage.jsp");
    } else {
    %>
    <jsp:forward page="bookresult.jsp" >
        <jsp:param name="callno" value="<%=book.getCallno()%>" />
        <jsp:param name="bookname" value="<%=book.getName()%>" />
        <jsp:param name="author" value="<%=book.getAuthor()%>" />
        <jsp:param name="publisher" value="<%=book.getPublisher()%>" />
        <jsp:param name="quantity" value="<%=book.getQuantity()%>" />
    </jsp:forward>
    <%
        }
    %>
</div>
<%@ include file="footer.jsp" %>
