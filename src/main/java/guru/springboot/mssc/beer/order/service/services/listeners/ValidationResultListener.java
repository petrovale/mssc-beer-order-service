package guru.springboot.mssc.beer.order.service.services.listeners;

import guru.sfg.brewery.model.events.ValidateOrderResult;
import guru.springboot.mssc.beer.order.service.config.JmsConfig;
import guru.springboot.mssc.beer.order.service.services.BeerOrderManager;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class ValidationResultListener {

  private final BeerOrderManager beerOrderManager;

  @JmsListener(destination = JmsConfig.VALIDATE_ORDER_RESPONSE_QUEUE)
  public void listen(ValidateOrderResult result){
    final UUID beerOrderId = result.getOrderId();

    log.debug("Validation Result for Order Id: " + beerOrderId);

    beerOrderManager.processValidationResult(beerOrderId, result.getIsValid());
  }
}
