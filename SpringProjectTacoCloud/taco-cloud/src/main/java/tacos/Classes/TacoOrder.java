package tacos.Classes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.validator.constraints.CreditCardNumber;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Table
public class TacoOrder {
	
	@Column("customer_name")
	@NotBlank(message = "Delivery name is required")
	private String deliveryName;
	@NotBlank(message = "Street is required")
	private String deliveryStreet;
	@NotBlank(message = "City is required")
	private String deliveryCity;
	@NotBlank(message = "State is required")
	private String deliveryState;
	@NotBlank(message = "Zip is required")
	private String deliveryZip;
	@CreditCardNumber(message = "Not a valid credit card number")
	private String ccNumber;
	@Pattern(regexp = "^(0[1-9]|1[0-2])([\\/])([2-9][0-9])$", message = "Must be formatted MM/YY")
	private String ccExpiration;
	@Digits(integer = 3, fraction = 0, message = "Invalid CVV")
	private String ccCVV;

	private List<Taco> tacos = new ArrayList<>();

	private Date placedDate;
	@Id
	private Long id;
	
	public void addTaco(Taco taco) {
		this.tacos.add(taco);
	}

	public String getDeliveryName() {
		return deliveryName;
	}

	public void setDeliveryName(String deliveryName) {
		this.deliveryName = deliveryName;
	}

	public String getDeliveryStreet() {
		return deliveryStreet;
	}

	public void setDeliveryStreet(String deliveryStreet) {
		this.deliveryStreet = deliveryStreet;
	}

	public String getDeliveryCity() {
		return deliveryCity;
	}

	public void setDeliveryCity(String deliveryCity) {
		this.deliveryCity = deliveryCity;
	}

	public String getDeliveryState() {
		return deliveryState;
	}

	public void setDeliveryState(String deliveryState) {
		this.deliveryState = deliveryState;
	}

	public String getDeliveryZip() {
		return deliveryZip;
	}

	public void setDeliveryZip(String deliveryZip) {
		this.deliveryZip = deliveryZip;
	}

	public String getCcNumber() {
		return ccNumber;
	}

	public void setCcNumber(String ccNumber) {
		this.ccNumber = ccNumber;
	}

	public String getCcExpiration() {
		return ccExpiration;
	}

	public void setCcExpiration(String ccExpiration) {
		this.ccExpiration = ccExpiration;
	}

	public String getCcCVV() {
		return ccCVV;
	}

	public void setCcCVV(String ccCVV) {
		this.ccCVV = ccCVV;
	}

	public List<Taco> getTacos() {
		return tacos;
	}

	public void setTacos(List<Taco> tacos) {
		this.tacos = tacos;
	}

	public String allDataString() {
		return getDeliveryName() + " " + getDeliveryStreet() + " " + getDeliveryCity() + " " + getDeliveryZip() + " "
				+ getDeliveryState() + " " + getCcNumber() + " " + getCcCVV() + " " + getCcExpiration();
	}

	public void setPlacedAt(Date date) {
		// TODO Auto-generated method stub
		this.placedDate = date;
	}

	public Object getPlacedAt() {
		// TODO Auto-generated method stub
		return this.placedDate;
	}

	public void setId(long orderId) {
		// TODO Auto-generated method stub
		this.id = orderId;
	}
	
	public Long getId() {
		// TODO Auto-generated method stub
		return this.id;
	}
}
