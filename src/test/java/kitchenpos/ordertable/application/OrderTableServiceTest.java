package kitchenpos.ordertable.application;

import kitchenpos.common.vo.Name;
import kitchenpos.order.application.InMemoryOrderRepository;
import kitchenpos.order.application.InMemoryOrderTableRepository;
import kitchenpos.order.domain.OrderRepository;
import kitchenpos.ordertable.domain.OrderTable;
import kitchenpos.ordertable.domain.OrderTableRepository;
import kitchenpos.ordertable.vo.NumberOfGuests;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("주문 테이블")
class OrderTableServiceTest {

    private OrderTableRepository orderTableRepository;
    private OrderRepository orderRepository;
    private OrderTableService orderTableService;

    @BeforeEach
    void setUp() {
        orderTableRepository = new InMemoryOrderTableRepository();
        orderRepository = new InMemoryOrderRepository();
        orderTableService = new OrderTableService(orderTableRepository, orderRepository);
    }

    @DisplayName("주문 테이블 목록을 조회할 수 있다.")
    @Test
    void findAll() {
        orderTableRepository.save(orderTable("주문테이블명", 1));
        assertThat(orderTableService.findAll()).hasSize(1);
    }

    @DisplayName("주문 테이블의 착석여부를 착석으로 변경할 수 있다.")
    @Test
    void fisdfndAll() {
        OrderTable orderTable = orderTableRepository.save(orderTable("주문테이블명", 1));
        orderTableService.sit(orderTable.getId());
        assertThat(orderTable.isOccupied()).isTrue();
    }

    @DisplayName("주문 테이블의 착석여부를 공석으로 변경할 수 있다.")
    @Test
    void fisdfnasdfdAll() {
        OrderTable orderTable = orderTableRepository.save(orderTable("주문테이블명", 1));
        assertThat(orderTable.isOccupied()).isFalse();
        orderTableService.sit(orderTable.getId());
        assertThat(orderTable.isOccupied()).isTrue();
    }

    private static OrderTable orderTable(String name, int numberOfGuests) {
        return new OrderTable(UUID.randomUUID(), new Name(name, false), new NumberOfGuests(numberOfGuests));
    }

}
