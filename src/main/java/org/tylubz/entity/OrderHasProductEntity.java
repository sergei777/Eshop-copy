package org.tylubz.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Sergei on 20.08.2016.
 */
@Entity
@Table(name = "order_has_product")
public class OrderHasProductEntity implements Serializable{

    @Id
    @Column(name = "order_id")
    private int orderId;

    @Id
    @Column(name = "product_id")
    private int productId;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

}
