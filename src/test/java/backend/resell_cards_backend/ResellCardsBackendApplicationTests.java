package backend.resell_cards_backend;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import backend.resell_cards_backend.controllers.MTGCardController;

@SpringBootTest
class ResellCardsBackendApplicationTests {

  @Autowired
  private MTGCardController controller;

  @Test
  void contextLoads() throws Exception {
    assertThat(controller).isNotNull();
  }

}
