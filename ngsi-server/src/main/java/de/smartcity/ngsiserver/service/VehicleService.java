package de.smartcity.ngsiserver.service;

import de.smartcity.ngsiserver.exception.EntityNotFoundException;
import de.smartcity.ngsiserver.model.Vehicle;
import de.smartcity.ngsiserver.repository.VehicleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

// @RequiredArgsConstructor: Lombok generiert einen Konstruktor
// für alle final-Felder – das ist Dependency Injection ohne @Autowired
@Service
@RequiredArgsConstructor
@Slf4j
public class VehicleService {

    private final VehicleRepository vehicleRepository;

    public Vehicle getVehicle() {
        log.info("Fahrzeugdaten werden abgerufen");
        Vehicle vehicle = vehicleRepository.findVehicle();

        // Wenn Repository null zurückgibt → EntityNotFoundException
        // Das entspricht dem Fehlerfluss in deinem Architekturdiagramm
        if (vehicle == null) {
            throw new EntityNotFoundException("Vehicle-Daten nicht gefunden");
        }
        return vehicle;
    }
}