package backend.resell_cards_backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.*;

import backend.resell_cards_backend.services.MTGCardService;
import backend.resell_cards_backend.domains.MTGCard;

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
        return mtgCardService.getMTGCards();
    }
    @PostMapping
    public void addNewMTGCard(@RequestBody MTGCard mtgCard){
        mtgCardService.addNewMTGCard(mtgCard);
    }
}
