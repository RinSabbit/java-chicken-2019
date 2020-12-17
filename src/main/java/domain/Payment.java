package domain;

import java.util.Map;
import view.InputView;
import view.OutputView;

public class Payment {

    private final Table table;
    private final Map<Menu, Integer> menus;
    private double payPrice;
    private int count;

    public Payment(Table table, Map<Menu, Integer> menus) {
        this.table = table;
        this.menus = menus;
        count = 0;
    }

    public void payMoney() {
        menus.forEach((menu, amount) -> payPrice += menu.calculatePrice(amount));
        amountSale();
        paymentSale();
        OutputView.printFinalPrice(payPrice);
    }

    public void paymentSale() {
        OutputView.choosePayment();
        int payment = InputView.inputValue();
        if (payment == 2) {
            payPrice *= 0.95;
        }
    }

    public void amountSale() {
        menus.forEach((menu, amount) -> countPerTen(menu));
        while (count != 0) {
            payPrice -= 10000;
            count--;
        }
    }

    public void countPerTen(Menu menu) {
        count += table.isMoreThanTen(menu);
    }

}
