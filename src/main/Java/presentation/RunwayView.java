package presentation;

import model.Runway;

/**
 * Created by Yasi on 11/18/2017.
 */
public class RunwayView {

    public RunwayView(Runway runway){
        this.lengthFt = runway.getLengthFt();
        this.widthFt = runway.getWidthFt();
        this.closed = runway.getClosed();
        this.lighted = runway.getLighted();
        this.surface = runway.getSurface();
    }

    private Integer lengthFt;
    private Integer widthFt;
    private String surface;
    private Boolean lighted;
    private Boolean closed;

    public Integer getLengthFt() {
        return lengthFt;
    }

    public Integer getWidthFt() {
        return widthFt;
    }

    public String getSurface() {
        return surface;
    }

    public Boolean getLighted() {
        return lighted;
    }

    public Boolean getClosed() {
        return closed;
    }
}
