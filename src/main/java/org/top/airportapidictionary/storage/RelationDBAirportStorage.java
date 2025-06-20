package org.top.airportapidictionary.storage;

import org.top.airportapidictionary.model.Airport;
import org.top.airportapidictionary.model.AirportStorage;

import java.util.List;
import java.util.Optional;

// RelationDBAirportStorage - реализация AirportStorage, работающая с РСУБД через JPA-репозиторий
public class RelationDBAirportStorage implements AirportStorage {

    private final AirportRepository repository;

    public RelationDBAirportStorage(AirportRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Airport> selectAll() {
        return repository.findAll()
                .stream()
                .map(AirportDbEntity::asAirport)
                .toList();
    }

    @Override
    public Optional<Airport> selectByCode(String code) {
        Optional<AirportDbEntity> dbAirport = repository.findByCode(code);
        return dbAirport.map(AirportDbEntity::asAirport);
    }

    @Override
    public void insert(Airport airport) {
        AirportDbEntity dbAirport = new AirportDbEntity(airport);
        repository.save(dbAirport);
    }

    @Override
    public void deleteByCode(String code) {
        Optional<AirportDbEntity> deleted = repository.findByCode(code);
        deleted.ifPresent(repository::delete);
    }

    @Override
    public void update(Airport airport) {
        Optional<AirportDbEntity> dbAirportOptional = repository.findByCode(airport.getCode());
        if (dbAirportOptional.isEmpty()) {
            return;
        }
        // в dbAirport задан id существующей в БД записи
        AirportDbEntity dbAirport = dbAirportOptional.get();
        dbAirport.setName(airport.getName());
        dbAirport.setRunwayCount(airport.getRunwayCount());
        repository.save(dbAirport);
    }
}
