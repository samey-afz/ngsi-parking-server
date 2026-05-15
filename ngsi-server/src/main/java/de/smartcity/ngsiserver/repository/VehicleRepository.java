package de.smartcity.ngsiserver.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.smartcity.ngsiserver.model.Vehicle;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;

// @Repository markiert diese Klasse als Data Access Layer (dein Diagramm)
// @Slf4j gibt uns einen Logger via Lombok – kein System.out.println!
@Repository
@Slf4j
public class VehicleRepository {

    private Vehicle vehicle;
    private final ObjectMapper objectMapper = new ObjectMapper();

    // @PostConstruct: wird einmal beim Start der Anwendung aufgerufen
    // Lädt die JSON-Datei in den Speicher – einmal laden, immer verfügbar
    @PostConstruct
    public void init() {
        try {
            // ClassPathResource sucht in src/main/resources/
            var resource = new ClassPathResource("data/vehicle.json");
            vehicle = objectMapper.readValue(resource.getInputStream(), Vehicle.class);
            log.info("Vehicle-Daten erfolgreich geladen: {}", vehicle.getId());
        } catch (Exception e) {
            log.error("Fehler beim Laden der Vehicle-Daten: {}", e.getMessage());
            throw new RuntimeException("Vehicle-Daten konnten nicht geladen werden", e);
        }
    }

    // Gibt das geladene Vehicle-Objekt zurück
    public Vehicle findVehicle() {
        return vehicle;
    }
}