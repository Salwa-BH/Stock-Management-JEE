/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package S_Pack;

import Stock.Produit;
import Stock.ProduitFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DELL
 */
public class RemoveProduct extends HttpServlet {

    @EJB
    private ProduitFacadeLocal produitFacade;

    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
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
            out.println("<title>Servlet RemoveProduct</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RemoveProduct at " + request.getContextPath() + "</h1>");
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try{
            /* TODO output your page here. You may use following sample code. */
            PrintWriter out = response.getWriter();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RemoveProduct</title>");            
            out.println("</head>");
            out.println("<body>");
            
            out.println("<h1>Servlet RemoveProduct </h1>");out.println("<br/><br/>");
            out.println("<h2>Par: Fairouz El Boualaoui et Batah Salwa </h2>");out.println("<br/><br/><br/>");
            out.println("<h3>Formulaire </h3>");out.println("<br/><br/><br/>");
            
            out.println("<form  action = \"http://localhost:8080/GestionDeStocks-war/RemoveProduct\" method=\"POST\"> ");
            
            out.println("Reference du produit à supprimer :");
            out.println("<select name=\"refProduit\">");
            out.println("<option value=\"\" disabled=\"disabled\" selected=\"selected\">Please select a product reference</option>");
            List<Produit> list=produitFacade.listerTousProduit();
            for(int i=0;i<list.size();i++)
                out.println("<option >"+list.get(i).getReferenceProduit()+"</option>");
            out.println("</select>");
            
            out.println("<br/><br/><br/>");
            out.println("<input type = \"submit\" value = \"Supprimer Product\" />");
            out.println("</form>");

            out.println("</body>");
            out.println("</html>");
        }
        catch(Exception e){
            System.out.println("Probleme dans la servlet supprimer Product");
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try{
            /* TODO output your page here. You may use following sample code. */
            PrintWriter out = response.getWriter();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet  RemoveProduct</title>");            
            out.println("</head>");
            out.println("<body>");
            
            out.println("<h1>Servlet  RemoveProduct </h1>");
            out.println("<h3>Formulaire </h3>");
            
            out.println("<form  action = \"http://localhost:8080/GestionDeStocks-war/RemoveProduct\" method=\"GET\"> ");

            Boolean ret = produitFacade.supprimerProduit(request.getParameter("refProduit"));
            if(ret==true)
                out.println(" Stock supprime avec succes <br/>");
            else{
               
                
                out.println("Probleme dans la suppression de ce Product <br/>");
            }
            
            out.println("<br/><br/>");
            out.println("<input type = \"submit\" value = \"Retour\" />");
            out.println("</form>");

            out.println("</body>");
            out.println("</html>");
        }
        catch(Exception e){
            System.out.println("Probleme dans la servlet RemoveProduct");
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
