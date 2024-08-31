package backend.resell_cards_backend.configs;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import backend.resell_cards_backend.domains.CardTrader;
import backend.resell_cards_backend.repositories.CardTraderRepository;

@Configuration
public class CardTraderConfigs {

  @Bean
  CommandLineRunner thirdCommandLineRunner(CardTraderRepository cardTraderRepository) {
    return args -> {
      CardTrader trader1 = new CardTrader(1L, "bob@gmail.com", "bobpassword");
      CardTrader trader2 = new CardTrader(2L, "alice@outlook.com", "alicepassword");
      cardTraderRepository.saveAll(List.of(trader1, trader2));
    };
  }
}
