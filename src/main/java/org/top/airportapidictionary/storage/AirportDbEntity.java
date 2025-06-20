package org.top.airportapidictionary.storage;

import jakarta.persistence.*;
import org.top.airportapidictionary.model.Airport;

// AirportDbEntity - сущность, описывающая запись в БД в таблице аэропортов
@Entity
@Table(name="airport")
public class AirportDbEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "code", nullable = false, unique = true)
    private String code;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "runway_count", nullable = false)
    private Integer runwayCount;

    public AirportDbEntity() {
    }

    public AirportDbEntity(Airport airport) {
        id = null;
        code = airport.getCode();
        name = airport.getName();
        runwayCount = airport.getRunwayCount();
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
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
    public Integer getRunwayCount() {
        return runwayCount;
    }
    public void setRunwayCount(Integer runwayCount) {
        this.runwayCount = runwayCount;
    }

    public Airport asAirport() {
        return new Airport(code, name, runwayCount);
    }
}
