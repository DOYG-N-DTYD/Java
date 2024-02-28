package tacos.Classes;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

//@Data
//@RequiredArgsConstructor
//@NoArgsConstructor(access=AccessLevel.PRIVATE, force=true)
//@Entity

//@Entity
//@Builder 
//@NoArgsConstructor 
//@AllArgsConstructor
//@Setter(value = AccessLevel.PACKAGE)
//@Getter

@Data
@RequiredArgsConstructor
@NoArgsConstructor(access=AccessLevel.PRIVATE, force=true)
@Entity
public class Ingredient {//implements Persistable<String>{
	@Id
	private final String id;
	private final String name;
	private final Type type;
	
	public enum Type {
		WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
	}
}
