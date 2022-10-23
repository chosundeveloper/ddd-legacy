# 키친포스

## 퀵 스타트

```sh
cd docker
docker compose -p kitchenpos up -d
```

## 요구 사항

- 키친포스 프로그램을 구현한다.

### 메뉴 그룹

    - [x] 메뉴 그룹을 생성할 수 있다.
        - [x] 메뉴 그룹 생성시 메뉴명을 입력받는다.
        - [x] 메뉴명은 공백일 수 없다.
        - [x] 메뉴명은 필수값으로 입력받는다.
    - [x] 메뉴 그룹 목록을 조회할 수 있다.

### 주문

    - [ ] 주문을 생성할 수 있다.
        - [ ] 주문 생성 시 주문 타입 / 주문 테이블 아이디 / 주문 항목 목록을 입력 받는다.
        - [x] 주문 항목은 비어 있을 수 없다.
        - [x] 안보이는 메뉴가 주문될 수 없다. 
        - [ ] 메뉴의 수량과 주문 항목의 수량은 같다.
        - [ ] 메뉴의 가격과 메뉴 항목의 가격은 같다. 
        - [ ] 주문 타입은 배송 / 포장 / 매장 중 한 가지를 갖는다.
        - [x] 주문 타입은 필수값으로 입력받는다.
        - [x] 매장 주문이 아닐 경우 수량은 0개보다 적을 수 없다.
        - [x] 매장 주문에서 착석된 테이블을 선택할 수 없다.
        - [x] 배달 주문이면 배송지가 없을 수 없다.
    - [x] 주문을 수락 할 수 있다.
        - [x] WAITING 상태가 아니면 접수를 받을 수 없다.
    - [x] 주문에 대해 제공할 수 있다.
        - [x] 접수 상태가 아니면 제공할 수 없다.
    - [x] 배송을 시작할 수 있다.
        - [x] 주문 타입이 DELIVERY일 경우에만 배송 시작을 할 수 있다.
        - [x] 주문 상태가 SERVED일 경우에만 배송 시작을 할 수 있다.
    - [x] 배송을 완료할 수 있다.
        - [x] 주문 상태가 DELIVERING일 경우에만 배송을 완료할 수 있다.
    - [x] 주문을 완료할 수 있다.
        - [x] 주문 타입이 DELIVERY가 아니면 주문을 완료할 수 없다.
        - [x] 주문 상태가 DELIVERED가 아니면 주문을 완료할 수 없다.
        - [x] 주문 타입이 TAKEOUT 또는 EAT_IN이고 주문상태가 SERVED일 경우 주문을 완료할 수 있다.
    - [x] 주문 내역을 조회할 수 있다.

### 메뉴

    - [ ] 메뉴를 생성할 수 있다.
        - [ ] 메뉴 생성 시 메뉴명 / 메뉴 가격 / 메뉴 그룹 아이디 / 메뉴 전시 여부 / 메뉴 상품 목록을 입력 받는다.
        - [x] 메뉴 그룹에 속해 있다.
        - [x] 메뉴 생성 시 메뉴 가격을 필수로 입력받는다.
        - [x] 메뉴 가격이 0원보다 작을 수 없다.
        - [x] 메뉴 상품 목록은 비어 있을 수 없다.
        - [x] 상품 가격의 총합은 0원보다 크다.
        - [x] 메뉴 상품의 수량은 0개보다 작을 수 없다.
        - [ ] 상품의 수량과 메뉴 상품의 수량은 다를 수 없다.
    - [ ] 메뉴 가격을 변경할 수 있다.
        - [x] 메뉴 가격은 필수로 입력받는다.
        - [x] 메뉴 가격은 0원보다 크다.
        - [x] 메뉴의 가격이 메뉴 상품의 합보다 크면 메뉴를 숨긴다.
    - [x] 메뉴를 보여줄 수 있다.
        - [x] 메뉴의 가격이 메뉴 상품의 합보다 클 수 없다.
    - [x] 메뉴를 숨길 수 있다.
    - [x] 메뉴 목록을 조회할 수 있다.

### 주문 테이블

    - [x] 주문 테이블을 생성할 수 있다.
        - [x] 주문 테이블 생성 시 주문 테이블명을 입력받는다.
        - [x] 주문 테이블 생성 시 주문 테이블명은 필수이다.
        - [x] 주문 테이블 생성 시 주문 테이블명은 비어있을 수 없다.
    - [x] 주문 테이블의 착석여부를 착석으로 변경할 수 있다.
    - [x] 주문 테이블의 착석여부를 공석으로 변경할 수 있다.
        - [ ] 주문 테이블 공석으로 변경 시 주문 상태가 완료일때만 변경 가능하다.
    - [x] 주문 테이블의 착석 인원을 변경 할 수 있다.
        - [x] 주문 테이블의 착석 인원 변경 시 0명보다 작을 수 없다.
        - [x] 주문 테이블이 공석일 경우 착석 인원을 변경 할 수 없다.
    - [x] 주문 테이블 목록을 조회할 수 있다.

### 상품

    - [x] 상품을 생성할 수 있다.
        - [x] 상품 생성 시 상품명 / 상품 가격을 입력 받는다.
        - [x] 상품 가격은 0원보다 작을 수 없다.
        - [x] 상품 가격은 필수이다.
        - [x] 상품명은 필수이다.
        - [x] 상품명은 비속어를 사용할 수 없다.
    - [x] 상품 가격을 변경할 수 있다.
        - [x] 상품 가격을 0원보다 작은 가격으로 변경 할 수 없다.
        - [x] 상품 가격을 필수로 입력받는다.
    - [x] 상품 목록을 조회할 수 있다.

## 용어 사전

| 한글명 | 영문명 | 설명 |
| --- | --- | --- |
|  |  |  |

## 모델링
