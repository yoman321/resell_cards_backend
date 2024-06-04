package backend.resell_cards_backend.controllers;

import backend.resell_cards_backend.domains.MTGCard;
import backend.resell_cards_backend.services.MTGCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.*;

@RestController
@RequestMapping(path = "api/mtg_inventory")
public class MTGCardController{

    private final MTGCardService mtgCardService;

    @Autowired
    public MTGCardController(MTGCardService mtgCardService){
        this.mtgCardService = mtgCardService;
    }

    @GetMapping
    public List<MTGCard> getMTGCards(){
        return mtgCardService.getMTGInventory();
    }

    @PostMapping
    public void addNewMTGCard(@RequestBody MTGCard mtgCard){
        mtgCardService.addNewMTGCard(mtgCard);
    }

    @DeleteMapping
    public void removeMTGCard(@RequestBody MTGCard mtgCard){
        mtgCardService.removeMTGCard(mtgCard);
    }

}
