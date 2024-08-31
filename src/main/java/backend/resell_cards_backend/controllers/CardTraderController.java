package backend.resell_cards_backend.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import backend.resell_cards_backend.services.CardTraderService;
import backend.resell_cards_backend.domains.CardTrader;

@RestController
@RequestMapping(path = "login")
@CrossOrigin(origins = "http://localhost:5173")
public class CardTraderController {

  private final CardTraderService cardTraderService;

  public CardTraderController(CardTraderService cardTraderService) {
    this.cardTraderService = cardTraderService;
  }

  @GetMapping
  public List<CardTrader> getCardTraders() {
    return cardTraderService.findAllCardTraders();
  }

  @PutMapping
  public void addNewCardTrader(@RequestBody CardTrader cardTrader) {
    cardTraderService.addNewCardTrader(cardTrader);
  }
}
