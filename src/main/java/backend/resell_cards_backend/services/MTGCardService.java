package backend.resell_cards_backend.services;

import java.util.*;

import backend.resell_cards_backend.domains.MTGCard;
import backend.resell_cards_backend.repositories.MTGCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

@Service
public class MTGCardService {

  private final MTGCardRepository mtgCardRepository;

  @Autowired
  public MTGCardService(MTGCardRepository mtgCardRepository) {
    this.mtgCardRepository = mtgCardRepository;
  }

  public List<MTGCard> getMTGInventory() {
    return mtgCardRepository.findAll();
  }

  public void addNewMTGCard(MTGCard mtgCard) {

    Example<MTGCard> exampleMtgCard = Example.of(mtgCard);
    List<MTGCard> optionalCard = mtgCardRepository.findAll(exampleMtgCard);

    if (!optionalCard.isEmpty()) {
      throw new IllegalStateException("Card already exist in your inventory");
    }
    mtgCardRepository.save(mtgCard);
  }

  public void removeMTGCard(MTGCard mtgCard) {

    Example<MTGCard> exampleMtgCard = Example.of(mtgCard);
    List<MTGCard> optionalCard = mtgCardRepository.findAll(exampleMtgCard);

    if (optionalCard.isEmpty()) {
      throw new IllegalStateException("Card is not in your inventory");
    }
    mtgCardRepository.delete(mtgCard);
  }
}
