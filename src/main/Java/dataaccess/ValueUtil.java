package dataaccess;

/**
 * Created by Yasi on 11/16/2017.
 */
public class ValueUtil {
    public static boolean IsDefault(Object object){
        if(object == null)
            return true;
        if(object.toString().trim() == "")
            return true;
        return false;
    }
}
