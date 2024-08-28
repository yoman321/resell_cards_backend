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

  @ManyToMany(mappedBy = "cardTraders")
  private List<MTGCard> mtgCardList = new ArrayList<>();

  public CardTrader() {

  }

  public CardTrader(Long id, String email, String password) {
    this.id = id;
    this.email = email;
    this.password = password;
  }

  public String getEmail() {
    return email;
  }

  public String getPassword() {
    return password;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
