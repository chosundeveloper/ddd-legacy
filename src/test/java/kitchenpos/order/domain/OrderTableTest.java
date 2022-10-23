package kitchenpos.order.domain;

import kitchenpos.domain.Name;
import kitchenpos.ordertable.OrderTable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

@DisplayName("주문 테이블")
class OrderTableTest {

    @DisplayName("주문 테이블 생성 시 주문 테이블명을 입력받는다.")
    @Test
    void createOrderTable() {
        assertThatNoException().isThrownBy(() -> orderTable("주문테이블명"));
    }

    @DisplayName("주문 테이블 생성 시 주문 테이블명은 필수이다.")
    @ParameterizedTest
    @NullAndEmptySource
    void createOrderTable(String name) {
        assertThatThrownBy(() -> orderTable(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("null 이나 공백일 수 없습니다.");
    }

    @DisplayName("주문 테이블의 착석여부를 착석으로 변경할 수 있다.")
    @ParameterizedTest
    @ValueSource(strings = {"테이블"})
    void change(String name) {
        OrderTable orderTable = orderTable(name);
        assertThat(orderTable.isOccupied()).isFalse();
        orderTable.occupied();
        assertThat(orderTable.isOccupied()).isTrue();
    }

    @DisplayName("주문 테이블의 착석여부를 공석으로 변경할 수 있다.")
    @ParameterizedTest
    @ValueSource(strings = {"테이블"})
    void vacant(String name) {
        OrderTable orderTable = orderTable(name);
        assertThat(orderTable.isOccupied()).isFalse();
        orderTable.occupied();
        assertThat(orderTable.isOccupied()).isTrue();
        orderTable.vacant();
        assertThat(orderTable.isOccupied()).isFalse();
    }

    private static OrderTable orderTable(String name) {
        return new OrderTable(new Name(name, false));
    }
}
