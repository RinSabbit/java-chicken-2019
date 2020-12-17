package domain;

import controller.ChickenController;
import exception.ChickenException;
import java.util.Arrays;

public enum MainScreen {
    ORDER(1, "1 - 주문등록", ChickenController::order),
    PAY(2, "2 - 결제하기", ChickenController::pay),
    EXIT(3, "3 - 프로그램 종료", ChickenController::exit);

    private final int choice;
    private final String menu;
    private final Runnable handler;

    MainScreen(int choice, String menu, Runnable handler) {
        this.choice = choice;
        this.menu = menu;
        this.handler = handler;
    }

    public static void execute(int input) {
        Arrays.stream(values())
            .filter(value -> value.getChoice() == input)
            .findFirst()
            .orElseThrow(() -> new ChickenException("선택할 수 없는 값입니다."))
            .handler.run();
    }

    public int getChoice() {
        return choice;
    }

    public String getMenu() {
        return menu;
    }

}
