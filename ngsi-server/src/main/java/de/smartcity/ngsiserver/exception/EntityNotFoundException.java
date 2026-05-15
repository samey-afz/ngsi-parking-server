package de.smartcity.ngsiserver.exception;


// @ResponseStatus: Spring gibt automatisch HTTP 404 zurück
// wenn diese Exception geworfen wird – kein extra Code nötig
//@ResponseStatus(HttpStatus.NOT_FOUND)
public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(String message) {
        super(message);
    }
}