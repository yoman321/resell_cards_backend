package backend.resell_cards_backend.services;

import java.util.*;

import org.springframework.stereotype.Service;
import org.springframework.data.domain.Example;

import backend.resell_cards_backend.domains.CardTrader;
import backend.resell_cards_backend.repositories.CardTraderRepository;

@Service
public class CardTraderService {

  private final CardTraderRepository cardTraderRepository;

  public CardTraderService(CardTraderRepository cardTraderRepository) {
    this.cardTraderRepository = cardTraderRepository;
  }

  public List<CardTrader> findAllCardTraders() {
    return cardTraderRepository.findAll();
  }

  public CardTrader findCardTraderByEmail(String email) {

    Optional<CardTrader> optionalCardTrader = cardTraderRepository.findCardTraderByEmail(email);

    if (optionalCardTrader.isEmpty()) {
      throw new IllegalStateException("Email does not correspond to any Card Trader");
    }

    return optionalCardTrader.get();
  }

  public void addNewCardTrader(CardTrader cardTrader) {

    List<CardTrader> repositoryCardTrader = cardTraderRepository.findAll(Example.of(cardTrader));

    if (!repositoryCardTrader.isEmpty()) {
      throw new IllegalStateException("Card Trader already exist");
    }

    cardTraderRepository.save(cardTrader);
  }

  public void removeCardTrader(CardTrader cardTrader) {

    List<CardTrader> card_traders_to_be_deleted = cardTraderRepository.findAll(Example.of(cardTrader));

    if (card_traders_to_be_deleted.isEmpty()) {
      throw new IllegalStateException("Card Trader does not exist");
    }

    cardTraderRepository.deleteById(cardTrader.getId());
  }

}
