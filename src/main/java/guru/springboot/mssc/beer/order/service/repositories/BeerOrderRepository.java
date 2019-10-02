package guru.springboot.mssc.beer.order.service.repositories;

import guru.springboot.mssc.beer.order.service.domain.BeerOrder;
import guru.springboot.mssc.beer.order.service.domain.Customer;
import guru.springboot.mssc.beer.order.service.domain.OrderStatusEnum;
import java.util.List;
import java.util.UUID;
import javax.persistence.LockModeType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

public interface BeerOrderRepository  extends JpaRepository<BeerOrder, UUID> {

  Page<BeerOrder> findAllByCustomer(Customer customer, Pageable pageable);

  List<BeerOrder> findAllByOrderStatus(OrderStatusEnum orderStatusEnum);

  @Lock(LockModeType.PESSIMISTIC_WRITE)
  BeerOrder findOneById(UUID id);
}
