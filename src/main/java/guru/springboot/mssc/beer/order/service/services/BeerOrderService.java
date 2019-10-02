package guru.springboot.mssc.beer.order.service.services;

import guru.springboot.mssc.beer.order.service.web.model.BeerOrderDto;
import guru.springboot.mssc.beer.order.service.web.model.BeerOrderPagedList;
import java.util.UUID;
import org.springframework.data.domain.Pageable;

public interface BeerOrderService {
  BeerOrderPagedList listOrders(UUID customerId, Pageable pageable);

  BeerOrderDto placeOrder(UUID customerId, BeerOrderDto beerOrderDto);

  BeerOrderDto getOrderById(UUID customerId, UUID orderId);

  void pickupOrder(UUID customerId, UUID orderId);
}
