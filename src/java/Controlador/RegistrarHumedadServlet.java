package controlador;

import base_datos.Conexion;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.sql.*;

@WebServlet("/RegistrarHumedadServlet")
public class RegistrarHumedadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String tipo = request.getParameter("tipo");
        String nombre = request.getParameter("nombre");
        String fecha = request.getParameter("fecha");
        String nivelStr = request.getParameter("nivel_humedad");

        try {
            double nivel = Double.parseDouble(nivelStr);
            Class.forName("com.mysql.cj.jdbc.Driver");

            try  (Connection con = Conexion.obtenerConexion()) { 

                // Buscar el ID del huerto o corral
                String tabla = tipo.equals("corral") ? "corral" : "huerto";
                PreparedStatement psBuscar = con.prepareStatement("SELECT id FROM " + tabla + " WHERE nombre = ?");
                psBuscar.setString(1, nombre);
                ResultSet rs = psBuscar.executeQuery();

                if (rs.next()) {
                    int idHuertoCorral = rs.getInt("id");

                    // Insertar en tabla humedad
                    PreparedStatement psInsertar = con.prepareStatement(
                            "INSERT INTO humedad(id_huerto_corral, nombre, fecha, nivel) VALUES (?, ?, ?, ?)"
                    );
                    psInsertar.setInt(1, idHuertoCorral);
                    psInsertar.setString(2, nombre);
                    psInsertar.setString(3, fecha);
                    psInsertar.setDouble(4, nivel);
                    psInsertar.executeUpdate();

                    request.setAttribute("mensaje", "Registro de humedad exitoso.");
                } else {
                    request.setAttribute("error", "No se encontró un " + tipo + " con el nombre: " + nombre);
                }
            }
        } catch (NumberFormatException e) {
            request.setAttribute("error", "El nivel de humedad debe ser un número válido.");
        } catch (ClassNotFoundException | SQLException e) {
            request.setAttribute("error", "Error al registrar humedad: " + e.getMessage());
        }

        request.getRequestDispatcher("Formularios/registrarHumedad.jsp").forward(request, response);
    }
}
