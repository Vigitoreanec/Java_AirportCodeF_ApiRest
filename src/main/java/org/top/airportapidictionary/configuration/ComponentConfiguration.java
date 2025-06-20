package org.top.airportapidictionary.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.top.airportapidictionary.model.AirportScenario;
import org.top.airportapidictionary.model.AirportStorage;
import org.top.airportapidictionary.storage.AirportRepository;
import org.top.airportapidictionary.storage.RelationDBAirportStorage;
import org.top.airportapidictionary.stub.AirportStorageStub;

// ComponentConfiguration - класс-провайдер для создания сервисов
// с целью последующей инъекции в Spring-приложение
@Configuration
public class ComponentConfiguration {

    private final AirportRepository repository;

    public ComponentConfiguration(AirportRepository repository){
        this.repository = repository;
    }

    @Bean
    public AirportScenario airports() {
        return new AirportScenario(new RelationDBAirportStorage(repository));
    }

//    @Bean
//    public AirportScenario airports() {
//        return new AirportScenario(new AirportStorageStub());
//    }

}
