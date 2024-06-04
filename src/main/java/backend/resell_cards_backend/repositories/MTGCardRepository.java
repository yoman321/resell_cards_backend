package backend.resell_cards_backend.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

import backend.resell_cards_backend.domains.MTGCard;

@Repository
public interface MTGCardRepository extends JpaRepository<MTGCard, Long>{

    Optional<MTGCard> findMTGCardByMTGCardName(String mtgCardName);
}