package domain;

import exception.ChickenException;
import java.util.HashMap;
import java.util.Map;
import view.OutputView;

public class Table {

    public static final int SALE_CRITERIA = 10;
    public static final int MAXIMUM_FOOD_AMOUNT = 99;
    private final int number;
    private final Map<Menu, Integer> menus;

    public Table(final int number) {
        this.number = number;
        menus = new HashMap<>();
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }

    public void add(Menu menu, int amount) {
        if (!isNewMenu(menu, amount) && !isOverHundred(menu, amount)) {
            menus.put(menu, menus.get(menu) + amount);
        }
    }

    public boolean isNewMenu(Menu menu, int amount) {
        if (menus.containsKey(menu)) {
            return false;
        }
        menus.put(menu, amount);
        return true;
    }

    public boolean isOverHundred(Menu menu, int amount) {
        if (menus.get(menu) + amount > MAXIMUM_FOOD_AMOUNT) {
            throw new ChickenException("해당 테이블의 메뉴 수량이 100개가 넘습니다.");
        }
        return false;
    }

    public void pay() {
        if (hasMenu()) {
            OutputView.printPayment(number);
            Payment payment = new Payment(this, menus);
            payment.payMoney();
            menus.clear();
            return;
        }
        throw new ChickenException("테이블에 결제할 메뉴가 없습니다.");
    }

    public boolean hasMenu() {
        return !menus.isEmpty();
    }

    public boolean isTable(int number) {
        return this.number == number;
    }

    public int isMoreThanTen(Menu menu) {
        return menus.get(menu) / SALE_CRITERIA;
    }

}
