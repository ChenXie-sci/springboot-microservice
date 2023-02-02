package com.programmingtechi.orderservice.orderservice.dto;

import java.util.List;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {
    private List<OrderLineItemsDto> orderLineItemDtoList;
    
}
