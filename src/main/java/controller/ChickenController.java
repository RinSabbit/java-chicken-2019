package controller;

import domain.MainScreen;
import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import exception.ChickenException;
import java.util.List;
import java.util.Objects;
import view.InputView;
import view.OutputView;

public class ChickenController {

    private static List<Table> tables;
    private static List<Menu> menus;

    private ChickenController() {
    }

    public static void run() {
        initializeChicken();
        chooseMainCategory();
    }

    private static void initializeChicken() {
        if(Objects.isNull(tables)){
            tables = TableRepository.tables();
        }
        if(Objects.isNull(menus)){
            menus = MenuRepository.menus();
        }
    }

    private static void chooseMainCategory() {
        try {
            OutputView.printMainCategory();
            OutputView.printChoice();
            MainScreen.execute(InputView.inputValue());
        } catch (ChickenException exception) {
            OutputView.showErrorMessage(exception);
            chooseMainCategory();
        }
    }

    public static void order() {
        int tableNumber = showTable();
        OutputView.printMenus(menus);
        OutputView.chooseMenu();
        int menuNumber = InputView.inputValue();
        OutputView.chooseMenuAccount();
        int menuAccount = InputView.inputValue();
        Table table = TableRepository.getTable(tableNumber);
        table.add(MenuRepository.getMenu(menuNumber), menuAccount);
        run();
    }

    public static void pay() {
        int tableNumber = showTable();
        Table table = TableRepository.getTable(tableNumber);
        table.pay();
        run();
    }

    public static void exit() {
    }

    private static int showTable() {
        OutputView.printTables(tables);
        return InputView.inputTableNumber();
    }
}
