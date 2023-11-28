package br.com.mateusferian.softexpert.facades;

import br.com.mateusferian.softexpert.dtos.requests.OrderRequestDTO;
import br.com.mateusferian.softexpert.dtos.requests.PurchaseRequestDTO;
import br.com.mateusferian.softexpert.dtos.response.OrderResponseDTO;
import br.com.mateusferian.softexpert.dtos.response.PurchaseResponseDTO;

import java.util.List;

public interface OrderFacade {

    List<OrderResponseDTO> findAll();
    OrderResponseDTO save(OrderRequestDTO request);
}
