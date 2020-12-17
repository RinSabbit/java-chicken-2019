package domain;

import exception.ChickenException;
import java.util.Map;
import view.InputView;
import view.OutputView;

public class Payment {

    public static final int AMOUNT_SALE_PRICE = 10_000;
    public static final double CASH_SALE_RATIO = 0.95;
    public static final int CARD_PAY = 1;
    public static final int CASH_PAY = 2;
    private final Table table;
    private final Map<Menu, Integer> menus;
    private double payPrice;
    private int count;

    public Payment(Table table, Map<Menu, Integer> menus) {
        this.table = table;
        this.menus = menus;
        payPrice = 0;
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
        if (payment == CASH_PAY) {
            payPrice *= CASH_SALE_RATIO;
            return;
        }
        if (payment != CARD_PAY) {
            throw new ChickenException("존재하지 않는 결제 수단입니다.");
        }
    }

    public void amountSale() {
        menus.forEach((menu, amount) -> countPerTen(menu));
        while (count != 0) {
            payPrice -= AMOUNT_SALE_PRICE;
            count--;
        }
    }

    public void countPerTen(Menu menu) {
        if (menu.isChicken()) {
            count += table.isMoreThanTen(menu);
        }
    }

}
