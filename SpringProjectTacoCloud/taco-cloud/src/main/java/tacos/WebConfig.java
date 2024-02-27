package tacos;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
// Как заменить homeController
// контроллер представления – контроллер, который ничего не делает, кроме как передает запрос в представление.
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class WebConfig implements WebMvcConfigurer {
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("home");
	}
	
	@RequestMapping(value="/", method = RequestMethod.GET)
    public String getHomePage(){
        return "home";
    }
}
