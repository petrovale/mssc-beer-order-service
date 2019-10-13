package guru.springboot.mssc.beer.order.service.web.mappers;

import guru.springboot.mssc.beer.order.service.domain.BeerOrderLine;
import guru.springboot.mssc.beer.order.service.services.BeerService;
import guru.springboot.mssc.beer.order.service.web.model.BeerDto;
import guru.springboot.mssc.beer.order.service.web.model.BeerOrderLineDto;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public abstract class BeerOrderLineMapperDecorator implements BeerOrderLineMapper {

  private BeerService beerService;
  private BeerOrderLineMapper beerOrderLineMapper;

  @Autowired
  public void setBeerService(BeerService beerService) {
    this.beerService = beerService;
  }

  @Autowired
  @Qualifier("delegate")
  public void setBeerOrderLineMapper(BeerOrderLineMapper beerOrderLineMapper) {
    this.beerOrderLineMapper = beerOrderLineMapper;
  }

  @Override
  public BeerOrderLineDto beerOrderLineToDto(BeerOrderLine line) {
    BeerOrderLineDto orderLineDto = beerOrderLineMapper.beerOrderLineToDto(line);
    Optional<BeerDto> beerDtoOptional = beerService.getBeerByUpc(line.getUpc());

    beerDtoOptional.ifPresent(beerDto -> {
      orderLineDto.setBeerName(beerDto.getBeerName());
      orderLineDto.setBeerStyle(beerDto.getBeerStyle());
      orderLineDto.setPrice(beerDto.getPrice());
      orderLineDto.setBeerId(beerDto.getId());
    });

    return orderLineDto;
  }
}