package presentation;

import manager.Manager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Yasi on 11/16/2017.
 */
public class SearchCountryServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            SearchInfo searchInfo = new SearchInfo(request.getParameter("name"), request.getParameter("code"));
            if (searchInfo.getName() == "" && searchInfo.getCode() == "")
                throw new IOException("Please enter Country Name or Country Code.");

            Manager manager = new Manager();
            CountryView country = manager.searchCountry(searchInfo);
            request.setAttribute("result" , country);
            request.setAttribute("showResult", true);
            request.getRequestDispatcher("index.jsp").forward(request , response);
        }catch (Exception e){
            response.getWriter().print(e.getMessage());
        }
    }
}
