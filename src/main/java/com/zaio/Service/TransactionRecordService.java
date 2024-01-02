package com.zaio.Service;

import com.zaio.DTO.TransferMoneyDTO;
import com.zaio.Entity.Account;
import com.zaio.Entity.TransactionRecord;
import com.zaio.Entity.Wallet;
import com.zaio.Enum.TransactionType;
import com.zaio.MessageHandling.CustomException;
import com.zaio.Repositories.TransactionRecordRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class TransactionRecordService {

    private final AccountService accountService;

    private final WalletService walletService;

    private final TransactionRecordRepository transactionRecordRepository;

    public TransactionRecordService(AccountService accountService, WalletService walletService, TransactionRecordRepository transactionRecordRepository) {
        this.accountService = accountService;
        this.walletService = walletService;
        this.transactionRecordRepository = transactionRecordRepository;
    }

    public void transferMoney(TransferMoneyDTO transferMoneyDTO) {

        // Retrieve source and destination accounts from the database
        Account sourceAccount = accountService.findById(transferMoneyDTO.getSourceAccountId())
                .orElseThrow(() -> new CustomException("Source account not found."));
        Account destinationAccount = accountService.findById(transferMoneyDTO.getDestinationAccountId())
                .orElseThrow(() -> new CustomException("Destination account not found."));

        // Retrieve source and destination wallets from the database
        Wallet sourceWallet = walletService.findById(transferMoneyDTO.getSourceWalletId())
                .orElseThrow(() -> new CustomException("Source wallet not found."));
        Wallet destinationWallet = walletService.findById(transferMoneyDTO.getDestinationWalletId())
                .orElseThrow(() -> new CustomException("Destination wallet not found."));

        // Check if the source wallet has sufficient balance to transfer the specified amount
        if (sourceWallet.getBalance().compareTo(transferMoneyDTO.getAmount()) < 0) {
            throw new CustomException("Insufficient balance in the source wallet.");
        }

        // Deduct the transfer amount from the source wallet's balance
        BigDecimal updatedSourceBalance = sourceWallet.getBalance().subtract(transferMoneyDTO.getAmount());
        sourceWallet.setBalance(updatedSourceBalance);

        // Add the transfer amount to the destination wallet's balance
        BigDecimal updatedDestinationBalance = destinationWallet.getBalance().add(transferMoneyDTO.getAmount());
        destinationWallet.setBalance(updatedDestinationBalance);

        // Save the updated wallets in the database
        walletService.save(sourceWallet);
        walletService.save(destinationWallet);

        // Create a new transaction record to store the details of the money transfer
        TransactionRecord transactionRecord = new TransactionRecord();
        transactionRecord.setAmount(transferMoneyDTO.getAmount());
        transactionRecord.setTransactionType(TransactionType.TRANSFER_OUT);
        transactionRecord.setTransactionDate(LocalDateTime.now());
        transactionRecord.setSourceAccount(sourceAccount);
        transactionRecord.setSourceWallet(sourceWallet);
        transactionRecord.setDestinationAccount(destinationAccount);
        transactionRecord.setDestinationWallet(destinationWallet);

        // Save the transaction record in the database
        transactionRecordRepository.save(transactionRecord);
    }
}
