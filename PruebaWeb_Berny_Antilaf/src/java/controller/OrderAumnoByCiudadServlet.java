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
import model.AlumnoConsulta;
import model.Data;

@WebServlet(name = "OrderAumnoByCiudadServlet", urlPatterns = {"/orderAumnoByCiudad.do"})
public class OrderAumnoByCiudadServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet OrderAumnoByCiudadServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Order</h1>");

            Data d = new Data();
            out.println("<table>");

            for (AlumnoConsulta a : d.alumnosOrderDESC()) {
                out.println("<tr>");

                out.println("<td>");
                a.getId();
                a.getNombre();
                a.getGenero();
                a.getTelefono();
                a.getCorreo();
                a.getFk_Ciudad();
                out.println("</td>");

                out.println("</tr>");
            }
            out.println("</table>");

            out.println("</body>");
            out.println("</html>");

        } catch (SQLException ex) {
            Logger.getLogger(OrderAumnoByCiudadServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OrderAumnoByCiudadServlet.class.getName()).log(Level.SEVERE, null, ex);
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
