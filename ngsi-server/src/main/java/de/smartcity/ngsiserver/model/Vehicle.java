package de.smartcity.ngsiserver.model;

import lombok.Data;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Map;

//@Data generiert automatisch: Getter, Setter, toString, equals, hasCode
@Data
public class Vehicle {
    //id: "urn:ngsi-Id:Vehicle:A4567
    private String id;

    //type: "Vehicle"
    private String type;

    //brandName: {type:Property, value:Mercedes;
    private Map<String, Object> brandName;

    //isParked
    private Map<String, Object> isParked;

    // "category": { "type": "VocabularyProperty", "vocab": "non-commercial" }
    private Map<String, Object> category;

    // "street": { "type": "LanguageProperty", "languageMap": {...} }
    private Map<String, Object> street;

    // "@context": [ "http://..." ] – das @ muss gemappt werden
    @JsonProperty("@context")
    private List<String> context;

}
