package presentation;

import model.Airport;
import model.Runway;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by Yasi on 11/16/2017.
 */
public class AirportView implements Serializable {

    public AirportView(Airport airport){
        this.name = airport.getName();
        this.ident = airport.getIdent();
        this.isoRegion = airport.getIsoRegion();
        this.type = airport.getType();
        this.runways = new ArrayList<RunwayView>();
        Set<Runway> runways = airport.getRunways();
        for (Runway runway : runways){
            this.runways.add(new RunwayView(runway));
        }
    }

    private String name;
    private String ident;
    private String isoRegion;
    private String type;
    private List<RunwayView> runways;

    public String getName() {
        return name;
    }

    public String getIdent() {
        return ident;
    }

    public String getType() {
        return type;
    }

    public List<RunwayView> getRunways() {
        return runways;
    }

    public String getIsoRegion() {
        return isoRegion;
    }
}
