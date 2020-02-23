package guru.springboot.mssc.beer.order.service.services;

import guru.sfg.brewery.model.BeerOrderDto;
import guru.springboot.mssc.beer.order.service.domain.BeerOrder;
import java.util.UUID;

public interface BeerOrderManager {

  BeerOrder newBeerOrder(BeerOrder beerOrder);

  void processValidationResult(UUID beerOrderId, Boolean isValid);

  void beerOrderAllocationPassed(BeerOrderDto beerOrder);

  void beerOrderAllocationPendingInventory(BeerOrderDto beerOrder);

  void beerOrderAllocationFailed(BeerOrderDto beerOrder);
}
