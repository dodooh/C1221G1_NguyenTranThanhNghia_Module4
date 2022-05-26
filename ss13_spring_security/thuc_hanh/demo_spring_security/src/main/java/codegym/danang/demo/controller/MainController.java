package codegym.danang.demo.controller;

import codegym.danang.demo.dto.UserDto;
import codegym.danang.demo.entity.AppUser;
import codegym.danang.demo.exception.UserAlreadyExistException;
import codegym.danang.demo.service.IUserService;
import codegym.danang.demo.util.EncrytedPasswordUtils;
import java.security.Principal;


import codegym.danang.demo.util.WebUtils;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
    
    
    @Autowired
    private IUserService userService;

    @RequestMapping(value = { "/", "/welcome" }, method = RequestMethod.GET)
    public String welcomePage(Model model) {
        model.addAttribute("title", "Welcome");
        model.addAttribute("message", "This is welcome page!");
        return "welcomePage";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminPage(Model model, Principal principal) {

        User loginedUser = (User) ((Authentication) principal).getPrincipal();

        String userInfo = WebUtils.toString(loginedUser);
        model.addAttribute("userInfo", userInfo);

        return "adminPage";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(Model model) {

        return "loginPage";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String singupPage(Model model) {

        model.addAttribute("userDto", new UserDto());
        return "signupPage";
    }

    @PostMapping("/signup")
    public ModelAndView registerUserAccount(
        @ModelAttribute("userDto") @Validated UserDto userDto,
        BindingResult bindingResult,
        HttpServletRequest request
        ) {
        if (bindingResult.hasFieldErrors()) {
            return new ModelAndView("signupPage");
        }

        if (userService.isAlreadyExistAccount(userDto.getUserName())) {
            ModelAndView mav = new ModelAndView("signupPage");
            mav.addObject("message", "An account for that username/email already exists.");
            return mav;
        }
        AppUser appUser = new AppUser();
        appUser.setUserName(userDto.getUserName());
        appUser.setEnabled(true);
        appUser.setEncrytedPassword(EncrytedPasswordUtils.encrytePassword(userDto.getPassword()));
        userService.save(appUser);
        return new ModelAndView("signupSuccessfulPage");

        // rest of the implementation
    }

    @RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
    public String logoutSuccessfulPage(Model model) {
        model.addAttribute("title", "Logout");
        return "logoutSuccessfulPage";
    }

    @RequestMapping(value = "/userInfo", method = RequestMethod.GET)
    public String userInfo(Model model, Principal principal) {

        // Sau khi user login thanh cong se co principal
        String userName = principal.getName();

        System.out.println("User Name: " + userName);

        User loginedUser = (User) ((Authentication) principal).getPrincipal();

        String userInfo = WebUtils.toString(loginedUser);
        model.addAttribute("userInfo", userInfo);

        return "userInfoPage";
    }

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String accessDenied(Model model, Principal principal) {

        if (principal != null) {
            User loginedUser = (User) ((Authentication) principal).getPrincipal();

            String userInfo = WebUtils.toString(loginedUser);

            model.addAttribute("userInfo", userInfo);

            String message = "Hi " + principal.getName() //
                    + "<br> You do not have permission to access this page!";
            model.addAttribute("message", message);

        }

        return "403Page";
    }

}