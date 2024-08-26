package backend.resell_cards_backend.controllers;

import backend.resell_cards_backend.domains.MTGCard;
import backend.resell_cards_backend.services.MTGCardService;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping(path = "api/mtg_inventory")
@CrossOrigin(origins = "http://localhost:5173")
public class MTGCardController {

  private final MTGCardService mtgCardService;

  @Autowired
  public MTGCardController(MTGCardService mtgCardService) {
    this.mtgCardService = mtgCardService;
  }

  @GetMapping
  public String getMTGCards() throws IOException {
    return new ObjectMapper().writeValueAsString(mtgCardService.getMTGInventory());
  }

  @PutMapping
  public void addNewMTGCard(@RequestBody MTGCard mtgCard) {
    mtgCardService.addNewMTGCard(mtgCard);
  }

  @DeleteMapping
  public void removeMTGCard(@RequestBody MTGCard mtgCard) {
    mtgCardService.removeMTGCard(mtgCard);
  }

}
