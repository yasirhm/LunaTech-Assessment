package presentation;

import manager.Manager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Yasi on 11/19/2017.
 */
public class ReportServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Manager manager = new Manager();
        try {
            ReportView report = manager.getReport();
            request.setAttribute("result" , report);
            request.setAttribute("reportResult", true);
            request.getRequestDispatcher("reportResult.jsp").forward(request , response);
        }catch (Exception e){
            response.getWriter().print(e.getMessage());
        }
    }
}
