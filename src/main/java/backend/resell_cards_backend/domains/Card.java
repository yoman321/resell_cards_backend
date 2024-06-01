package backend.resell_cards_backend.domains;

import jakarta.persistence.MappedSuperclass;


enum TCG{
    POKEMON, MTG, YGO
}
@MappedSuperclass
public abstract class Card {
   
    private TCG game;

    public Card(){

    }
    public Card(TCG game){
        this.game = game;
    }
    public TCG getGame(){
        return game;
    }
}
