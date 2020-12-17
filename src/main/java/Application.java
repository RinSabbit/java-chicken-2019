import controller.ChickenController;
import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import exception.ChickenException;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        ChickenController chickenController = new ChickenController();
        chickenController.run();

    }
}
