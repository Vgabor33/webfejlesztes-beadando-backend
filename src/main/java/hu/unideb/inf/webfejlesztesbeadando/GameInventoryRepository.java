package hu.unideb.inf.webfejlesztesbeadando;


import hu.unideb.inf.webfejlesztesbeadando.model.GameInventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface GameInventoryRepository extends JpaRepository<GameInventory,Long> {

}
