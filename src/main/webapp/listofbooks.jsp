<%@ page import="com.example.LibraryManagement.objects.Books" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.LibraryManagement.dao.BookDao" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<%@ include file="navhome.jsp" %>

<%--List of books--%>

<div class="container">
    <h1>List of books</h1>
    <hr>
    <div class="row mb-4">
        <%
            List<Books> list = BookDao.view();

            for(Books bean: list){
        %>
        <div class="col-sm-4">
            <div class="card mt-4">
                <div class="card-body">
                    <h5><%=bean.getCallno()%></h5>
                    <h2><%=bean.getName()%></h2>
                    <br>
                    <h4><%=bean.getAuthor()%></h4>
                    <hr>
                    <h6>Publisher <%=bean.getPublisher()%></h6>
                    <h6>Quantity <%=bean.getQuantity()%></h6>
                </div>
            </div>
        </div>
        <%
            }
        %>
    </div>
</div>
<%@ include file="footer.jsp" %>
