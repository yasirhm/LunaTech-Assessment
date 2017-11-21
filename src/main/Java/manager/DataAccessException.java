package manager;

/**
 * Created by Yasi on 11/19/2017.
 */
public class DataAccessException extends Exception {
    public DataAccessException(String message, String dataTypeError) {
        super(message);
        this.dataTypeError = dataTypeError;
    }
    private String dataTypeError;

    public String getDataTypeError() {
        return dataTypeError;
    }
}
