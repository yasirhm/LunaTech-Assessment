package presentation;

import model.Airport;
import model.Country;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by Yasi on 11/16/2017.
 */
public class CountryView implements Serializable{

    public CountryView(Country country){
        this.name =  country.getName();
        this.code = country.getCode();
        airports = new ArrayList<AirportView>();
        Set<Airport> airports = country.getAirports();
        for (Airport airport : airports) {
            this.airports.add(new AirportView(airport));
        }
    }
    private String name;
    private String code;
    private List<AirportView> airports;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<AirportView> getAirports() {
        return airports;
    }

    public void setAirports(List<AirportView> airports) {
        this.airports = airports;
    }

    public String getCode() {
        return code;
    }
}
