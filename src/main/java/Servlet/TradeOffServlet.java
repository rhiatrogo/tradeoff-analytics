package Servlet;

import Connector.Connector;
import com.ibm.watson.developer_cloud.tradeoff_analytics.v1.TradeoffAnalytics;
import com.ibm.watson.developer_cloud.tradeoff_analytics.v1.model.Dilemma;
import com.ibm.watson.developer_cloud.tradeoff_analytics.v1.model.Option;
import com.ibm.watson.developer_cloud.tradeoff_analytics.v1.model.Problem;
import com.ibm.watson.developer_cloud.tradeoff_analytics.v1.model.column.Column;
import com.ibm.watson.developer_cloud.tradeoff_analytics.v1.model.column.Column.Goal;
import com.ibm.watson.developer_cloud.tradeoff_analytics.v1.model.column.NumericColumn;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@WebServlet(name = "TradeOffServlet", urlPatterns = {"/TradeOffServlet"})
public class TradeOffServlet extends HttpServlet {

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

            Connector connector = new Connector();

            TradeoffAnalytics service = new TradeoffAnalytics();
            String username1 = connector.getUsername();
            String password1 = connector.getPassword();
            System.out.println(username1);
            System.out.println(password1);
			
		    String username = "d7932fc3-5fb4-452a-926a-437494a357bb";
			username = "4ef4ee83-8f31-4e9d-a24d-1f21176706d6";
			String password = "sHtl2NECnYgc";
			password = "fTfX5iOotIyK";
            service.setUsernameAndPassword(username, password);
          
            Problem problem = new Problem("phone");

            String price = "price";
            String ram = "ram";
            String screen = "screen";

            String finalprice = request.getParameter("finalprice");
            String finalram = request.getParameter("finalram");
            String finalscreen = request.getParameter("finalscreen");

            //Define the objectives
            List< Column> columns = new ArrayList<Column>();
            problem.setColumns(columns);

			/*
            columns.add(new NumericColumn().withKey(price).withGoal(Goal.fromString(finalprice)).withObjective(true));
//          columns.add(new NumericColumn().withRange(0, 100).withKey(price).withGoal(Goal.fromString(finalprice)).withObjective(true));
            columns.add(new NumericColumn().withKey(ram).withGoal(Goal.fromString(finalram)));
            columns.add(new NumericColumn().withKey(screen).withGoal(Goal.fromString(finalscreen)).withObjective(true));
			*/
			
			columns.add(new NumericColumn().withKey(price).withGoal(Goal.fromString("50")).withObjective(true));
			columns.add(new NumericColumn().withKey(screen).withGoal(Goal.fromString("5")).withObjective(true));
			columns.add(new NumericColumn().withKey(ram).withGoal(Goal.fromString("45")));
			
			
			
            //Define the options to choose
            List<Option> options = new ArrayList<Option>();
            problem.setOptions(options);

            HashMap<String, Object> galaxySpecs = new HashMap<String, Object>();
            galaxySpecs.put(price, Double.parseDouble(request.getParameter("price1")));
            galaxySpecs.put(ram, Double.parseDouble(request.getParameter("ram1")));
            galaxySpecs.put(screen, Double.parseDouble(request.getParameter("screen1")));
            options.add(new Option("1", "Galaxy S4").withValues(galaxySpecs));

            HashMap<String, Object> iphoneSpecs = new HashMap<String, Object>();
            iphoneSpecs.put(price, Double.parseDouble(request.getParameter("price2")));
            iphoneSpecs.put(ram, Double.parseDouble(request.getParameter("ram2")));
            iphoneSpecs.put(screen, Double.parseDouble(request.getParameter("screen2")));
            options.add(new Option("2", "iPhone 5").withValues(iphoneSpecs));

            HashMap<String, Object> testSpecs = new HashMap<String, Object>();
            //I exaggerated the price (lowest), ram (largest), and screen (largest) so that this is the clear winner
            testSpecs.put(price, Double.parseDouble(request.getParameter("price3")));
            testSpecs.put(ram, Double.parseDouble(request.getParameter("ram3")));
            testSpecs.put(screen, Double.parseDouble(request.getParameter("screen3")));
            options.add(new Option("3", "MyPhone").withValues(testSpecs));

            HashMap<String, Object> optimusSpecs = new HashMap<String, Object>();
            optimusSpecs.put(price, Double.parseDouble(request.getParameter("price4")));
            optimusSpecs.put(ram, Double.parseDouble(request.getParameter("ram4")));
            optimusSpecs.put(screen, Double.parseDouble(request.getParameter("screen4")));
            options.add(new Option("4", "LG Optimus G").withValues(optimusSpecs));

            out.println("<!DOCTYPE html>");
            // Call the service and get the resolution
            Dilemma dilemma = service.dilemmas(problem);

            //Look at the screen output and notice that the winner is option 3
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Results</title>");
            out.println("</head>");
            out.println("<body>");
            out.println(dilemma);
            out.println("</body>");
            out.println("</html>");

        } catch (Exception e) {
            System.out.println("Error");
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

    private void getConnection() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
