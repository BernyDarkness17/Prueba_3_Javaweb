package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Data {

    private final Conexion con;
    private ResultSet rs;

    public Data() throws SQLException, ClassNotFoundException {
        con = new Conexion(
                "localhost",
                "bd_alumnos_p3",
                "root",
                ""
        );
    }

    public void crearAlumno(Alumno a) throws SQLException {
        con.ejecutar("INSERT INTO alumno VALUES(NULL, "
                + "'" + a.getNombre() + "', "
                + "" + a.getGenero() + ", "
                + "'" + a.getTelefono() + "', "
                + "'" + a.getCorreo() + "', "
                + "" + a.getFk_Ciudad() + ");");
    }

    public void crearCiudad(Ciudad c) throws SQLException {
        con.ejecutar("INSERT INTO ciudad VALUES(NULL, '"+c.getNombre()+"');");
    }

    public List<Ciudad> getCiudades() throws SQLException {
        List<Ciudad> lista = new ArrayList<>();

        rs = con.ejecutarSelect("SELECT * FROM ciudad;");
        Ciudad c;

        while (rs.next()) {
            c = new Ciudad();
            c.setId(rs.getInt(1));
            c.setNombre(rs.getString(2));

            lista.add(c);

        }
        con.close();
        return lista;

    }

    public String getCiudadesporId(int id) throws SQLException {
        rs = con.ejecutarSelect("SELECT nombre FROM ciudad where id=" + id);
        Ciudad c;
        String ciudadNombre = "";
        while (rs.next()) {
            c = new Ciudad();
            ciudadNombre = rs.getString(1);

        }
        con.close();
        return ciudadNombre;

    }

    ////////////////////////////
    public List<AlumnoConsulta> getAlumnos() throws SQLException {
        rs = con.ejecutarSelect("SELECT a.id AS 'ID', a.nombre AS 'Nombre', a.genero AS 'Género', "
                + "a.telefono AS 'Telefono', a.correo AS 'Correo',  c.nombre AS 'Ciudad' "
                + "FROM alumno a "
                + "INNER JOIN ciudad c ON c.id = a.fk_ciudad;");
        List<AlumnoConsulta> alu = new ArrayList<>();

        AlumnoConsulta a;

        while (rs.next()) {
            a = new AlumnoConsulta();

            a.setId(rs.getInt(1));
            a.setNombre(rs.getString(2));
            a.setGenero(rs.getBoolean(3));
            a.setTelefono(rs.getString(4));
            a.setCorreo(rs.getString(5));
            a.setFk_Ciudad(rs.getString(6));

            alu.add(a);

        }
        con.close();
        return alu;
    }

    public int cantidadHombres() throws SQLException {
        rs = con.ejecutarSelect("SELECT COUNT(0) FROM alumno WHERE genero IS TRUE;");
        int ContH = 0;
        if (rs.next()) {
            ContH = rs.getInt(1);
        }
        con.close();
        return ContH;

    }

    public int cantidadMujeres() throws SQLException {
        rs = con.ejecutarSelect("SELECT COUNT(0) FROM alumno WHERE genero IS FALSE;");
        int ContM = 0;
        if (rs.next()) {
            ContM = rs.getInt(1);
        }
        con.close();
        return ContM;

    }

    public int cantidadAlumnos() throws SQLException {
        rs = con.ejecutarSelect("SELECT COUNT(0) FROM alumno;");
        int ContA = 0;
        if (rs.next()) {
            ContA = rs.getInt(1);
        }
        con.close();
        return ContA;

    }

    public int cantidadCiudades() throws SQLException {
        rs = con.ejecutarSelect("SELECT COUNT(0) FROM ciudad;");
        int ContC = 0;
        if (rs.next()) {
            ContC = rs.getInt(1);
        }
        con.close();
        return ContC;

    }

    public List<AlumnoConsulta> getDatosAlumnosporId(int id) throws SQLException {
        rs = con.ejecutarSelect("SELECT a.id AS 'ID', a.nombre AS 'Nombre', a.genero AS 'Género', "
                + "a.telefono AS 'Telefono', a.correo AS 'Correo', c.nombre AS 'Ciudad' "
                + "from alumno a "
                + "INNER JOIN ciudad c ON c.id = a.fk_ciudad "
                + "where a.id =" + id);
        List<AlumnoConsulta> al = new ArrayList<>();

        AlumnoConsulta a;

        if (rs.next()) {
            a = new AlumnoConsulta();
            a.setId(rs.getInt(1));
            a.setNombre(rs.getString(2));
            a.setGenero(rs.getBoolean(3));
            a.setTelefono(rs.getString(4));
            a.setCorreo(rs.getString(5));
            a.setFk_Ciudad(rs.getString(6));

            al.add(a);

        }
        con.close();
        return al;
    }

    public void EliminarAlumno(int id) throws SQLException {
        con.ejecutar("DELETE FROM alumno WHERE id =" + id);
    }

    public List<AlumnoConsulta> alumnosOrderASC() throws SQLException {
        rs = con.ejecutarSelect("SELECT a.id AS 'ID', a.nombre AS 'Nombre', a.genero AS 'Género', "
                + "a.telefono AS 'Telefono', a.correo AS 'Correo', c.nombre AS 'Ciudad' "
                + "from alumno a "
                + "INNER JOIN ciudad c ON c.id = a.fk_ciudad "
                + "ORDER BY a.nombre ASC;");
        List<AlumnoConsulta> al = new ArrayList<>();

        AlumnoConsulta a;

        if (rs.next()) {
            a = new AlumnoConsulta();
            a.setId(rs.getInt(1));
            a.setNombre(rs.getString(2));
            a.setGenero(rs.getBoolean(3));
            a.setTelefono(rs.getString(4));
            a.setCorreo(rs.getString(5));
            a.setFk_Ciudad(rs.getString(6));

            al.add(a);

        }
        con.close();
        return al;
    }

    public List<AlumnoConsulta> alumnosOrderDESC() throws SQLException {
        rs = con.ejecutarSelect("SELECT a.id AS 'ID', a.nombre AS 'Nombre', a.genero AS 'Género', "
                + "a.telefono AS 'Telefono', a.correo AS 'Correo', c.nombre AS 'Ciudad' "
                + "from alumno a "
                + "INNER JOIN ciudad c ON c.id = a.fk_ciudad "
                + "ORDER BY a.nombre DESC;");
        List<AlumnoConsulta> al = new ArrayList<>();

        AlumnoConsulta a;

        if (rs.next()) {
            a = new AlumnoConsulta();
            a.setId(rs.getInt(1));
            a.setNombre(rs.getString(2));
            a.setGenero(rs.getBoolean(3));
            a.setTelefono(rs.getString(4));
            a.setCorreo(rs.getString(5));
            a.setFk_Ciudad(rs.getString(6));

            al.add(a);

        }
        con.close();
        return al;
    }

    public List<AlumnoConsulta> alumnosOrderASC_CIUDAD() throws SQLException {
        rs = con.ejecutarSelect("SELECT a.id AS 'ID', a.nombre AS 'Nombre', a.genero AS 'Género', "
                + "a.telefono AS 'Telefono', a.correo AS 'Correo', c.nombre AS 'Ciudad' "
                + "from alumno a "
                + "INNER JOIN ciudad c ON c.id = a.fk_ciudad "
                + "ORDER BY c.nombre ASC;");
        List<AlumnoConsulta> al = new ArrayList<>();

        AlumnoConsulta a;

        if (rs.next()) {
            a = new AlumnoConsulta();
            a.setId(rs.getInt(1));
            a.setNombre(rs.getString(2));
            a.setGenero(rs.getBoolean(3));
            a.setTelefono(rs.getString(4));
            a.setCorreo(rs.getString(5));
            a.setFk_Ciudad(rs.getString(6));

            al.add(a);

        }
        con.close();
        return al;
    }

    public List<AlumnoConsulta> alumnosOrderDESC_CIUDAD() throws SQLException {
        rs = con.ejecutarSelect("SELECT a.id AS 'ID', a.nombre AS 'Nombre', a.genero AS 'Género', "
                + "a.telefono AS 'Telefono', a.correo AS 'Correo', c.nombre AS 'Ciudad' "
                + "from alumno a "
                + "INNER JOIN ciudad c ON c.id = a.fk_ciudad "
                + "ORDER BY c.nombre DESC;");
        List<AlumnoConsulta> al = new ArrayList<>();

        AlumnoConsulta a;

        if (rs.next()) {
            a = new AlumnoConsulta();
            a.setId(rs.getInt(1));
            a.setNombre(rs.getString(2));
            a.setGenero(rs.getBoolean(3));
            a.setTelefono(rs.getString(4));
            a.setCorreo(rs.getString(5));
            a.setFk_Ciudad(rs.getString(6));

            al.add(a);

        }
        con.close();
        return al;
    }

}
