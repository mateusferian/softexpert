package br.com.mateusferian.softexpert.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponseDTO {

    private Long id;

    private Date RequestDate;

    private UserResponseDTO user;

    private List<FoodResponseDTO> food;
}