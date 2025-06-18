package Modelo;

import java.util.Date;

public class Humedad {
    private int id;
    private int idHuerto;
    private Date fecha;
    private double nivel;

    public Humedad() {}

    public Humedad(int id, int idHuerto, Date fecha, double nivel) {
        this.id = id;
        this.idHuerto = idHuerto;
        this.fecha = fecha;
        this.nivel = nivel;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getIdHuerto() { return idHuerto; }
    public void setIdHuerto(int idHuerto) { this.idHuerto = idHuerto; }

    public Date getFecha() { return fecha; }
    public void setFecha(Date fecha) { this.fecha = fecha; }

    public double getNivel() { return nivel; }
    public void setNivel(double nivel) { this.nivel = nivel; }
}
