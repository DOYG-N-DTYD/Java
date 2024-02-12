package tacos.Interfaces;

//import org.springframework.data.repository.CrudRepository;
import tacos.Classes.TacoOrder;

public interface OrderRepository { //extends CrudRepository<TacoOrder, Long>
	TacoOrder save(TacoOrder order);
}