package guru.springboot.mssc.beer.order.service.web.mappers;

import guru.springboot.mssc.beer.order.service.domain.BeerOrder;
import guru.springboot.mssc.beer.order.service.web.model.BeerOrderDto;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class, BeerOrderLineMapper.class})
public interface BeerOrderMapper {

  BeerOrderDto beerOrderToDto(BeerOrder beerOrder);

  BeerOrder dtoToBeerOrder(BeerOrderDto dto);
}
