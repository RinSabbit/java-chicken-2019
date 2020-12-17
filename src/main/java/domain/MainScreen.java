package domain;

public enum MainScreen {
    ORDER("1 - 주문등록"),
    PAY("2 - 결제하기"),
    EXIT("3 - 프로그램 종료");

    private final String menu;

    MainScreen(String menu){
        this.menu = menu;
    }

    public String getMenu() {
        return menu;
    }
}
