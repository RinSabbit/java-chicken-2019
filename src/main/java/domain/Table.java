package domain;

import exception.ChickenException;
import java.util.HashMap;
import java.util.Map;

public class Table {
    private final int number;
    private final Map<Menu,Integer> menus;
    private int payPrice = 0;

    public Table(final int number) {
        this.number = number;
        menus = new HashMap<>();
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }

    public void add(Menu menu, int amount){
        if(!isNewMenu(menu,amount) && !isOverHundred(menu,amount)){
            menus.put(menu,menus.get(menu) + amount);
        }
    }

    public boolean isNewMenu(Menu menu, int amount){
        if(menus.containsKey(menu)){
            return true;
        }
        menus.put(menu,amount);
        return false;
    }

    public boolean isOverHundred(Menu menu, int amount){
        if(menus.get(menu) + amount > 99){
            throw new ChickenException("해당 테이블의 메뉴 수량이 100개가 넘습니다.");
        }
        return false;
    }

    public void pay(){
        menus.forEach((menu, amount) -> payPrice += menu.calculatePrice(amount));
    }

    public boolean hasMenu(){
        return !menus.isEmpty();
    }

    public boolean isTable(int number){
        return this.number == number;
    }

}
