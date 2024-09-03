package com.romazal.jpa.models.embedded;

import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Order_TBL")
public class Order {

    @EmbeddedId
    private OrderId id;

    @Embedded
    private Address address;

    private String orderInfo;

    private String description;
}
