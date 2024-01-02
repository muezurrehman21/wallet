package com.zaio.Controllers;

import com.zaio.DTO.AccountDTO;
import com.zaio.DTO.AccountRequestDTO;
import com.zaio.Service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/create-account")
    public ResponseEntity<Object> CreateAccount(@RequestBody AccountRequestDTO accountRequestDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(accountService.CreateAccount(accountRequestDTO));
    }

    @GetMapping("/getAccount/{id}")
    public ResponseEntity<AccountDTO> getAccountByUser(@PathVariable("id") Long userId) {
        AccountDTO accountDTO = accountService.getAccountByUser(userId);
        if (accountDTO == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(accountDTO);
    }
}
