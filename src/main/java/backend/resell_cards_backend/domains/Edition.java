package backend.resell_cards_backend.domains;

public class Edition {

  private Long id;
  private String edition;

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

  public void setId(Long id) {
    this.id = id;
  }
}
