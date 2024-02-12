package tacos.Classes;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
//@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor(access=AccessLevel.PRIVATE, force=true)
public class Ingredient {//implements Persistable<String>{
	@Id
	private String id;
	private String name;
	private Type type;
	
//	public Ingredient(String idString, String nameString, Type ingridientType) {
//		this.id = idString;
//		this.name = nameString;
//		this.type = ingridientType;
//	}
	
	public enum Type {
		WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
	}

	public Type getType() {
		return type;
	}
}
