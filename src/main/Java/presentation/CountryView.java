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
        airportViews = new ArrayList<AirportView>();
        Set<Airport> airports = country.getAirports();
        for (Airport airport : airports) {
            this.airportViews.add(new AirportView(airport));
        }
    }

    public CountryView(String name, String code){
        this.name =  name;
        this.code = code;
        airportViews = new ArrayList<AirportView>();
    }

    private String name;
    private String code;
    private List<AirportView> airportViews;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<AirportView> getAirportViews() {
        return airportViews;
    }

    public void setAirportViews(List<AirportView> airportViews) {
        this.airportViews = airportViews;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
