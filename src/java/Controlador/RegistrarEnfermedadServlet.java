package controlador;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.sql.*;

@WebServlet("/RegistrarEnfermedadServlet")
public class RegistrarEnfermedadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String tipo = request.getParameter("tipo_unidad");
        String nombre = request.getParameter("nombre_huerto_corral");
        String fecha = request.getParameter("fecha");
        String descripcion = request.getParameter("descripcion");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3307/agricultura", "root", "")) {

                // Buscar el ID según sea huerto o corral
                String sqlBuscar = tipo.equals("huerto")
                        ? "SELECT id FROM huerto WHERE nombre = ?"
                        : "SELECT id FROM corral WHERE nombre = ?";

                PreparedStatement psBuscar = con.prepareStatement(sqlBuscar);
                psBuscar.setString(1, nombre);
                ResultSet rs = psBuscar.executeQuery();

                if (rs.next()) {
                    int idHuertoCorral = rs.getInt("id");

                    // Insertar en enfermedad
                    PreparedStatement psInsertar = con.prepareStatement(
                            "INSERT INTO enfermedad(id_huerto_corral, nombre, fecha, descripcion) VALUES (?, ?, ?, ?)");
                    psInsertar.setInt(1, idHuertoCorral);
                    psInsertar.setString(2, nombre);
                    psInsertar.setString(3, fecha);
                    psInsertar.setString(4, descripcion);
                    psInsertar.executeUpdate();

                    request.setAttribute("mensaje", "Enfermedad registrada correctamente.");
                } else {
                    request.setAttribute("error", "No se encontró un " + tipo + " con el nombre: " + nombre);
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            request.setAttribute("error", "Error al registrar enfermedad: " + e.getMessage());
        }

        // Redirigir al mismo formulario con mensaje
        request.getRequestDispatcher("Formularios/registrarEnfermedad.jsp").forward(request, response);
    }
}
