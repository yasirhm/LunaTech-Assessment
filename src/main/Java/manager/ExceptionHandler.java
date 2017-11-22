package manager;

/**
 * Created by Yasi on 11/19/2017.
 */
public class ExceptionHandler extends Exception {

    public static final String INVALID_INPUT = "Invalid input!";
    public static final String NOT_FOUND_COUNTRY = "Country info is not valid!";
    public static final String NOT_FOUND_RUNWAY= "Runways are not found!";
    public static final String NOT_FOUND_AIRPORT = "Airports are not found!";
    public static final String NOT_FOUND_REPORT = "No report is found!";

    public ExceptionHandler() {
    }

    public ExceptionHandler(String message) {
        super(message);
    }

    public ExceptionHandler(String message, Throwable cause) {
        super(message, cause);
    }

    public ExceptionHandler(Throwable cause) {
        super(cause);
    }
}