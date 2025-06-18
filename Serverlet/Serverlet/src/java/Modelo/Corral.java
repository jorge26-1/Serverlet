package modelo;

public class Corral {
    private int id; // si usas id autoincremental en la BD
    private String nombre;
    private int capacidad;
    private String tipoAnimal;

    // Constructor vacío
    public Corral() {
    }

    // Constructor con todos los atributos menos id (para crear nuevo)
    public Corral(String nombre, int capacidad, String tipoAnimal) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.tipoAnimal = tipoAnimal;
    }

    // Constructor con id (para consultas, actualizaciones)
    public Corral(int id, String nombre, int capacidad, String tipoAnimal) {
        this.id = id;
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.tipoAnimal = tipoAnimal;
    }

    // Getters y setters
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

    public int getCapacidad() {
        return capacidad;
    }
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getTipoAnimal() {
        return tipoAnimal;
    }
    public void setTipoAnimal(String tipoAnimal) {
        this.tipoAnimal = tipoAnimal;
    }
}
