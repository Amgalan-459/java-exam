package ru.itstep;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class PageController {
	
	@Autowired
	MoneyService service;
	@Autowired
	UserDtoService userService;

	
	@GetMapping("/")
	public String start(
			@CookieValue(value="userEmail", defaultValue="none@none.com") String email,
			Model model) { //здесь добавить cookie null и проверку, если человек не вошел в аккаунт. либо же добавлять товары в cookie, а потом выводить их оттуда и добавлять транзакцией в бд
		model.addAttribute("user", userService.findOneByEmail(email));
		return "index";
	}
	@GetMapping("/newpage")
	public String p1(
			@CookieValue(value="userEmail", defaultValue="mail@mail.ru") String email,
			Model model) {
		
	    model.addAttribute("wallet", new Wallet("Лист тимьяна", 156., userService.findOneByEmail(email).getId(), true));
		return "page";  // src/main/resources/templates
	}
	
	@PostMapping("/kupi")
	public String newBuy(
		@ModelAttribute Wallet newBuy,
		@CookieValue(value="userEmail", defaultValue="mail@mail.ru") String email,
		Model model) {
		newBuy.setUserId(userService.findOneByEmail(email).getId());
		newBuy.setIsActual(true);
	    service.save(newBuy);
	    model.addAttribute("wallet", newBuy);
	    return "redirect:cart";
	  }
	
	@GetMapping("/cart")
	public String cart(
			@CookieValue(value="userEmail", defaultValue="none@none.com") String email,
			Model model) {
		System.out.println("User: " + email);
		if (email.equals("none@none.com")) return "redirect:login";
		UserDto user = userService.findOneByEmail(email);
		
		model.addAttribute("wallets", service.findByUserIdAndIsActual(user.getId(), true));
		model.addAttribute("wallet", new Wallet());
		return "cart";
	}
	
	@GetMapping("/registration")
	public String showRegistrationForm(
            WebRequest request,
            Model model) {
	    UserDto userDto = new UserDto();
	    model.addAttribute("user", userDto);
	    return "registration";
	}
	
	@PostMapping("/registration")
	public String postRegistrationForm(
			@ModelAttribute UserDto user,
			Model model) {
		userService.save(user);
		model.addAttribute("user", user);
		return "redirect:login";
	}
	
	@GetMapping("/login")
	public String getLogin(
			WebRequest request,
			Model model) {
		UserDto user = new UserDto();
		model.addAttribute("user", user);
		return "login";
	}
	
	@PostMapping("/login")
	public String postLogin(
			@ModelAttribute UserDto user,
			HttpServletResponse response) {
		UserDto findedUser = userService.findOneByEmail(user.getEmail());
		if (findedUser == null) return "redirect:login";
		if (!findedUser.getPassword().equals(findedUser.getPassword())) return "redirect:login";
		Cookie cokkie = new Cookie("userEmail", user.getEmail());
		response.addCookie(cokkie);
		return "redirect:cart";
	}
	
	@GetMapping("/admin")
	public String getAdmin(Model model) {
		List<UserDto> users = userService.findAll();
		model.addAttribute("users", users);
		return "adminPage";
	}
	
	@PostMapping("/delete")
	public String deleteItemFromCart(
			@ModelAttribute Long id,
			Model model) {
		//тут удаление из корзины
		System.out.println(id);
		
		return "redirect:cart";
	}
	
	@GetMapping("/orders")
	public String showOrders(
			Model model) {
		
		model.addAttribute("orders", service.findByIsActual(false));
		return "orders";
	}
	
	@GetMapping("/*")
	 public String red() {
	  return "redirect:login";
	 }


	/*@PostMapping("/greeting")
  public String greetingSubmit(
  @ModelAttribute Greeting greeting, Model model) {
    model.addAttribute("greeting", greeting);
    return "result";
  }*/
}
