package tacos.Interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import tacos.Classes.TacoOrder;
@Service
public interface OrderRepository extends CrudRepository<TacoOrder, Long>{
	TacoOrder save(TacoOrder order);
}