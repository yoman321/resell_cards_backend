package backend.resell_cards_backend.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import backend.resell_cards_backend.domains.CardTrader;

@Repository
public interface CardTraderRepository extends JpaRepository<CardTrader, Long> {

  Optional<CardTrader> findCardTraderById(Long id);

  Optional<CardTrader> findCardTraderByEmail(String email);
}
