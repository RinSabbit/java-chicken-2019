package controller;

import domain.MainScreen;
import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import exception.ChickenException;
import java.util.List;
import utils.ValidateUtils;
import view.InputView;
import view.OutputView;

public class ChickenController {

    private static List<Table> tables;
    private static List<Menu> menus;

    public ChickenController() {
        tables = TableRepository.tables();
        menus = MenuRepository.menus();
    }

    public void run() {
        OutputView.printMainCategory();
        chooseMainCategory();

    }

    private void chooseMainCategory() {
        try {
            OutputView.printChoice();
            MainScreen.execute(ValidateUtils.isNumber(InputView.inputValue()));
        } catch (ChickenException exception) {
            OutputView.showErrorMessage(exception);
            chooseMainCategory();
        }
    }

    public static void order() {
        OutputView.printTables(tables);
        int tableNumber = InputView.inputTableNumber();
        OutputView.printMenus(menus);
        OutputView.chooseMenu();
        int menuNumber = ValidateUtils.isNumber(InputView.inputValue());
        OutputView.chooseMenuAccount();
        int menuAccount = ValidateUtils.isNumber(InputView.inputValue());
    }

    public static void pay() {
        System.out.println("paty");
    }

    public static void exit() {
    }
}
