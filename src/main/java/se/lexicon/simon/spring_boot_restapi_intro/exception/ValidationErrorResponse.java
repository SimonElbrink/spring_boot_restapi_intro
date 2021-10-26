package se.lexicon.simon.spring_boot_restapi_intro.exception;

import java.time.LocalDateTime;
import java.util.List;

public class ValidationErrorResponse extends MyExceptionResponse{

    private final List<Violation> violations;

    public ValidationErrorResponse(LocalDateTime timestamp, Integer status, String value, String message, String path, List<Violation> violations) {
        super(timestamp, status, value, message, path);
        this.violations = violations;
    }
    public ValidationErrorResponse( MyExceptionResponse response, List<Violation> violations) {
        super(response.getTimestamp(), response.getStatus(), response.getValue(), response.getMessage(), response.getPath());
        this.violations = violations;
    }

    public List<Violation> getViolations() {
        return violations;
    }
}
