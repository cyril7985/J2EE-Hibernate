<%-- 
    Document   : Pays
    Created on : 8 août 2018, 11:49:02
    Author     : Administrateur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="/hibernateWebApp/css/main.css" />        

        <title>JSP Page</title>
    </head>
    <body>
        <header>
            <%@ include file="Header.jsp" %>
        </header>
        <nav>
            <%@ include file="Nav.jsp" %>
        </nav>
        <h1 style="text-align: center">La table Pays</h1>
    <center>
        <table border="1"style="width: 250px;margin-top: 50px">
            <thead>
                <tr>
                    <th>Id du pays</th>
                    <th>Nom du pays</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="pays" items="${listePays}">               
                    <tr>
                        <td>${pays.idPays}</td>
                        <td>${pays.nomPays}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table></br>
        <form action="/hibernateWebApp/PaysCTRL" method="post">
            <p>
                <label for="idPays">Id Pays:</label>
                <input type="text" name="idPays" value="${idPaysText}">

                <label for="nomPays">Nom du pays:</label>
                <input type="text" name="nomPays" value="${nomPaysText}">
            </p>
            <p style="margin-top: 30px">
                <button type="submit" name="cls" style="width: 150px;margin-right: 30px">CLS</button>
                <button type="submit" name="ajouter" style="width: 150px;margin-right: 30px">Ajouter</button>
                <button type="submit" name="modifier" style="width: 150px;margin-right: 30px">Modifier</button>
                <button type="submit" name="supprimer" style="width: 150px;margin-right: 30px">Supprimer</button>
            </p>
        </form>
            <p>
                <h2>${message}</h2>
            </p>
            <select name="test">
                <option>*******Liste des Pays******</option>
                 <c:forEach var="pays" items="${listePays}"> 
                     
                <option>${pays.nomPays}</option>
                 </c:forEach>
            </select>
    </center>
</body>
</html>
