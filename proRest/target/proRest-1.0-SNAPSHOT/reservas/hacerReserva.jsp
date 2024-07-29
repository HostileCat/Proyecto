<%@page import="java.util.Arrays"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Horarios</title>
</head>
<body>
    <h1>Horarios disponibles:</h1>
    <ul>
        <%-- Ejemplo de horarios (puedes cargarlos desde una lista en el backend) --%>
        <%
            List<String> horarios = Arrays.asList("12 00", "8:00", "19:00");
            LocalDateTime horaActual = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

            for (String horario : horarios) {
                LocalDateTime horarioLocal = LocalDateTime.parse(horario, formatter);
                boolean esActivo = horarioLocal.isAfter(horaActual);
        %>
        <li>
            <span><%= horario %></span>
            <% if (esActivo) { %>
                <button>Activar</button>
            <% } else { %>
                <button disabled>Deshabilitado</button>
            <% } %>
        </li>
        <% } %>
    </ul>
</body>
</html>

