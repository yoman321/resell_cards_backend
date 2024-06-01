import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import java.util.Objects;


enum MTGCardType{
    ARTIFACT, ENCHANTMENT, CREATURE, LAND, PLANESWALKER, BATTLE, CONSPIRACY, DUNGEON, INSTANT, SORCERY, PLANE, SCHEME, TRIBAL, VANGUARD 
}

@Entity
public class MTGCard extends Card{

    @Id
    @SequenceGenerator(
        name = "mtg_card_sequence",
        sequenceName = "mtg_card_sequence",
        allocationSize = 1
    )

    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "mtg_card_sequence"
    )

    private Long id;
    private String mtgCardName;
    private MTGCardType mtgCardType;
    private String mtgCardEdition;
    private Long value;

    public MTGCard(Long id, String mtgCardName, MTGCardType mtgCardType, String mtgCardEdition, Long value){
        super(TCG.MTG);
        this.id = id;
        this.mtgCardName = mtgCardName;
        this.mtgCardType = mtgCardType;
        this.mtgCardEdition = mtgCardEdition;
        this.value = value;
    }

    public MTGCard(String mtgCardName, MTGCardType mtgCardType, String mtgCardEdition, Long value){
        super(TCG.MTG);
        this.mtgCardName = mtgCardName;
        this.mtgCardType = mtgCardType;
        this.mtgCardEdition = mtgCardEdition;
        this.value = value;
    }

    public Long getId(){
        return id;
    }
    public String getMTGCardName(){
        return mtgCardName;
    }
    public MTGCardType getMtgCardType(){
        return mtgCardType;
    }
    public String getMTGCardEdition(){
        return mtgCardEdition;
    }
    public Long getValue(){
        return value;
    }
    public void setId(Long id) {
        this.id = id;
    }

    //we only have the value setter because once the card is created, we don't want any other values to be changed
    public void setValue(Long value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", mtgCardName='" + getMTGCardName() + "'" +
            ", mtgCardType='" + getMtgCardType() + "'" +
            ", mtgCardEdition='" + getMTGCardEdition() + "'" +
            ", value='" + getValue() + "'" +
            "}";
    }

}