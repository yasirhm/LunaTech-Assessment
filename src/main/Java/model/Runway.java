package model;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by Yasi on 11/16/2017.
 */
@Entity
@Table(name = "runway")
public class Runway implements Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    private int id;

    //private Integer airportRef;
    private String airportIdent;
    private Integer lengthFt;
    private Integer widthFt;
    private String surface;
    private Boolean lighted;
    private Boolean closed;
    private String leIdent;
    private String leLatitudeDeg;
    private String leLongitudeDeg;
    private String leElevationFt;
    private String leHeadingDegT;
    private String leDisplacedThresholdFt;
    private String heIdent;
    private String heLatitudeDeg;
    private String heLongitudeDeg;
    private String heElevationFt;
    private String heHeadingDegT;
    private String heDisplacedThresholdFt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "airportId", nullable = false)
    private Airport airport;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAirportIdent() {
        return airportIdent;
    }

    public void setAirportIdent(String airportIdent) {
        this.airportIdent = airportIdent;
    }

    public Integer getLengthFt() {
        return lengthFt;
    }

    public void setLengthFt(Integer lengthFt) {
        this.lengthFt = lengthFt;
    }

    public Integer getWidthFt() {
        return widthFt;
    }

    public void setWidthFt(Integer widthFt) {
        this.widthFt = widthFt;
    }

    public String getSurface() {
        return surface;
    }

    public void setSurface(String surface) {
        this.surface = surface;
    }

    public Boolean getLighted() {
        return lighted;
    }

    public void setLighted(Boolean lighted) {
        this.lighted = lighted;
    }

    public Boolean getClosed() {
        return closed;
    }

    public void setClosed(Boolean closed) {
        this.closed = closed;
    }

    public String getLeIdent() {
        return leIdent;
    }

    public void setLeIdent(String leIdent) {
        this.leIdent = leIdent;
    }

    public String getLeLatitudeDeg() {
        return leLatitudeDeg;
    }

    public void setLeLatitudeDeg(String leLatitudeDeg) {
        this.leLatitudeDeg = leLatitudeDeg;
    }

    public String getLeLongitudeDeg() {
        return leLongitudeDeg;
    }

    public void setLeLongitudeDeg(String leLongitudeDeg) {
        this.leLongitudeDeg = leLongitudeDeg;
    }

    public String getLeElevationFt() {
        return leElevationFt;
    }

    public void setLeElevationFt(String leElevationFt) {
        this.leElevationFt = leElevationFt;
    }

    public String getLeHeadingDegT() {
        return leHeadingDegT;
    }

    public void setLeHeadingDegT(String leHeadingDegT) {
        this.leHeadingDegT = leHeadingDegT;
    }

    public String getLeDisplacedThresholdFt() {
        return leDisplacedThresholdFt;
    }

    public void setLeDisplacedThresholdFt(String leDisplacedThresholdFt) {
        this.leDisplacedThresholdFt = leDisplacedThresholdFt;
    }

    public String getHeIdent() {
        return heIdent;
    }

    public void setHeIdent(String heIdent) {
        this.heIdent = heIdent;
    }

    public String getHeLatitudeDeg() {
        return heLatitudeDeg;
    }

    public void setHeLatitudeDeg(String heLatitudeDeg) {
        this.heLatitudeDeg = heLatitudeDeg;
    }

    public String getHeLongitudeDeg() {
        return heLongitudeDeg;
    }

    public void setHeLongitudeDeg(String heLongitudeDeg) {
        this.heLongitudeDeg = heLongitudeDeg;
    }

    public String getHeElevationFt() {
        return heElevationFt;
    }

    public void setHeElevationFt(String heElevationFt) {
        this.heElevationFt = heElevationFt;
    }

    public String getHeHeadingDegT() {
        return heHeadingDegT;
    }

    public void setHeHeadingDegT(String heHeadingDegT) {
        this.heHeadingDegT = heHeadingDegT;
    }

    public String getHeDisplacedThresholdFt() {
        return heDisplacedThresholdFt;
    }

    public void setHeDisplacedThresholdFt(String heDisplacedThresholdFt) {
        this.heDisplacedThresholdFt = heDisplacedThresholdFt;
    }

    public Airport getAirport() {
        return airport;
    }

    public void setAirport(Airport airport) {
        this.airport = airport;
    }
}
