package de.smartcity.ngsiserver.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.smartcity.ngsiserver.model.ParkingEntity;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class ParkingRepository {

    private ParkingEntity parkingEntity;
    private final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Warum verwenden wir hier "PostConstruct"?
     * Spring startet
     * ->erstellt alle Beans (Repository, Service, Controller)
     * ->JSON wird eingelesen und im Speicher gehalten
     * -> server ist bereit für Anfragen
     *
     * Die Daten werden einmal beim Start geladen - nicht bei jeder Anfrage neu von der
     * Festplatte gelesen. Das ist effizienter!
     */

    @PostConstruct
    public void init() {
        try {
            var resource = new ClassPathResource("data/parking.json");
            parkingEntity = objectMapper.readValue(
                    resource.getInputStream(), ParkingEntity.class
            );
            log.info("Parking-Daten erfolgreich geladen: {}", parkingEntity.getId());
        } catch (Exception e) {
            log.error("Fehler beim Laden der Parking-Daten: {}", e.getMessage());
            throw new RuntimeException("Parking-Daten konnten nicht geladen werden", e);
        }
    }

    public ParkingEntity findParkingEntity() {
        return parkingEntity;
    }
}