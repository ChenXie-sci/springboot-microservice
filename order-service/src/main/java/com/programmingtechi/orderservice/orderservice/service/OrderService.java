package com.programmingtechi.orderservice.orderservice.service;

import com.programmingtechi.orderservice.orderservice.dto.OrderLineItemsDto;
import com.programmingtechi.orderservice.orderservice.dto.OrderRequest;
import com.programmingtechi.orderservice.orderservice.model.Order;
import com.programmingtechi.orderservice.orderservice.model.OrderLineItems;
import com.programmingtechi.orderservice.orderservice.repository.OrderRepository;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;











@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    
    
    public void placeOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());

    
        List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItemsDtoList()
                    .stream()
                    .map(this::mapToDto)
                    .toList();
        
        order.setOrderLineItemsList(orderLineItems);

        orderRepository.save(order);
    }

    public OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto) {
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setPrice(orderLineItems.getPrice());
        orderLineItems.setQuantity(orderLineItems.getQuantity());
        orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());
        return orderLineItems;
    }
}
