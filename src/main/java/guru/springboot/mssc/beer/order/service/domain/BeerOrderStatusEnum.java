package guru.springboot.mssc.beer.order.service.domain;

public enum BeerOrderStatusEnum {
  NEW, VALIDATED, VALIDATION_EXCEPTION, ALLOCATED, ALLOCATION_EXCEPTION, READY, PICKED_UP,
  DELIVERED, DELIVERY_EXCEPTION
}
