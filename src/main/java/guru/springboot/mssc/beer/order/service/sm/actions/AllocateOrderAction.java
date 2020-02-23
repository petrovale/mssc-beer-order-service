package guru.springboot.mssc.beer.order.service.sm.actions;

import guru.springboot.mssc.beer.order.service.config.JmsConfig;
import guru.springboot.mssc.beer.order.service.domain.BeerOrder;
import guru.springboot.mssc.beer.order.service.domain.BeerOrderEventEnum;
import guru.springboot.mssc.beer.order.service.domain.BeerOrderStatusEnum;
import guru.springboot.mssc.beer.order.service.repositories.BeerOrderRepository;
import guru.springboot.mssc.beer.order.service.services.BeerOrderManagerImpl;
import guru.springboot.mssc.beer.order.service.web.mappers.BeerOrderMapper;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.action.Action;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class AllocateOrderAction implements Action<BeerOrderStatusEnum, BeerOrderEventEnum> {

  private final JmsTemplate jmsTemplate;
  private final BeerOrderRepository beerOrderRepository;
  private final BeerOrderMapper beerOrderMapper;

  @Override
  public void execute(StateContext<BeerOrderStatusEnum, BeerOrderEventEnum> context) {
    String beerOrderId = (String) context.getMessage().getHeaders().get(BeerOrderManagerImpl.ORDER_ID_HEADER);
    BeerOrder beerOrder = beerOrderRepository.findOneById(UUID.fromString(beerOrderId));

    jmsTemplate.convertAndSend(JmsConfig.ALLOCATE_ORDER_QUEUE,
        beerOrderMapper.beerOrderToDto(beerOrder));

    log.debug("Sent Allocation Request for order id: " + beerOrderId);
  }
}
