package guru.springboot.mssc.beer.order.service.domain;

import java.sql.Timestamp;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class BeerOrderLine extends BaseEntity {

  @Builder
  public BeerOrderLine(UUID id, Long version, Timestamp createdDate, Timestamp lastModifiedDate,
      BeerOrder beerOrder, UUID beerId, Integer orderQuantity,
      Integer quantityAllocated) {
    super(id, version, createdDate, lastModifiedDate);
    this.beerOrder = beerOrder;
    this.beerId = beerId;
    this.orderQuantity = orderQuantity;
    this.quantityAllocated = quantityAllocated;
  }

  @ManyToOne
  private BeerOrder beerOrder;

  private UUID beerId;
  private Integer orderQuantity = 0;
  private Integer quantityAllocated = 0;
}