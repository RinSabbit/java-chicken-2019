# java-chicken-2019

> 6:40 ~ 

## 기능 요구사항
- [ ] 치킨집 사장님이 사용하는 간단한 포스(POS) 프로그램을 구현한다.
    - [x] 주문등록, 결제하기, 프로그램 종료 기능을 가진다.
    - [x] 다른 입력값이 들어오면 예외처리 한다.
- [x] 메뉴 기본 정보가 주어지며 메뉴 번호, 종류, 이름, 가격을 가진다.
- [x] 테이블 기본 정보가 주어지며 테이블 번호를 가진다.
- [x] 한 테이블에서 주문할 수 있는 한 메뉴의 최대 수량은 99개이다.
    - [x] 한 메뉴의 최대 수량을 넘어가면(100 이상) 예외처리 한다.
- [ ] 주문이 등록된 테이블은 결제가 이루어지기 전까지 테이블 목록에 별도로 표시된다.
- [ ] 주문 내역에 대한 계산을 할 때는 결제 유형에 따라 할인율이 달라진다.
    - [ ] 치킨 종류 메뉴의 수량 합이 10개가 넘는 경우 10,000원씩 할인된다.
    - [ ] e.g. 10개는 10,000원 할인, 20개는 20,000원 할인
- [ ] 현금 결제는 5%가 할인되며 할인된 금액에서 한 번 더 할인이 가능하다.
- [ ] 주문 혹은 결제가 불가능한 경우 그 이유를 보여 주고, 다시 주문 혹은 결제가 가능하도록 해야 한다.
- [ ] 최종 결제 금액을 보여준다.

## 프로그래밍 요구사항 (클래스)
- [ ] Menu: 기본 생성자 추가, 인스턴스 변수 추가 불가. (타입 변경은 가능). 인스턴스 접근 제어자는 private
- [ ] MenuRepository: 기존 코드 수정 불가. 추가는 가능
- [ ] Table: 기본 생성자 추가 불가. 인스턴스 접근 제어자는 private
- [ ] TableRepository: 기존 코드 수정 불가. 추가는 가능

## 프로그래밍 요구사항 (제약)
- [ ] 자바 코드 컨벤션 지키면서 프로그래밍한다.
- [ ] 인덴트 깊이는 2까지만 허용한다.
- [ ] 함수는 한 가지 일만 하도록 최대한 작게
- [ ] 함수는 15라인을 넘지 않는다.
- [ ] else 예약어를 쓰지 않는다. (switch/case도 마찬가지)