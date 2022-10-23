package kitchenpos.menu.menu.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public class MenuRequest {

    private BigDecimal price;
    private UUID menuGroupId;
    private List<MenuProductRequest> menuProducts;
    private String name;
    private boolean isDisplayed;

    public MenuRequest(UUID menuGroupId, List<MenuProductRequest> menuProductRequests) {
        this.menuGroupId = menuGroupId;
        this.menuProducts = menuProductRequests;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public UUID getMenuGroupId() {
        return this.menuGroupId;
    }

    public List<MenuProductRequest> getMenuProducts() {
        return this.menuProducts;
    }

    public String getName() {
        return this.name;
    }

    public boolean isDisplayed() {
        return this.isDisplayed;
    }
}
