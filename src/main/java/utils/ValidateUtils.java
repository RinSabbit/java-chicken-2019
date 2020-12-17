package utils;

import domain.MainScreen;
import exception.ChickenException;
import java.util.Arrays;
import java.util.List;

public class ValidateUtils {

    public static int isNumber(String input){
        try{
            return Integer.parseInt(input);
        } catch (NumberFormatException exception){
            throw new ChickenException("숫자를 입력해야 합니다.");
        }
    }

}
