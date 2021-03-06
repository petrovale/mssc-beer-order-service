package guru.springboot.mssc.beer.order.service.web.mappers;

import guru.springboot.mssc.beer.order.service.domain.BeerOrderLine;
import guru.sfg.brewery.model.BeerOrderLineDto;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
@DecoratedWith(BeerOrderLineMapperDecorator.class)
public interface BeerOrderLineMapper {
  BeerOrderLineDto beerOrderLineToDto(BeerOrderLine line);

  BeerOrderLine dtoToBeerOrderLine(BeerOrderLineDto dto);
}
