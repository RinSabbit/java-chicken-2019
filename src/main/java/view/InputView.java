package view;

import exception.ChickenException;
import java.util.Scanner;
import utils.ValidateUtils;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputTableNumber() {
        OutputView.chooseTable();
        try{
            return ValidateUtils.isNumber(scanner.nextLine());
        } catch (NumberFormatException exception){
            throw new ChickenException("존재하지 않는 테이블입니다.");
        }
    }

    public static int inputValue() {
        return ValidateUtils.isNumber(scanner.nextLine());
    }
}
