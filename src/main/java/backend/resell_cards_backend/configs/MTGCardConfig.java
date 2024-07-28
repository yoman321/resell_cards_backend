package backend.resell_cards_backend.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.CommandLineRunner;

import java.util.List;

import backend.resell_cards_backend.domains.MTGCard;
import backend.resell_cards_backend.repositories.MTGCardRepository;
import backend.resell_cards_backend.enums.MTGCardType;

@Configuration
public class MTGCardConfig {

  @Bean
  CommandLineRunner secondCommandLineRunner(MTGCardRepository mtgCardRepository) {
    return args -> {
      MTGCard card1 = new MTGCard(1L, "A Card name",
          new MTGCardType[] { MTGCardType.ARTIFACT, MTGCardType.PLANESWALKER }, "Eldraine", 12L);
      MTGCard card2 = new MTGCard(2L, "Another card name", new MTGCardType[] { MTGCardType.BATTLE }, "Theros", 10L);
      mtgCardRepository.saveAll(List.of(card1, card2));
    };
  }
}
