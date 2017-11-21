package model;


import javax.persistence.*;
import static javax.persistence.GenerationType.IDENTITY;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by Yasi on 11/16/2017.
 */
@Entity
@Table(name = "country", uniqueConstraints = {
        @UniqueConstraint(columnNames = "name"),
        @UniqueConstraint(columnNames = "code") })

public class Country implements Serializable {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "code", unique = true, nullable = false)
    private String code;

    @Column(name = "name", unique = true)
    private String name;
    private String continentCode;
    private String wikipediaLink;
    private String keywords;

    @OneToMany(fetch = FetchType.LAZY, cascade =  CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "countryId" , referencedColumnName = "id")
    private Set<Airport>airports;

    public Country() {
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContinentCode() {
        return continentCode;
    }

    public void setContinentCode(String continentCode) {
        this.continentCode = continentCode;
    }

    public String getWikipediaLink() {
        return wikipediaLink;
    }

    public void setWikipediaLink(String wikipediaLink) {
        this.wikipediaLink = wikipediaLink;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public int getId() {
        return id;
    }

    public Set<Airport> getAirports() {
        return airports;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAirports(Set<Airport> airports) {
        this.airports = airports;
    }
}
