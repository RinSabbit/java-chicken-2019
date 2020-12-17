package view;

import domain.MainScreen;
import domain.Menu;
import domain.Table;

import exception.ChickenException;
import java.util.List;
import java.util.stream.IntStream;

public class OutputView {
    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String BOTTOM_LINE = "└ ─ ┘";
    private static final String MAIN_SCREEN_CATEGORY = "## 메인 화면";
    private static final String CHOOSE_CATEGORY = "## 원하는 기능을 선택하세요.";
    private static final String CHOOSE_TABLE = "## 테이블을 선택하세요.";
    private static final String CHOOSE_FOOD_MENU = "## 등록할 메뉴를 선택하세요.";
    private static final String INPUT_FOOD_AMOUNT = "## 메뉴의 수량을 입력하세요.";

    public static void printTables(final List<Table> tables) {
        System.out.println("## 테이블 목록");
        final int size = tables.size();
        printLine(TOP_LINE, size);
        printTableNumbers(tables);
        printLine(BOTTOM_LINE, size);
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
        for(MainScreen type : MainScreen.values()){
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

    public static void chooseMenuAccount(){
        System.out.println(INPUT_FOOD_AMOUNT);
    }
}
