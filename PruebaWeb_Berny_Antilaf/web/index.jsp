<%@page import="model.AlumnoConsulta"%>
<%@page import="model.Alumno"%>
<%@page import="model.Ciudad"%>
<%@page import="model.Data"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="https://code.jquery.com/jquery-3.3.1.js" ></script>
    </head>
    <body>


        <h1>Alumnos</h1>
        <%Data d = new Data();%>
        <div>Cantidad Alumnos :  <%=d.cantidadAlumnos()%></div>
        <div>Cantidad Hombres :  <%=d.cantidadHombres()%></div>
        <div>Cantidad Mujeres :  <%=d.cantidadMujeres()%></div>
        <div>Cantidad Ciudades :  <%=d.cantidadCiudades()%></div>
        <input type="submit" name="btn_Opciones" value="Crear Ciudad" class="botones"
               onClick="document.getElementById('oculto').style.visibility = 'visible'">
        <div id="oculto" style="visibility:hidden">
            <form action="crearCiudad.do" >
                <input name="txtCiudad" type="text" placeholder="Ingrese ciudad" required>
                <input type="submit" name="btn_Opciones" value="Crear Ciudad">
            </form>
        </div>
        <br><br>
        <form action="crearAlumno.do" method="post">
            <table style="width:80%">
                <tr>
                    <th>ID</th>
                    <th><a>Nombre</a></th> 
                    <th>Genero</th>
                    <th>Telefono</th>
                    <th>Correo</th> 
                    <th><a id="ciudad">Ciudad</a></th>
                    <th>Accion</th>
                </tr>
            </table>
  
            <a>Nombre:</a>
            <input name="txtNombre" type="text" placeholder="Ingrese nombre" required>

            Genero:
            <input type="radio" name="sexo" value="1" checked> Hombre
            <input type="radio" name="sexo" value="2">Mujer

            Telefono:
            <input name="txtTelefono" type="text" placeholder="+569..." required>

            Correo:
            <input name="txtCorreo" type="text" placeholder="alguien@nel.com" required>

            Ciudad:
            <select name="cmbCiudad">
                <%

                    for (Ciudad c : d.getCiudades()) {
                %> 
                <option value="<%=c.getId()%>"><%=c.getNombre()%></option>
                <%
                    }
                %>
            </select>
            <input type="submit" value="Crear">
        </form>
        <br>
        <div id="resultado"></div>

        <table style="width:90%">   
            <%
                for (AlumnoConsulta a : d.getAlumnos()) {
            %>
            <tr>
                <td><%=a.getId()%></td>
                <td><%=a.getNombre()%></td>
                <%
                    if (a.getGenero() == false) {
                %>
                <td>Mujer</td> 
                <%
                } else {
                %> 
                <td>Hombre</td>
                <%
                    }
                %>
                <td><%=a.getTelefono()%></td>
                <td><%=a.getCorreo()%></td>
                <td><%=a.getFk_Ciudad()%></td>
                <td>
                    <form action="eliminarAlumno.jsp" method="post">
                        <input type="hidden" name="id" value="<%= a.getId()%>"/>
                        <input type="submit" value="Eliminar"/>
                    </form>
                </td>
            </tr> 
            <%
                }
            %>
        </table>   

    </body>
</html>
