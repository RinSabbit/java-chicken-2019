package view;

import domain.MainScreen;
import domain.Menu;
import domain.Table;
import exception.ChickenException;
import java.util.List;

public class OutputView {

    public static final String TABLE_LIST = "## 테이블 목록";
    public static final String CHOOSE_PAYMENT = "## 신용카드는 1번, 현금은 2번";
    public static final String FINAL_PAY_PRICE = "## 최종 결제할 금액";
    public static final String WON = "원";
    public static final String PAY_TABLE = "번 테이블의 결제를 진행합니다.";
    public static final String GUIDE_PREFIX = "## ";
    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String BOTTOM_LINE = "└ ─ ┘";
    private static final String ORDER_BOTTOM_LINE = "└ ₩ ┘";
    private static final String MAIN_SCREEN_CATEGORY = "## 메인 화면";
    private static final String CHOOSE_CATEGORY = "## 원하는 기능을 선택하세요.";
    private static final String CHOOSE_TABLE = "## 테이블을 선택하세요.";
    private static final String CHOOSE_FOOD_MENU = "## 등록할 메뉴를 선택하세요.";
    private static final String INPUT_FOOD_AMOUNT = "## 메뉴의 수량을 입력하세요.";

    public static void printTables(final List<Table> tables) {
        System.out.println(TABLE_LIST);
        final int size = tables.size();
        printLine(TOP_LINE, size);
        printTableNumbers(tables);
        checkOrderedTables(tables);
    }

    private static void checkOrderedTables(List<Table> tables) {
        tables.forEach(OutputView::printOrderedTables);
        System.out.println(System.lineSeparator());
    }

    private static void printOrderedTables(Table table) {
        if (table.hasMenu()) {
            System.out.print(ORDER_BOTTOM_LINE);
            return;
        }
        System.out.print(BOTTOM_LINE);
    }

    public static void printMenus(final List<Menu> menus) {
        for (final Menu menu : menus) {
            System.out.println(menu);
        }
    }

    private static void printLine(final String line, final int count) {
        for (int index = 0; index < count; index++) {
            System.out.print(line);
        }
        System.out.println();
    }

    private static void printTableNumbers(final List<Table> tables) {
        for (final Table table : tables) {
            System.out.printf(TABLE_FORMAT, table);
        }
        System.out.println();
    }

    public static void printMainCategory() {
        System.out.println(MAIN_SCREEN_CATEGORY);
        for (MainScreen type : MainScreen.values()) {
            System.out.println(type.getMenu());
        }
    }

    public static void showErrorMessage(ChickenException exception) {
        System.out.println(exception.getMessage());
    }

    public static void printChoice() {
        System.out.println(CHOOSE_CATEGORY);
    }

    public static void chooseMenu() {
        System.out.println(CHOOSE_FOOD_MENU);
    }

    public static void chooseMenuAccount() {
        System.out.println(INPUT_FOOD_AMOUNT);
    }

    public static void choosePayment() {
        System.out.println(CHOOSE_PAYMENT);
    }

    public static void printPayment(int table) {
        System.out.println(GUIDE_PREFIX + table + PAY_TABLE);

    }

    public static void printFinalPrice(double payPrice) {
        System.out.println(FINAL_PAY_PRICE);
        System.out.println(Math.round(payPrice) + WON + System.lineSeparator());
    }

    public static void chooseTable() {
        System.out.println(CHOOSE_TABLE);
    }
}
