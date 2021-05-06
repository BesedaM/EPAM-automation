package by.epam.learn.automation.task0304.util;

public class StringUtils {

    private static final String CHARS_TO_BE_REPLACED="**";

    public static String useValueInString(String oldString,String value){
        return oldString.replace(CHARS_TO_BE_REPLACED,value);
    }
}
