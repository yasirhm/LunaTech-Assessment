package manager;

import dataaccess.CountryDao;
import model.Country;
import presentation.AirportView;
import presentation.ReportView;
import presentation.SearchInfo;
import presentation.CountryView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Yasi on 11/16/2017.
 */
public class Manager {

    public CountryView searchCountry(SearchInfo searchInfo)throws ExceptionHandler {
        Country sample = new Country();
        sample.setCode(searchInfo.getCode());
        sample.setName(searchInfo.getName());

        Collection<Country> countries = new CountryDao().Find(sample);
        if(countries.isEmpty()){
            throw new ExceptionHandler(ExceptionHandler.NOT_FOUND_COUNTRY);
        }
        Country country = (Country) countries.toArray()[0];
        CountryView result = new CountryView(country);
        return result;
    }

    public ReportView getReport() throws ExceptionHandler {
        CountryDao countryDao = new CountryDao();
        List<Object> airportsCount = countryDao.getAirportsCount();
        List<Object> runwaysType = countryDao.countriesRunwaysType();
        List<Object> runwaysLeIdent = countryDao.commonRunwaysLeIdent();
        if (airportsCount.isEmpty() && runwaysType.isEmpty() && runwaysLeIdent.isEmpty())
            throw new ExceptionHandler(ExceptionHandler.NOT_FOUND_REPORT);

        return new ReportView(airportsCount, runwaysType, runwaysLeIdent);
    }

    public List<AirportView> getAirportVOListToDisplay(List<AirportView> list, int offset, int noOfRecords) {
        List<AirportView> airportViewList = new ArrayList<AirportView>();
        int last = offset + noOfRecords;
        if (list.size() < last)
            last = list.size();
        for (int i = offset; i < last; i++) {
            airportViewList.add(list.get(i));
        }
        return airportViewList;
    }
}

