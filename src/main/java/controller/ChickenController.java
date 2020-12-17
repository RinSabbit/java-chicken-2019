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

    public void run() {
        chooseMainCategory();

        final List<Table> tables = TableRepository.tables();
        OutputView.printTables(tables);

        final int tableNumber = InputView.inputTableNumber();

        final List<Menu> menus = MenuRepository.menus();
        OutputView.printMenus(menus);
    }

    private void chooseMainCategory() {
        OutputView.printMainCategory();
        try {
            String value = ValidateUtils.isValidMainCategory(InputView.inputValue());
        } catch (ChickenException exception){
            OutputView.showErrorMessage(exception);
            chooseMainCategory();
        }
    }
}
