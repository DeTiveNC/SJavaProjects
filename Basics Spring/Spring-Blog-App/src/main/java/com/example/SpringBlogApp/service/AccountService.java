package com.example.SpringBlogApp.service;

import com.example.SpringBlogApp.models.Account;
import com.example.SpringBlogApp.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.authentication.PasswordEncoderParser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public Account save(Account account){
        return accountRepository.saveAndFlush(account);
    }
    public Optional<Account> findByEmail(String email){
        return accountRepository.findOneByEmail(email);
    }
    public String encodePassword(String password){
        return passwordEncoder.encode(password);
    }

    public Optional<Account> findLoggedInUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.isAuthenticated() && authentication.getPrincipal() instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            return findByEmail(userDetails.getUsername()); // Assuming the email is the username
        }

        return Optional.empty();
    }
}
