<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registrar Enfermedad</title>
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
            width: 500px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
            border-left: 6px solid #4da6ff;
        }
        input[type="text"], input[type="date"], select, textarea {
            width: 100%;
            padding: 8px;
            margin: 6px 0 16px 0;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        textarea {
            resize: vertical;
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
    <h2>Registrar Enfermedad</h2>

    <% 
        String mensaje = (String) request.getAttribute("mensaje");
        String error = (String) request.getAttribute("error");
        if (mensaje != null) {
    %>
        <div class="message success"><%= mensaje %></div>
    <% } else if (error != null) { %>
        <div class="message error"><%= error %></div>
    <% } %>

    <form action="${pageContext.request.contextPath}/RegistrarEnfermedadServlet" method="post">
        Tipo de Unidad Productiva:
        <select name="tipo_unidad" required>
            <option value="huerto">Huerto</option>
            <option value="corral">Corral</option>
        </select>

        Nombre del Huerto o Corral:
        <input type="text" name="nombre_huerto_corral" placeholder="Ej. Huerto A o Corral B" required>

        Fecha:
        <input type="date" name="fecha" required>

        Descripción:
        <textarea name="descripcion" rows="4" required></textarea>

        <input type="submit" value="Registrar Enfermedad">
    </form>

    <a href="${pageContext.request.contextPath}/index.jsp">Volver al menú principal</a>
</body>
</html>
