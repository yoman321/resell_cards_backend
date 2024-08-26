package backend.resell_cards_backend.domains;

import java.util.*;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;

public class Edition {

  @Id
  @SequenceGenerator(name = "edition", sequenceName = "edition", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "edition")
  private Long id;

  private String edition;

  @OneToMany(mappedBy = "edition", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private List<MTGCard> cardsInEdition;

  public Edition() {

  }

  public Edition(Long id, String edition) {
    this.id = id;
    this.edition = edition;
  }

  public long getId() {
    return id;
  }

  public String getEdition() {
    return edition;
  }

  public List<MTGCard> getCardsInEdition() {
    return new ArrayList<>(cardsInEdition);
  }

  public void setId(Long id) {
    this.id = id;
  }
}
