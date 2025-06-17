<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registrar Humedad</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #e6f2ff; 
            padding: 40px;
        }
        h2 {
            color: #007acc; 
        }
        form {
            background-color: #ffffff;
            padding: 20px;
            border-radius: 10px;
            width: 400px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
            border-left: 6px solid #4da6ff; 
        }
        input[type="text"], input[type="number"], input[type="date"], select {
            width: 100%;
            padding: 8px;
            margin: 6px 0 16px 0;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        input[type="submit"] {
            background-color: #4da6ff;
            color: white;
            border: none;
            padding: 10px 20px;
            border-radius: 5px;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #3399ff;
        }
        .message {
            margin-bottom: 20px;
            padding: 10px;
            border-radius: 5px;
        }
        .success {
            background-color: #d1ecf1;
            color: #0c5460;
            border-left: 5px solid #17a2b8;
        }
        .error {
            background-color: #f8d7da;
            color: #721c24;
            border-left: 5px solid #dc3545;
        }
        a {
            display: inline-block;
            margin-top: 20px;
            color: #007acc;
            text-decoration: none;
        }
        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <h2>Registrar Humedad del Terreno</h2>
    <%
        String mensaje = (String) request.getAttribute("mensaje");
        String error = (String) request.getAttribute("error");
        if (mensaje != null) {
    %>
        <div class="message success"><%= mensaje %></div>
    <% } else if (error != null) { %>
        <div class="message error"><%= error %></div>
    <% } %>

    <form action="${pageContext.request.contextPath}/RegistrarHumedadServlet" method="post">
        Tipo:
        <select name="tipo" required>
            <option value="huerto">Huerto</option>
            <option value="corral">Corral</option>
        </select>

        Nombre del Huerto o Corral:
        <input type="text" name="nombre" placeholder="Ej. Huerto A o Corral B" required>

        Nivel de Humedad (%):
        <input type="number" step="1" name="nivel_humedad" required>

        Fecha:
        <input type="date" name="fecha" required>

        <input type="submit" value="Registrar Humedad">
    </form>

    <a href="${pageContext.request.contextPath}/index.jsp">Volver al menú principal</a>
</body>
</html>
