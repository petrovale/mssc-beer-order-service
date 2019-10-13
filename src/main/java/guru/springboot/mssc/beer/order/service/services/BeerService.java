package guru.springboot.mssc.beer.order.service.services;

import guru.springboot.mssc.beer.order.service.web.model.BeerDto;
import java.util.Optional;
import java.util.UUID;

public interface BeerService {
  Optional<BeerDto> getBeerById(UUID uuid);

  Optional<BeerDto> getBeerByUpc(String upc);
}
