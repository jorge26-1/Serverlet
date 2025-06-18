package modelo;

public class Huerto {
    private int id;
    private String nombre;
    private String ubicacion;
    private String tipoProduccion;

    // Constructor vacío
    public Huerto() {}

    // Constructor completo
    public Huerto(int id, String nombre, String ubicacion, String tipoProduccion) {
        this.id = id;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.tipoProduccion = tipoProduccion;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getTipoProduccion() {
        return tipoProduccion;
    }

    public void setTipoProduccion(String tipoProduccion) {
        this.tipoProduccion = tipoProduccion;
    }
}
