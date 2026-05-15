package de.smartcity.ngsiserver.controller;

import de.smartcity.ngsiserver.model.ParkingEntity;
import de.smartcity.ngsiserver.service.ParkingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Parking", description = "NGSI-LD Parkplatz-Endpunkte")
@RestController
@RequestMapping("/parking")
@RequiredArgsConstructor
public class ParkingController {

    private final ParkingService parkingService;

    // GET /parking – liefert die ParkingEntity als NGSI-LD GeoJSON
    @Operation(summary = "Gibt NGSI-LD Parkplatzdaten zurück")
    @GetMapping
    public ResponseEntity<ParkingEntity> getParking() {
        return ResponseEntity.ok(parkingService.getParkingEntity());
    }

    // POST /parking – nimmt eine ParkingEntity entgegen
    @Operation(summary = "Nimmt NGSI-LD Parkplatzdaten entgegen")
    @PostMapping
    public ResponseEntity<ParkingEntity> postParking(
            @RequestBody ParkingEntity parkingEntity) {
        return ResponseEntity.ok(parkingEntity);
    }
}