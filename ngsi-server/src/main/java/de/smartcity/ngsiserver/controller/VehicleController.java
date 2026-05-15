package de.smartcity.ngsiserver.controller;

import de.smartcity.ngsiserver.model.Vehicle;
import de.smartcity.ngsiserver.service.VehicleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// @Tag: Swagger UI gruppiert alle Endpoints unter "Vehicle"
@Tag(name = "Vehicle", description = "NGSI-LD Fahrzeug-Endpunkte")
@RestController
@RequestMapping("/vehicle")
@RequiredArgsConstructor
public class VehicleController {

    private final VehicleService vehicleService;

    // GET /vehicle – liefert das Vehicle-Objekt als NGSI-LD JSON
    @Operation(summary = "Gibt NGSI-LD Fahrzeugdaten zurück")
    @GetMapping
    public ResponseEntity<Vehicle> getVehicle() {
        return ResponseEntity.ok(vehicleService.getVehicle());
    }

    // POST /vehicle – nimmt ein Vehicle-Objekt entgegen
    // Im Moment echo wir es zurück – kein Speichern nötig für die Aufgabe
    @Operation(summary = "Nimmt NGSI-LD Fahrzeugdaten entgegen")
    @PostMapping
    public ResponseEntity<Vehicle> postVehicle(@RequestBody Vehicle vehicle) {
        return ResponseEntity.ok(vehicle);
    }
}