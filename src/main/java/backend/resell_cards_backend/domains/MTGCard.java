package backend.resell_cards_backend.domains;

import java.util.*;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;

import backend.resell_cards_backend.enums.MTGCardType;
import backend.resell_cards_backend.enums.TCG;
import backend.resell_cards_backend.serializer.CardSerializer;

@JsonSerialize(using = CardSerializer.class)
@Entity
@Table(name = "mtg_card")
public class MTGCard extends Card {

  @Id
  @SequenceGenerator(name = "mtg_card_sequence", sequenceName = "mtg_card_sequence", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mtg_card_sequence")
  private Long id;

  private String mtgCardName;
  private MTGCardType mtgCardType[];
  private String mtgCardEdition;
  private Long mtgCardValue;

  @ManyToMany(mappedBy = "mtgCardSet")
  private Set<CardTrader> cardTraders;

  public MTGCard() {
    super(TCG.MTG);
  }

  public MTGCard(Long id, String mtgCardName, MTGCardType mtgCardType[], String mtgCardEdition, Long mtgCardValue) {
    super(TCG.MTG);
    this.id = id;
    this.mtgCardName = mtgCardName;
    this.mtgCardType = mtgCardType;
    this.mtgCardEdition = mtgCardEdition;
    this.mtgCardValue = mtgCardValue;
  }

  public MTGCard(String mtgCardName, MTGCardType mtgCardType[], String mtgCardEdition, Long mtgCardValue) {
    super(TCG.MTG);
    this.mtgCardName = mtgCardName;
    this.mtgCardType = mtgCardType;
    this.mtgCardEdition = mtgCardEdition;
    this.mtgCardValue = mtgCardValue;
  }

  public Long getId() {
    return id;
  }

  public String getMtgCardName() {
    return mtgCardName;
  }

  public MTGCardType[] getMtgCardType() {
    return mtgCardType;
  }

  public String getMtgCardEdition() {
    return mtgCardEdition;
  }

  public Long getMtgCardValue() {
    return mtgCardValue;
  }

  public Set<CardTrader> getCardTraders() {
    return new HashSet<>(cardTraders);
  }

  public void setId(Long id) {
    this.id = id;
  }

  // we only have the value setter because once the card is created, we don't want
  // any other values to be changed
  public void setMTGCardValue(Long mtgCardValue) {
    this.mtgCardValue = mtgCardValue;
  }

  public void removeCardTrader(CardTrader cardTrader) {
    cardTraders.remove(cardTrader);
  }

  @Override
  public MTGCard removeIdFromCard() {
    return new MTGCard(getMtgCardName(), getMtgCardType(), getMtgCardEdition(), getMtgCardValue());
  }

  @PreRemove
  private void removeCardTraderFromCardTraders() {
    for (CardTrader cardTrader : cardTraders) {
      cardTrader.removeMTGCard(this);
    }
  }

  @Override
  public String toString() {
    return "{" +
        " id='" + getId() + "'" +
        ", mtgCardName='" + getMtgCardName() + "'" +
        ", mtgCardType='" + getMtgCardType() + "'" +
        ", mtgCardEdition='" + getMtgCardEdition() + "'" +
        ", value='" + getMtgCardValue() + "'" +
        "}";
  }

}
