package th.ac.ku.restaurant.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import th.ac.ku.restaurant.model.Restaurant;

import java.util.UUID;

@Repository
// <object key, type ของ key>
public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {

}
