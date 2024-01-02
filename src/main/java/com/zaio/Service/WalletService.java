package com.zaio.Service;

import com.zaio.DTO.WalletRequestDTO;
import com.zaio.Entity.Account;
import com.zaio.Entity.Wallet;
import com.zaio.MessageHandling.Response;
import com.zaio.Repositories.WalletRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;

@Service
public class WalletService {
    private final WalletRepository walletRepository;

    private final AccountService accountService;

    public WalletService(WalletRepository walletRepository, AccountService accountService) {
        this.walletRepository = walletRepository;
        this.accountService = accountService;
    }

    public Object CreateWallet(WalletRequestDTO walletRequestDTO) {
        Optional<Account> account = accountService.findById(walletRequestDTO.getAccountId());
        if (account.isPresent()) {
            Wallet wallet = new Wallet(
                    walletRequestDTO.getWalletId(),
                    walletRequestDTO.getWalletName(),
                    walletRequestDTO.getBalance(),
                    Instant.now(),
                    Instant.now(),
                    account.get()
                    );
            Wallet savedWallet = walletRepository.save(wallet);
            walletRequestDTO = new WalletRequestDTO(
                    savedWallet.getWalletId(),
                    savedWallet.getWalletName(),
                    savedWallet.getBalance(),
                    savedWallet.getAccount().getAccountId()
            );
            return walletRequestDTO;
        }
        return new Response("Account doesn't exist with id "+ walletRequestDTO.getAccountId());
    }

    public Optional<Wallet> findById(Long WalletId) {
        return walletRepository.findById(WalletId);
    }

    public void save(Wallet wallet) {
        walletRepository.save(wallet);
    }
}
