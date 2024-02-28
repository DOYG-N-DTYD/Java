package tacos.Interfaces;

import org.springframework.data.repository.CrudRepository;

import tacos.Classes.User;

public interface UserRepository extends CrudRepository<User, Long> {

	User findByUsername(String username);
}
