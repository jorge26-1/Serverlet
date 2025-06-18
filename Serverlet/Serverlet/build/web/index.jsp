<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Sistema de Producción Agrícola</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #e6f2ff; 
            padding: 30px;
        }
        h1 {
            color: #007acc;
            text-align: center;
            margin-bottom: 40px;
        }
        .menu {
            background-color: #ffffff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
            max-width: 400px;
            margin: auto;
            border-left: 6px solid #4da6ff;
        }
        .menu a {
            display: block;
            padding: 12px 20px;
            margin: 12px 0;
            background-color: #4da6ff;
            color: white;
            text-decoration: none;
            border-radius: 5px;
            text-align: center;
            font-weight: bold;
        }
        .menu a:hover {
            background-color: #3399ff;
        }
    </style>
</head>
<body>
    <h1>Bienvenido al Sistema de Producción Agrícola</h1>
    <div class="menu">
        <a href="Formularios/registrarHuerto.jsp">Registrar Huerto</a>
        <a href="Formularios/registrarCorral.jsp">Registrar Corral</a>
        <a href="Formularios/registrarHumedad.jsp">Registrar Humedad del Terreno</a>
        <a href="Formularios/registrarEnfermedad.jsp">Registrar Enfermedades</a>
    </div>
</body>
</html>
