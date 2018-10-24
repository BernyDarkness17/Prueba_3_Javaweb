<%@page import="model.AlumnoConsulta"%>
<%@page import="model.Data"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alumno</title>
    </head>
    <body>

        <h1>¿Eliminar?</h1>
        <br><br>
        <h3>Esta seguro que desea eliminar a </h3>
        <%
            Data d = new Data();
            int id = Integer.parseInt(request.getParameter("id"));

            for (AlumnoConsulta a : d.getDatosAlumnosporId(id)) {
        %>
        <h3>Datos:</h3><br>
        Id       : <%=a.getId()%><br>
        Nombre   :<%=a.getNombre()%><br>
        Genero   :<%=a.getGenero()%><br>
        Telefono :<%=a.getTelefono()%><br>
        Correo   :<%=a.getCorreo()%><br>
        Ciudad   :<%=a.getFk_Ciudad()%><br>
    <center>
        <form action="eliminarAlumno.do" method="post">
            <input type="hidden" name="id" value="<%= a.getId()%>">
            <input type="submit" value="Si">
        </form>
        <br>
        <%
            }
        %>
        <form action="index.jsp">
            <input type="submit" value="No" />
        </form>
    </center>
</body>
</html>
