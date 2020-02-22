package guru.springboot.mssc.beer.order.service.services;

import guru.sfg.brewery.model.BeerDto;
import java.util.Optional;
import java.util.UUID;

public interface BeerService {
  Optional<BeerDto> getBeerById(UUID uuid);

  Optional<BeerDto> getBeerByUpc(String upc);
}
