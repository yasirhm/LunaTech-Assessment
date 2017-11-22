package presentation;

import manager.ExceptionHandler;

import java.util.*;

/**
 * Created by Yasi on 11/19/2017.
 */
public class ReportView {

    public ReportView(List<Object> airportsCount, List<Object> runwaysTypes, List<Object> runwaysLeIdent){
        if (!airportsCount.isEmpty()){
            this.countriesWithMinAirports = new ArrayList<Object>();
            this.countriesWithMaxAirports = new ArrayList<Object>();
            for (int i =0; i< 10; i++){
                this.countriesWithMinAirports.add(airportsCount.get(i));
                this.countriesWithMaxAirports.add(airportsCount.get(airportsCount.size()-(i+1)));
            }
        }

        if (!runwaysTypes.isEmpty()){
            this.runwaysTypeByCountry = new HashMap<String, List>();
            String prevCountryName = String.valueOf(((Object[]) runwaysTypes.get(0))[0]);
            List<String> types = new ArrayList<String>();
            Iterator itr = runwaysTypes.iterator();
            while (itr.hasNext()){
                Object[] fields = (Object[]) itr.next();
                String newCountryName = String.valueOf(fields[0]);
                if (!newCountryName.equals(prevCountryName)){
                    this.runwaysTypeByCountry.put(prevCountryName, types);
                    prevCountryName = newCountryName;
                    types = new ArrayList<String>();
                }
                types.add(String.valueOf(fields[1]));
            }
        }

        if (!runwaysLeIdent.isEmpty()){
            this.commonRunwaysLeIdent = new ArrayList<Object>();
            for(int i=0; i<10 ;i++)
                this.commonRunwaysLeIdent.add(runwaysLeIdent.get(runwaysLeIdent.size()-(i+1)));
        }
    }

    private List<Object> countriesWithMaxAirports;
    private List<Object> countriesWithMinAirports;
    private Map<String,List> runwaysTypeByCountry;
    private List<Object> commonRunwaysLeIdent;
    private String errorMessage = "This report cannot be found.";

    public List<Object> getCountriesWithMaxAirports() {
        return countriesWithMaxAirports;
    }

    public List<Object> getCountriesWithMinAirports() {
        return countriesWithMinAirports;
    }

    public Map<String,List> getRunwaysTypeByCountry() {
        return runwaysTypeByCountry;
    }

    public List<Object> getCommonRunwaysLeIdent() {
        return commonRunwaysLeIdent;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
