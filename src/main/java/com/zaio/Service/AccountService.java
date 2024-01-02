package com.zaio.Service;

import com.zaio.DTO.AccountDTO;
import com.zaio.DTO.AccountRequestDTO;
import com.zaio.DTO.UserDTO;
import com.zaio.DTO.WalletDTO;
import com.zaio.Entity.Account;
import com.zaio.Entity.User;
import com.zaio.Entity.Wallet;
import com.zaio.MessageHandling.Response;
import com.zaio.Repositories.AccountRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    private final UserService userService;

    public AccountService(AccountRepository accountRepository, UserService userService) {
        this.accountRepository = accountRepository;
        this.userService = userService;
    }

    public Object CreateAccount(AccountRequestDTO accountRequestDTO) {
        Optional<User> user = userService.findById(accountRequestDTO.getUserId());
        if (user.isPresent()){
            Account account = new Account(
                    accountRequestDTO.getAccountId(),
                    accountRequestDTO.getAccountName(),
                    LocalDateTime.now(),
                    LocalDateTime.now(),
                    user.get()
            );
            Account savedAccount  = accountRepository.save(account);
            accountRequestDTO = new AccountRequestDTO(
                    savedAccount.getAccountId(),
                    savedAccount.getAccountName(),
                    savedAccount.getUser().getUserId()
            );
            return accountRequestDTO;
        }
        else {
            return new Response("user doesn't exist with "+ accountRequestDTO.getUserId());
        }
    }

    public AccountDTO getAccountByUser(Long userId) {
        User user = userService.findById(userId).orElse(null);
        if (user == null) {
            return null;
        }

        Account account = accountRepository.findByUser(user);
        if (account == null) {
            return null;
        }

        List<WalletDTO> wallets = account.getWallets().stream()
                .map(this::mapWalletToWalletDTO)
                .collect(Collectors.toList());

        BigDecimal totalAmount = account.getWallets().stream()
                .map(Wallet::getBalance)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        UserDTO userDTO = mapUserToUserDTO(user);

        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setAccountId(account.getAccountId());
        accountDTO.setAccountName(account.getAccountName());
        accountDTO.setTotalAmount(totalAmount);
        accountDTO.setWallets(wallets);
        accountDTO.setUser(userDTO);

        return accountDTO;
    }

    private WalletDTO mapWalletToWalletDTO(Wallet wallet) {
        WalletDTO walletDTO = new WalletDTO();
        walletDTO.setWalletId(wallet.getWalletId());
        walletDTO.setWalletName(wallet.getWalletName());
        walletDTO.setBalance(wallet.getBalance());
        return walletDTO;
    }

    private UserDTO mapUserToUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(user.getUserId());
        userDTO.setUsername(user.getUsername());
        userDTO.setEmail(user.getEmail());
        userDTO.setPhoneNumber(user.getPhoneNumber());
        return userDTO;
    }

    public Optional<Account> findById(Long accountId) {
        return accountRepository.findById(accountId);
    }
}
