# NGSI-LD Parking Server

NGSI-LD HTTP Server für Parkplatzdaten – Smart Cities Modul SoSe 2026

## Beschreibung

Dieser Server implementiert eine NGSI-LD konforme REST API für Parkplatzdaten.
Er wurde im Rahmen des Moduls "Informations- und Kommunikationstechnologie für 
Smart Cities" entwickelt und basiert auf dem ETSI NGSI-LD Standard.

## Technologien

| Technologie | Version | Zweck |
|---|---|---|
| Java | 21 | Programmiersprache |
| Spring Boot | 4.0.6 | HTTP Server Framework |
| Jackson | 3.x | JSON Serialisierung |
| Lombok | 1.18.x | Boilerplate-Reduzierung |
| springdoc-openapi | 2.8.8 | API Dokumentation |
| Maven | 3.x | Build Tool |

## Architektur

```
Client (HTTP)
    ↓
Controller (REST Endpoints)
    ↓
Service (Business Logic)
    ↓
Repository (Data Access Layer)
    ↓
JSON Dateien (vehicle.json, parking.json)
```


## Endpoints

| Method | Endpoint | Beschreibung |
|---|---|---|
| GET | /vehicle | Gibt NGSI-LD Fahrzeugdaten zurück |
| POST | /vehicle | Nimmt NGSI-LD Fahrzeugdaten entgegen |
| GET | /parking | Gibt NGSI-LD Parkplatzdaten zurück |
| POST | /parking | Nimmt NGSI-LD Parkplatzdaten entgegen |

## Starten

```bash
# Server starten
./mvnw spring-boot:run

# Oder direkt in IntelliJ: NgsiServerApplication.java ausführen
```

## Testen

```bash
# GET Vehicle
curl -X GET http://localhost:8080/vehicle

# GET Parking  
curl -X GET http://localhost:8080/parking

# POST Vehicle
curl -X POST http://localhost:8080/vehicle \
  -H "Content-Type: application/json" \
  -d '{"id":"urn:ngsi-ld:Vehicle:Test","type":"Vehicle"}'

# POST Parking
curl -X POST http://localhost:8080/parking \
  -H "Content-Type: application/json" \
  -d '{"id":"urn:ngsi-ld:OffStreetParking:Test","type":"Feature"}'
```

## API Dokumentation

Nach dem Start erreichbar unter:
- Swagger UI: http://localhost:8080/swagger-ui.html
- OpenAPI JSON: http://localhost:8080/v3/api-docs
