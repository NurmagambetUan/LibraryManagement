<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp" %>
<%@ include file="navhome.jsp" %>
<%--Search book--%>

<div class="container">
    <h1>Search book page</h1>
    <hr>
    <form class="row g-3" action="searchresult.jsp">
        <div class="col-auto">
            <input type="text" name="bookName" class="form-control" placeholder="Book name">
        </div>
        <div class="col-auto">
            <button type="submit" class="btn btn-primary mb-3">Search</button>
        </div>
    </form>
</div>
<%@ include file="footer.jsp" %>
