import manager.ExceptionHandler;
import manager.Manager;
import model.Country;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import presentation.SearchInfo;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Yasi on 11/22/2017.
 */
public class TestManagerDetails {
    protected String countryName;
    protected String countryCode;
    protected Manager manager = new Manager();
    protected Country country = new Country();
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Before
    public void setUp() {
        countryCode = "IR";
        countryName = "Iran";
        country.setName(countryName);
        country.setCode(countryCode);
    }

    @Test
    public void testSearchCountry() throws ExceptionHandler{
        SearchInfo searchInfo = new SearchInfo(countryName,"");
        assertTrue("testSearchCountry : ", manager.searchCountry(searchInfo).getCode().equals("IR"));
        assertEquals(manager.searchCountry(searchInfo).getAirportViews().size(), 112);
        searchInfo.setName("France");
        assertTrue("testSearchCountry : ", manager.searchCountry(searchInfo).getCode().equals("FR"));
        assertEquals(manager.searchCountry(searchInfo).getAirportViews().size(), 782);
    }

    //tearDown used to close the connection or clean up activities
    @After
    public void tearDown(  ) {
    }
}
