package tacos.Interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import tacos.Classes.User;

@CrossOrigin(origins="*")
public interface UserRepository extends CrudRepository<User, Long> {

	User findByUsername(String username);

	//User save(User user);
	//String id,String username, String password, String fullname, String street, String city, String state, String zip, String phonenumber
}
