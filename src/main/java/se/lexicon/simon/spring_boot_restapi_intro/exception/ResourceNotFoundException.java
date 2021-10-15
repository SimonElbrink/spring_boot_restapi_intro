package se.lexicon.simon.spring_boot_restapi_intro.exception;


/**
 * Custom Exception
 * @author Simon Elbrink
 */
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
