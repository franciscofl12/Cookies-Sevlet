<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Vista Cookies</title>
    </head>
    <body>
        <h2>Cookies almacenadas:</h2>
        <%
            if (request.getParameter("visualizar") != null) {
                Cookie[] total = request.getCookies();
                for (Cookie co : total) {

                    out.println(co.getName() + "-" + co.getValue() + "</br>");
                }
            }
        %>
        <br>
        <br>
        <form action="index.jsp" method="post">
            <input type="submit" name="" value="Volver">
        </form>

    </body>
</html>