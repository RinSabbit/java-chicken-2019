package utils;

import exception.ChickenException;

public class ValidateUtils {

    public static int isNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new ChickenException("숫자를 입력해야 합니다.");
        }
    }

}
