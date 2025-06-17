package controlador;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import base_datos.Conexion;
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
            try (Connection con = Conexion.obtenerConexion()) { 
                PreparedStatement ps = con.prepareStatement("INSERT INTO huerto(nombre, ubicacion, tipo_produccion) VALUES (?, ?, ?)");
                ps.setString(1, nombre);
                ps.setString(2, ubicacion);
                ps.setString(3, tipo);
                ps.executeUpdate();

                
                request.setAttribute("mensaje", "Huerto registrado correctamente.");
            }
        } catch (ClassNotFoundException | SQLException e) {
           
            request.setAttribute("error", "Error al registrar el huerto: " + e.getMessage());
        }

       
        request.getRequestDispatcher("Formularios/registrarHuerto.jsp").forward(request, response);
    }
}
