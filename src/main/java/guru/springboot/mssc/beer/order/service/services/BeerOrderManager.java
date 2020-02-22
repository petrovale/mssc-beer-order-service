package guru.springboot.mssc.beer.order.service.services;

import guru.springboot.mssc.beer.order.service.domain.BeerOrder;

public interface BeerOrderManager {

  BeerOrder newBeerOrder(BeerOrder beerOrder);
}
