package rs.ac.uns.pmf.mis.restauranthost.domain.model;

public class ManagerOrderItem {

    private String orderName;
    private Integer orderAmount;

    public ManagerOrderItem(String orderName, Integer orderAmount) {
        this.orderName = orderName;
        this.orderAmount = orderAmount;
    }

    public void setOrderAmount(Integer orderAmount) {
        this.orderAmount = orderAmount;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public Integer getOrderAmount() {
        return orderAmount;
    }
}
