package kitchenpos.order.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("주문")
class OrderTest {

    @DisplayName("주문 타입은 null 일 수 없다.")
    @Test
    void requireOrderType() {
        List<OrderLineItem> orderLineItems = new ArrayList<>();
        OrderLineItem orderLineItem = new OrderLineItem();
        orderLineItems.add(orderLineItem);
        assertThatThrownBy(() -> new Order(null, orderLineItems))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("주문 타입을 입력해주세요.");
    }

    @DisplayName("주문 항목은 비어 있을 수 없다.")
    @Test
    void orderLineItemsNotNull() {
        assertThatThrownBy(() -> new Order(OrderType.TAKEOUT, null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("주문 항목은 비어 있을 수 없습니다.");
    }

    @DisplayName("WAITING 상태가 아니면 접수를 받을 수 없다.")
    @Test
    void accept() {
        List<OrderLineItem> orderLineItems = new ArrayList<>();
        OrderLineItem orderLineItem = new OrderLineItem();
        orderLineItems.add(orderLineItem);
        Order order = new Order(OrderType.TAKEOUT, orderLineItems);
        assertThatThrownBy(() -> order.accept())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("WAITING 상태만 접수가능합니다.");
    }
}
