package br.com.mateusferian.softexpert.entities;

import br.com.mateusferian.softexpert.enums.DeliveryTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date RequestDate;

    private BigDecimal TotalOrder;

    @ManyToOne
    private UserEntity user;

    @ManyToMany
    @JoinTable(
            name = "order_food_mapping",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "food_id")
    )
    private List<FoodEntity> food;
}

