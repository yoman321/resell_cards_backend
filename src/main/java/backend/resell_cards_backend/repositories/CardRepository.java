package backend.resell_cards_backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Inventory, Long>{

}