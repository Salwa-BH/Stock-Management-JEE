/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package S_Pack;

import Stock.Marque;
import Stock.Produit;
import Stock.ProduitFacadeLocal;
import Stock.Stock;
import Stock.StockFacadeLocal;
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
public class AddProductsToStock extends HttpServlet {
    
    
    @EJB
    private ProduitFacadeLocal produitFacade;

    @EJB
    private StockFacadeLocal stockFacade;

    
  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AddProductsToStock</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddProductsToStock at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try{
            /* TODO output your page here. You may use following sample code. */
            PrintWriter out = response.getWriter();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet  AddProductToStock</title>");            
            out.println("</head>");
            out.println("<body>");
            
            out.println("<h1>Servlet Add Product To Stock </h1>");out.println("<br/><br/>");
            out.println("<h2>Par: Fairouz El Boualaoui et Batah Salwa </h2>");out.println("<br/><br/><br/>");
            out.println("<h3>Formulaire </h3>");out.println("<br/><br/><br/>");
            
            out.println("<form  action = \"http://localhost:8080/GestionDeStocks-war/AddProductsToStock\" method=\"POST\"> ");
            out.println("Nom du stock:");
            
            out.println("<select name=\"nomStock\">");
            out.println("<option value=\"\" disabled=\"disabled\" selected=\"selected\">Please select The stock in which the product should be added</option>");
            List<Stock> listStock=stockFacade.listerTousStocks();
            for(int i=0;i<listStock.size();i++)
                out.println("<option >"+listStock.get(i).getNomStock()+"</option>");
            out.println("</select>");
            
            
            out.println("<br/><br/><br/>");
            out.println("Reference du produit:");
            out.println("<select name=\"refProduit\">");
            out.println("<option value=\"\" disabled=\"disabled\" selected=\"selected\">Please select a product reference</option>");
            List<Produit> list=produitFacade.listerTousProduit();
            for(int i=0;i<list.size();i++)
                out.println("<option >"+list.get(i).getReferenceProduit()+"</option>");
            out.println("</select>");
                    
            out.println("<br/><br/>");
            out.println("Quantite:");
            out.println("<input type=\"text\" name=\"quantite\" value=\"\" />");
            out.println("<br/><br/><br/>");
            out.println("<input type = \"submit\" value = \"Ajputer produit a stock\" />");
            out.println("</form>");

 

            out.println("</body>");
            out.println("</html>");
        }
        catch(Exception e){
            System.out.println("Probleme dans la servlet creation stock");
        }
    }

 
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
            out.println("<title>Servlet  AddProductsToStock</title>");            
            out.println("</head>");
            out.println("<body>");
            
            out.println("<h1>Servlet  AddProductsToStock </h1>");
            out.println("<h3>Formulaire </h3>");
            
            out.println("<form  action = \"http://localhost:8080/GestionDeStocks-war/AddProductsToStock\" method=\"GET\"> ");

            Boolean ret = stockFacade.addEntreeStock(request.getParameter("nomStock"),request.getParameter("refProduit"),Float.parseFloat(request.getParameter("quantite")));
            if(ret==true)
                out.println("Produit ajoutee au stock avec succes <br/>");
            else{
                Boolean ret2 = stockFacade.modifierQntStock(request.getParameter("nomStock"),request.getParameter("refProduit"),Float.parseFloat(request.getParameter("quantite")));
                if(ret2==true){
                    out.println("Quantite de Produit au stock est modifiee avec succes <br/>");
                }
                else
                    out.println("Cette Stock n'existe pas, merci de la changer <br/>");
            }
            
            out.println("<br/><br/>");
            out.println("<input type = \"submit\" value = \"Retour\" />");
            out.println("</form>");

            out.println("</body>");
            out.println("</html>");
        }
        catch(Exception e){
            System.out.println("Probleme dans la servlet AddProductToStock");
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
