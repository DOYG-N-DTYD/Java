package tacos.Classes;

import javax.swing.ListModel;

import lombok.Data;

@Data
public class Taco {
	
	private String name;
	private ListModel<Ingridient> ingridients;
}
