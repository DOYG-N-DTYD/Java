package tacos.Interfaces;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import tacos.Classes.TacoOrder;
import tacos.Classes.User;

public interface OrderRepository extends CrudRepository<TacoOrder, Long> {

	List<TacoOrder> findByUserOrderByPlacedAtDesc(User user, Pageable pageable);
}