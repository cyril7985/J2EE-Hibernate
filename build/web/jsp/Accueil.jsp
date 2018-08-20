<%-- 
    Document   : Accueil
    Created on : 8 août 2018, 11:33:25
    Author     : Administrateur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="/hibernateWebApp/css/main.css" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Accueil</title>
    </head>
    <body>
        <header>
            <%@ include file="Header.jsp" %>
        </header>
        
        <!--La nav contient le lien vers la servlet PaysCtrl -->
        <nav>
            <%@ include file="Nav.jsp" %>
        </nav>
        <article id="articleAccueil">
            <h1>Accueil</h1>
            <br>
            <label class="messageOrange"style="font-weight: bold">
                ${message}
            </label>
            <br><br>
            <img src="/hibernateWebApp/image/hibernate.png" alt="Photo" title="Photo" width="45%"/>
        </article>
        <footer>
            <%@ include file="Footer.jsp" %>
        </footer> 
        
    </body>
</html>
