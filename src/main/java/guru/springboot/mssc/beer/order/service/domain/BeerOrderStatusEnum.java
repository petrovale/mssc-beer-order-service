package guru.springboot.mssc.beer.order.service.domain;

public enum BeerOrderStatusEnum {
  NEW, VALIDATED, VALIDATION_EXCEPTION, ALLOCATED, ALLOCATED_EXCEPTION, READY, PICKED_UP,
  DELIVERED, DELIVERY_EXCEPTION
}
