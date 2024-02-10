package tacos.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import lombok.extern.slf4j.Slf4j;
import tacos.Classes.TacoOrder;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("tacoOrder")
public class OrderController {
	private static final org.slf4j.Logger log =
			 org.slf4j.LoggerFactory.getLogger(DesignTacoController.class);
	
	@GetMapping("/current")
	public String orderForm() {
		return "orderForm";
	}
	
	@PostMapping
	public String processOrder(TacoOrder order,
	 SessionStatus sessionStatus) {
	 log.info("Order submitted: {}", order);
	 log.info(order.allDataString());
	 sessionStatus.setComplete();
	 return "redirect:/";
	}
}
