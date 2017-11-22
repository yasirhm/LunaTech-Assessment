package presentation;

/**
 * Created by Yasi on 11/16/2017.
 */
public class SearchInfo {
    private String name;
    private String code;

    public SearchInfo(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }
    public String getCode() {
        return code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
