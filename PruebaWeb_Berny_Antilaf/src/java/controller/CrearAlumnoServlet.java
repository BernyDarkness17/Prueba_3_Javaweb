package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Alumno;
import model.Data;

@WebServlet(name = "CrearAlumnoServlet", urlPatterns = {"/crearAlumno.do"})
public class CrearAlumnoServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
           Data d = new Data();
           Alumno a = new Alumno();
           int generoInt = Integer.parseInt(request.getParameter("sexo"));
           boolean genero;
           a.setNombre(request.getParameter("txtNombre"));
           
           if(generoInt==1){
               genero = true;
           }else{
               genero = false;
           }
           a.setGenero(genero);
           a.setTelefono(request.getParameter("txtTelefono"));
           a.setCorreo(request.getParameter("txtCorreo"));
           
           a.setFk_Ciudad(Integer.parseInt(request.getParameter("cmbCiudad")));
           
           d.crearAlumno(a);
           
           response.sendRedirect("index.jsp");
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(CrearAlumnoServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CrearAlumnoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
