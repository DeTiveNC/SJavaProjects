package com.example.SpringBlogApp.controller;

import com.example.SpringBlogApp.models.Account;
import com.example.SpringBlogApp.models.Authority;
import com.example.SpringBlogApp.repository.AuthorityRepository;
import com.example.SpringBlogApp.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
public class RegisterController {
    @Autowired
    private AccountService accountService;
    @Autowired
    private AuthorityRepository authorityRepository;

    @GetMapping("/register")
    public String getRegisterPage(Model model){
        Account account = new Account();
        model.addAttribute("account", account);
        return "register";
    }

    @PostMapping("/register")
    public String registerNewUser(@ModelAttribute Account account){
        account.setPassword(accountService.encodePassword(account.getPassword()));
        Set<Authority> authorities1 = new HashSet<>();
        account.setAuthorities(authorities1);
        authorityRepository.findById("ROLE_USER").ifPresent(authorities1::add);
        accountService.save(account);

        return "redirect:/";
    }
}
