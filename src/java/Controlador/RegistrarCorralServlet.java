package controlador;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
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
            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/agricultura", "root", "")) {
                PreparedStatement ps = con.prepareStatement("INSERT INTO corral(nombre, capacidad, tipo_animal) VALUES (?, ?, ?)");
                ps.setString(1, nombre);
                ps.setInt(2, capacidad);
                ps.setString(3, tipoAnimal);
                ps.executeUpdate();

                // Agrega mensaje de éxito
                request.setAttribute("mensaje", "Corral registrado correctamente.");
            }
        } catch (NumberFormatException e) {
            request.setAttribute("error", "Capacidad debe ser un número válido.");
        } catch (ClassNotFoundException | SQLException e) {
            request.setAttribute("error", "Error al registrar: " + e.getMessage());
        }

        // Redirige a la misma página mostrando mensaje
        request.getRequestDispatcher("Formularios/registrarCorral.jsp").forward(request, response);
    }
}
