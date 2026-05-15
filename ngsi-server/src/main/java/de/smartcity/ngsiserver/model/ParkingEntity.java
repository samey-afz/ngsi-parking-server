package de.smartcity.ngsiserver.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.List;
import java.util.Map;

@Data
public class ParkingEntity {

    private String id;
    private String type;

    // GeoJSON Geometry-Objekt: { "type": "Point", "coordinates": [-8.51, 41.1] }
    private Geometry geometry;

    // Alle Parkplatz-Eigenschaften gebündelt
    private Properties properties;

    // Innere Klasse für die Geometrie
    @Data
    public static class Geometry {
        private String type;
        private List<Double> coordinates;
    }

    // Innere Klasse für die Properties
    @Data
    public static class Properties {
        private String type;
        private String name;

        // Verschachtelte NGSI-LD Property – als Map
        private Map<String, Object> availableSpotNumber;
        private Map<String, Object> location;

        private int totalSpotNumber;

        @JsonProperty("@context")
        private List<String> context;
    }
}