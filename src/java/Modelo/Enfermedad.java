package modelo;

import java.util.Date;

public class Enfermedad {
    private int id;
    private int idHuertoCorral;
    private Date fecha;
    private String descripcion;

    public Enfermedad() {}

    public Enfermedad(int id, int idHuertoCorral, Date fecha, String descripcion) {
        this.id = id;
        this.idHuertoCorral = idHuertoCorral;
        this.fecha = fecha;
        this.descripcion = descripcion;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getIdHuertoCorral() { return idHuertoCorral; }
    public void setIdHuertoCorral(int idHuertoCorral) { this.idHuertoCorral = idHuertoCorral; }

    public Date getFecha() { return fecha; }
    public void setFecha(Date fecha) { this.fecha = fecha; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
}

