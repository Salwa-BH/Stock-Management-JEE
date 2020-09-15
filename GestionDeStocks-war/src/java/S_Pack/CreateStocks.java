package S_Pack;

 

import Stock.StockFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 

/**
 *
 * @author DELL
 */
public class CreateStocks extends HttpServlet {

 

    @EJB
    private StockFacadeLocal stockFacade;

 

    
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
            out.println("<title>Servlet CreateStock</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CreateStock at " + request.getContextPath() + "</h1>");
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
            out.println("<title>Servlet CreateStock</title>");            
            out.println("</head>");
            out.println("<body>");
            
            out.println("<h1>Servlet CreateStock </h1>");out.println("<br/><br/><br/>");
            out.println("<h3>Formulaire </h3>");out.println("<br/><br/><br/>");
            
            out.println("<form  action = \"http://localhost:8080/GestionDeStocks-war/CreateStocks\" method=\"POST\"> ");
            out.println("Nom du stock:");
            out.println("<input type=\"text\" name=\"nomStock\" value=\"\" />");
            out.println("<br/><br/>");
            out.println("<input type = \"submit\" value = \"Creer Stock\" />");
            out.println("</form>");

 

            out.println("</body>");
            out.println("</html>");
        }
        catch(Exception e){
            System.out.println("Probleme dans la servlet creation stock");
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
            out.println("<title>Servlet CreateStock</title>");            
            out.println("</head>");
            out.println("<body>");
            
            out.println("<h1>Servlet CreateStock </h1>");
            out.println("<h3>Formulaire </h3>");
            
            out.println("<form  action = \"http://localhost:8080/GestionDeStocks-war/CreateStocks\" method=\"GET\"> ");
           
            Boolean ret = stockFacade.createStock(request.getParameter("nomStock"));
            if(ret==true)
                out.println("Stock cree avec succes <br/>");
            else
                out.println("Ce stock existe deja, merci de le changer <br/>");
            
            out.println("<br/><br/>");
            out.println("<input type = \"submit\" value = \"Retour\" />");
            out.println("</form>");

 

            out.println("</body>");
            out.println("</html>");
        }
        catch(Exception e){
            System.out.println("Probleme dans la servlet creation stock");
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