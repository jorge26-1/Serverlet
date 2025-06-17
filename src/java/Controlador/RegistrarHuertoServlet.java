package controlador;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.sql.*;

@WebServlet("/RegistrarHuertoServlet")
public class RegistrarHuertoServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String ubicacion = request.getParameter("ubicacion");
        String tipo = request.getParameter("tipoProduccion");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/agricultura", "root", "")) {
                PreparedStatement ps = con.prepareStatement("INSERT INTO huerto(nombre, ubicacion, tipo_produccion) VALUES (?, ?, ?)");
                ps.setString(1, nombre);
                ps.setString(2, ubicacion);
                ps.setString(3, tipo);
                ps.executeUpdate();

                // Mensaje de éxito
                request.setAttribute("mensaje", "Huerto registrado correctamente.");
            }
        } catch (ClassNotFoundException | SQLException e) {
            // Mensaje de error
            request.setAttribute("error", "Error al registrar el huerto: " + e.getMessage());
        }

        // Redirige de nuevo al formulario mostrando mensaje
        request.getRequestDispatcher("Formularios/registrarHuerto.jsp").forward(request, response);
    }
}
