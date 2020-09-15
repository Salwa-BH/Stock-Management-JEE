/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package S_Pack;


import Stock.MarqueFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Haru
 */
public class CreateMarque extends HttpServlet {

    @EJB
    private MarqueFacadeLocal marqueFacade;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servelet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CreateMarque</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CreateMarque at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        try{
            /* TODO output your page here. You may use following sample code. */
            PrintWriter out = response.getWriter();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CreateMarque</title>");            
            out.println("</head>");
            out.println("<body>");
            
            out.println("<h1>Servlet CreateMarque </h1>");out.println("<br/><br/>");
            out.println("<h2>Par: Fairouz El Boualaoui et Batah Salwa </h2>");out.println("<br/><br/><br/>");
            out.println("<h3>Formulaire </h3>");out.println("<br/><br/><br/>");
            
            out.println("<form  action = \"http://localhost:8080/GestionDeStocks-war/CreateMarque\" method=\"POST\"> ");
            out.println("Nom de la marque:");
            out.println("<input type=\"text\" name=\"nomMarque\" value=\"\" />");
            out.println("<br/><br/><br/>");
            out.println("Pays d'origine:");
            out.println("<input type=\"text\" name=\"paysOrigine\" value=\"\" />");
            out.println("<br/><br/><br/>");
            out.println("<input type = \"submit\" value = \"Creer Marque\" />");
            out.println("</form>");

            out.println("</body>");
            out.println("</html>");
        }
        catch(Exception e){
            System.out.println("Probleme dans la servlet creation marque");
        }
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
         response.setContentType("text/html;charset=UTF-8");
        try{
            /* TODO output your page here. You may use following sample code. */
            PrintWriter out = response.getWriter();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CreateMarque</title>");            
            out.println("</head>");
            out.println("<body>");
            
            out.println("<h1>Servlet CreateMarque </h1>");
            out.println("<h3>Formulaire </h3>");
            
            out.println("<form  action = \"http://localhost:8080/GestionDeStocks-war/CreateMarque\" method=\"GET\"> ");
           
            Boolean ret = marqueFacade.creationMarque(request.getParameter("nomMarque"),request.getParameter("paysOrigine"));
            if(ret==true)
                out.println("Marque cree avec succes <br/>");
            else
                out.println("Cette marque existe deja, merci de la changer <br/>");
            
            out.println("<br/><br/>");
            out.println("<input type = \"submit\" value = \"Retour\" />");
            out.println("</form>");

            out.println("</body>");
            out.println("</html>");
        }
        catch(Exception e){
            System.out.println("Probleme dans la servlet creation marque");
        }
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
