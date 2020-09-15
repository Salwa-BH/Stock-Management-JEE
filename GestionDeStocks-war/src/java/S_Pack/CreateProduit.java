/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package S_Pack;

import Stock.Marque;
import Stock.MarqueFacadeLocal;
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
 * @author Haru
 */
public class CreateProduit extends HttpServlet {

    @EJB
    private MarqueFacadeLocal marqueFacade;

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
            out.println("<title>Servlet CreateProduit</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CreateProduit at " + request.getContextPath() + "</h1>");
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try{
            /* TODO output your page here. You may use following sample code. */
            PrintWriter out = response.getWriter();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CreateProduit</title>");            
            out.println("</head>");
            out.println("<body>");
            
            out.println("<h1>Servlet CreateProduit </h1>");out.println("<br/><br/><br/>");
            out.println("<h2>Par: Fairouz El Boualaoui et Batah Salwa </h2>");out.println("<br/>");
            out.println("<h3>Formulaire </h3>");out.println("<br/><br/><br/>");
            
            //String referenceProduit, String denomination, Float prix, Float poids, Float volume, Marque MarqueProduit
            out.println("<form  action = \"http://localhost:8080/GestionDeStocks-war/CreateProduit\" method=\"POST\"> ");
            out.println("Reference du produit:");
            out.println("<input type=\"text\" name=\"referenceProduit\" value=\"\" />");
            out.println("<br/><br/>");
            out.println("Denomination:");
            out.println("<input type=\"text\" name=\"denomination\" value=\"\" />");
            out.println("<br/><br/>");
            out.println("Prix:");
            out.println("<input type=\"text\" name=\"prix\" value=\"\" />");
            out.println("<br/><br/>");
             out.println("Poids:");
            out.println("<input type=\"text\" name=\"poids\" value=\"\" />");
            out.println("<br/><br/>");
             out.println("Volume:");
            out.println("<input type=\"text\" name=\"volume\" value=\"\" />");
            out.println("<br/><br/>");
            
            out.println("<select name=\"referenceMarque\">");
            out.println("<option value=\"\" disabled=\"disabled\" selected=\"selected\">Please select a marque reference</option>");
            List<Marque> list=marqueFacade.listerTousMarque();
            for(int i=0;i<list.size();i++)
                out.println("<option >"+list.get(i).getnomMarque()+"</option>");
            out.println("</select>");
                    
            out.println("<br/><br/>");

            /*out.println("Reference Marque:");
            out.println("<input type=\"text\" name=\"referenceMarque\" value=\"\" />");
            out.println("<br/><br/>");*/
            
            out.println("<input type = \"submit\" value = \"Creer Produit\" />");
            out.println("</form>");

            out.println("</body>");
            out.println("</html>");
        }
        catch(Exception e){
            System.out.println("Probleme dans la servlet creation Produit");
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
            out.println("<title>Servlet CreateProduit</title>");            
            out.println("</head>");
            out.println("<body>");
            
            out.println("<h1>Servlet CreateProduit </h1>");
            out.println("<h3>Formulaire </h3>");
            
            out.println("<form  action = \"http://localhost:8080/GestionDeStocks-war/CreateProduit\" method=\"GET\"> ");
           
           Boolean ret = produitFacade.creationProduit_marque(request.getParameter("referenceProduit"),request.getParameter("denomination"),Float.parseFloat(request.getParameter("prix")),Float.parseFloat(request.getParameter("poids")),Float.parseFloat(request.getParameter("volume")),produitFacade.findMarqueFromRef(request.getParameter("referenceMarque")));
            if(ret==true)
                out.println("Produit cree avec succes <br/>");
            else
                out.println("Cette produit existe deja, merci de la changer _"+ request.getParameter("select")+"<br/>");
            
            out.println("<br/><br/>");
            out.println("<input type = \"submit\" value = \"Retour\" />");
            out.println("</form>");

            out.println("</body>");
            out.println("</html>");
        }
        catch(Exception e){
            System.out.println("Probleme dans la servlet creation produit");
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
