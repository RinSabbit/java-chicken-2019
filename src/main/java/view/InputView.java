package view;

import exception.ChickenException;
import java.util.Scanner;
import utils.ValidateUtils;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputTableNumber() {
        System.out.println("## 주문할 테이블을 선택하세요.");
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
