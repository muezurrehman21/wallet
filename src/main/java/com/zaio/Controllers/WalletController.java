package com.zaio.Controllers;

import com.zaio.DTO.WalletRequestDTO;
import com.zaio.Service.WalletService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WalletController {
    private final WalletService walletService;

    public WalletController(WalletService walletService) {
        this.walletService = walletService;
    }

    @PostMapping("/create-wallet")
    public ResponseEntity<Object> CreateWallet(@RequestBody WalletRequestDTO walletRequestDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(walletService.CreateWallet(walletRequestDTO));
    }
}
