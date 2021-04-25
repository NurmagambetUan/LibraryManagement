<%@ include file="header.jsp" %>
<%@ include file="navlibrarian.jsp" %>

<jsp:useBean id="bookdetails" class="com.example.LibraryManagement.objects.Books"
             scope="session"></jsp:useBean>
<jsp:setProperty property="*" name="bookdetails"/>
<div class="container">
    <div class="text-center">
        <h1 class="display-4">Book successfully added</h1>
    </div>
    <h1>Book details</h1><br>
    <h3>Callno: <jsp:getProperty property="callno" name="bookdetails"/></h3><br>
    <h3>Name: <jsp:getProperty property="name" name="bookdetails"/></h3><br>
    <h3>Author: <jsp:getProperty property="author" name="bookdetails"/></h3><br>
    <h3>Publisher: <jsp:getProperty property="publisher" name="bookdetails" /></h3><br>
    <h3>Quantity: <jsp:getProperty property="quantity" name="bookdetails"/></h3><br>
</div>

<%@ include file="footer.jsp" %>
