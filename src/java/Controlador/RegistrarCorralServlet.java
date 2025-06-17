package controlador;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import base_datos.Conexion;
import java.sql.*;

@WebServlet("/RegistrarCorralServlet")
public class RegistrarCorralServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String capacidadStr = request.getParameter("capacidad");
        String tipoAnimal = request.getParameter("tipoAnimal");

        try {
            int capacidad = Integer.parseInt(capacidadStr);

            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection con =  Conexion.obtenerConexion()){
                PreparedStatement ps = con.prepareStatement("INSERT INTO corral(nombre, capacidad, tipo_animal) VALUES (?, ?, ?)");
                ps.setString(1, nombre);
                ps.setInt(2, capacidad);
                ps.setString(3, tipoAnimal);
                ps.executeUpdate();

               
                request.setAttribute("mensaje", "Corral registrado correctamente.");
            }
        } catch (NumberFormatException e) {
            request.setAttribute("error", "Capacidad debe ser un número válido.");
        } catch (ClassNotFoundException | SQLException e) {
            request.setAttribute("error", "Error al registrar: " + e.getMessage());
        }

        
        request.getRequestDispatcher("Formularios/registrarCorral.jsp").forward(request, response);
    }
}
