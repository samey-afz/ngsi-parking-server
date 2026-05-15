package de.smartcity.ngsiserver.service;

import de.smartcity.ngsiserver.exception.EntityNotFoundException;
import de.smartcity.ngsiserver.model.ParkingEntity;
import de.smartcity.ngsiserver.repository.ParkingRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ParkingService {

    private final ParkingRepository parkingRepository;

    public ParkingEntity getParkingEntity() {
        log.info("Parkplatzdaten werden abgerufen");
        ParkingEntity parkingEntity = parkingRepository.findParkingEntity();

        if (parkingEntity == null) {
            throw new EntityNotFoundException("Parking-Daten nicht gefunden");
        }
        return parkingEntity;
    }
}