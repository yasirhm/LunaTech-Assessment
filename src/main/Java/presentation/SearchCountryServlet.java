package presentation;

import manager.Manager;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Yasi on 11/16/2017.
 */

public class SearchCountryServlet extends HttpServlet {
    final static Logger logger = Logger.getLogger(ReportServlet.class);
    static CountryView countryView;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.debug(":: START doPost function :: ");
        try {
            SearchInfo searchInfo = new SearchInfo(request.getParameter("name").trim(), request.getParameter("code").trim());
            if (searchInfo.getName() == "" && searchInfo.getCode() == "")
                throw new IOException("Please enter Country Name or Country Code.");

            Manager manager = new Manager();
            countryView = manager.searchCountry(searchInfo);
            doGet(request, response);
        }catch (Exception e){
            response.getWriter().print(e.getMessage());
            logger.error(e, e);
            request.setAttribute("exception", e);
            request.getRequestDispatcher("/errorPage.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int page = 1;
            int recordsPerPage = 20;
            int numOfPageIndex = 10;
            int limitRetrievedRecords = 200;
            if (request.getParameter("pageNumber") != null)
                page = Integer.parseInt(request.getParameter("pageNumber"));
            CountryView countryVO = new CountryView(countryView.getName(), countryView.getCode());
            Manager manager = new Manager();
            countryVO.setAirportViews(manager.getAirportVOListToDisplay(countryView.getAirportViews(), (page-1) * recordsPerPage, recordsPerPage));

            int noOfRecords = countryView.getAirportViews()!= null ? countryView.getAirportViews().size() : 0;
            int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
            int firstPageIndex = Math.max(1, page - numOfPageIndex);
            int lastPageIndex = Math.min(noOfPages, page + numOfPageIndex);
            request.setAttribute("countryView", countryVO);
            request.setAttribute("noOfPages", noOfPages);
            request.setAttribute("currentPage", page);
            request.setAttribute("firstPageIndex", firstPageIndex);
            request.setAttribute("lastPageIndex", lastPageIndex);
            request.setAttribute("showResult", true);
            request.getRequestDispatcher("/index.jsp").forward(request , response);

        } catch (Exception e) {
            logger.error(e, e);
            request.setAttribute("exception", e);
            request.getRequestDispatcher("/errorPage.jsp").forward(request, response);
        }
    }
}
