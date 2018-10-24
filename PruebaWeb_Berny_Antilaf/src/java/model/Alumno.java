package model;

public class Alumno {
    private int id;
    private String nombre;
    private Boolean genero;
    private String telefono;
    private String correo;
    private int fk_Ciudad;
    
    public Alumno(){}

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

    public Boolean getGenero() {
        return genero;
    }

    public void setGenero(Boolean genero) {
        this.genero = genero;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getFk_Ciudad() {
        return fk_Ciudad;
    }

    public void setFk_Ciudad(int fk_Ciudad) {
        this.fk_Ciudad = fk_Ciudad;
    }
    
    
    
}
