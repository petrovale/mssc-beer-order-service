package guru.springboot.mssc.beer.order.service.repositories;

import guru.springboot.mssc.beer.order.service.domain.BeerOrderLine;
import java.util.UUID;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BeerOrderLineRepository extends PagingAndSortingRepository<BeerOrderLine, UUID> {
}
