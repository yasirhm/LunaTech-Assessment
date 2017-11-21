package manager;

import dataaccess.CountryDao;
import model.Country;
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

    public CountryView searchCountry(SearchInfo searchInfo)throws DataAccessException {
        Country sample = new Country();
        sample.setCode(searchInfo.getCode());
        sample.setName(searchInfo.getName());
        Collection<Country> countries = new CountryDao().Find(sample);
        if(countries.isEmpty()){
            throw new DataAccessException("Country Not Found.", "country");
        }
        Country country = (Country) countries.toArray()[0];
        CountryView result = new CountryView(country);
        return result;
    }

    public ReportView getReport() throws DataAccessException {
        CountryDao countryDao = new CountryDao();
        List<Object> airportsCount = countryDao.getAirportsCount();
        List<Object> runwaysType = countryDao.countriesRunwaysType();
        List<Object> runwaysLeIdent = countryDao.commonRunwaysLeIdent();

        List<DataAccessException> exceptions =new ArrayList<DataAccessException>();
        if (airportsCount.isEmpty())
            exceptions.add(new DataAccessException("No airport found for this country.", "airport"));
        if (runwaysType.isEmpty())
            exceptions.add(new DataAccessException("No runway found for the airports.", "runway"));
        if (runwaysLeIdent.isEmpty())
            exceptions.add(new DataAccessException("No common runway found.", "commonRunway"));

        return new ReportView(airportsCount, runwaysType, runwaysLeIdent);
//        if (exceptions.size() == 3)
//             return new  ReportView(airportsCount, runwaysType, commonRunwaysIdent);
        //else if (exceptions.)

    }
}

