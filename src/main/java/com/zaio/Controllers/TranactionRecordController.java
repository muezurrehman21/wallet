package com.zaio.Controllers;

import com.zaio.DTO.TransferMoneyDTO;
import com.zaio.MessageHandling.CustomException;
import com.zaio.MessageHandling.Response;
import com.zaio.Service.TransactionRecordService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class TranactionRecordController {

    private final TransactionRecordService transactionRecordService;

    public TranactionRecordController(TransactionRecordService transactionRecordService) {
        this.transactionRecordService = transactionRecordService;
    }

    @PostMapping("/transfer-money")
    public ResponseEntity<Object> trasferMoney(@RequestBody TransferMoneyDTO transferMoneyDTO){
        try {
            transactionRecordService.transferMoney(transferMoneyDTO);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response("Money transfer successful."));
        } catch (CustomException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Money has not been Transfered due to some error.");
        }
    }
}
