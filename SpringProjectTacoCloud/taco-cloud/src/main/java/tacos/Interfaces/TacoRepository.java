package tacos.Interfaces;

import org.springframework.data.repository.CrudRepository;

import tacos.Classes.Taco;

public interface TacoRepository extends CrudRepository<Taco, Long> {

}
