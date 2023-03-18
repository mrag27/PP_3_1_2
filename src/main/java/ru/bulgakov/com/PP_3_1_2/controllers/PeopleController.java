package ru.bulgakov.com.PP_3_1_2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.bulgakov.com.PP_3_1_2.models.User;
import ru.bulgakov.com.PP_3_1_2.service.UserService;


@Controller
public class PeopleController {
    private UserService userService;

    public PeopleController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String getAllUser(Model model) {
        model.addAttribute("users", userService.getAllUser());
        return "user/all";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "user/show";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "user/new";
    }

    @PostMapping("/save")
    public String addUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/";
    }

    @PatchMapping("/update{id}")
    public String update(@PathVariable("id") int id, @ModelAttribute("user") User user) {
        userService.updateUser(id, user);
        return "redirect:/";
    }

    @DeleteMapping("/delete{id}")
    public String delete(@PathVariable("id") int id, @ModelAttribute("user") User user) {
        userService.deleteUser(id);
        return "redirect:/";
    }
}
