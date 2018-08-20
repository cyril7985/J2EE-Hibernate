<%--
    Document   : Footer.jsp
--%>

<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    //Calendar gc = new GregorianCalendar();
    SimpleDateFormat sdfJour = new SimpleDateFormat("EEEE d MMMM yyyy");
    SimpleDateFormat sdfHeure = new SimpleDateFormat("HH:mm");
    String lsJour = sdfJour.format(new Date());
    String lsHeure = sdfHeure.format(new Date());
    out.print("Nous sommes le " + lsJour + " et il est " + lsHeure);
%>

