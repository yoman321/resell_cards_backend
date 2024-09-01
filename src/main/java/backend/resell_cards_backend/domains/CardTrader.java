package backend.resell_cards_backend.domains;

import java.util.*;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "card_traders")
public class CardTrader {

  @Id
  @SequenceGenerator(name = "card_trader", sequenceName = "card_trader", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "card_trader")
  private Long id;

  @NotEmpty(message = "email cannot be empty")
  @Column(unique = true, nullable = false)
  private String email;

  @NotEmpty(message = "password cannot be emtpy")
  @Column(unique = true, nullable = false)
  private String password;

  @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
  @JoinTable(name = "trader_cards", joinColumns = @JoinColumn(name = "cardtrader_id"), inverseJoinColumns = @JoinColumn(name = "mtgcard_id"))
  private Set<MTGCard> mtgCardSet = new HashSet<>();

  public CardTrader() {

  }

  public CardTrader(Long id, String email, String password) {
    this.id = id;
    this.email = email;
    this.password = password;
  }

  public CardTrader(String email, String password) {
    this.email = email;
    this.password = password;
  }

  public Long getId() {
    return id;
  }

  public String getEmail() {
    return email;
  }

  public String getPassword() {
    return password;
  }

  public Set<MTGCard> getMTGCardSet() {
    return new HashSet<>(mtgCardSet);
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void removeMTGCard(MTGCard card) {
    mtgCardSet.remove(card);
  }

  @PreRemove
  private void removeMTGCardFromMTGCardSet() {
    for (MTGCard card : mtgCardSet) {
      card.removeCardTrader(this);
    }
  }

}
