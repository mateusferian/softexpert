package br.com.mateusferian.softexpert.entities;

import br.com.mateusferian.softexpert.enums.DeliveryTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date RequestDate;

    @ManyToOne
    private UserEntity user;

    @ManyToOne
    private FoodEntity food;

    public OrderEntity(Date requestDate, UserEntity user, FoodEntity food) {
        RequestDate = requestDate;
        this.user = user;
        this.food = food;
    }
}

