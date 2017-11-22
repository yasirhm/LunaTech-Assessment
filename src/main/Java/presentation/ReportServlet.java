package presentation;

import manager.Manager;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Yasi on 11/19/2017.
 */
public class ReportServlet extends HttpServlet {
    final static Logger logger = Logger.getLogger(ReportServlet.class);
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.debug(":: START doPost function :: ");
        Manager manager = new Manager();
        try {
            ReportView report = manager.getReport();
            HttpSession session=request.getSession(false);
            session.setAttribute("result", report);
            request.setAttribute("result" , report);
            request.setAttribute("reportResult", true);
            request.getRequestDispatcher("reportResult.jsp").forward(request , response);
        }catch (Exception e){
            response.getWriter().print(e.getMessage());
            logger.error(e, e);
            request.setAttribute("exception", e);
            request.getRequestDispatcher("/errorPage.jsp").forward(request, response);
        }
    }
}
