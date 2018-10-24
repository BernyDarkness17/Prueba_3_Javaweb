package model;

public class AlumnoConsulta {

    private int id;
    private String nombre;
    private Boolean genero;
    private String telefono;
    private String correo;
    private String fk_Ciudad;
    
    
    public AlumnoConsulta(){}

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

    public String getFk_Ciudad() {
        return fk_Ciudad;
    }

    public void setFk_Ciudad(String fk_Ciudad) {
        this.fk_Ciudad = fk_Ciudad;
    }
    
    
}
