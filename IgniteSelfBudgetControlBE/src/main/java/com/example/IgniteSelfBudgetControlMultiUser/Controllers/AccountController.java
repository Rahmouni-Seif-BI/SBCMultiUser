package com.example.IgniteSelfBudgetControlMultiUser.Controllers;
import com.example.IgniteSelfBudgetControlMultiUser.ABC.IAbstractController;
import com.example.IgniteSelfBudgetControlMultiUser.DTO.CreditEntityDTO;
import com.example.IgniteSelfBudgetControlMultiUser.DTO.RepaymentEntityDTO;
import com.example.IgniteSelfBudgetControlMultiUser.Models.SearchCriteria;
import com.example.IgniteSelfBudgetControlMultiUser.Services.AccountServiceImp;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.example.IgniteSelfBudgetControlMultiUser.DTO.AccountDTO;

@RequestMapping("/AccountDTO")
@RestController
public class AccountController implements IAbstractController<AccountDTO> {

    @Autowired
    AccountServiceImp accountService;

    @Operation(operationId = "loadAccount")
    @GetMapping(value = "/Load/{id}", produces = "application/json")
    public ResponseEntity<AccountDTO> load(@PathVariable Long id) {
        AccountDTO accountDTO = accountService.getById(id);
        return new ResponseEntity<>(accountDTO,HttpStatus.OK);
    }

    @Operation(operationId = "getAllAccounts")
    @GetMapping(value = "/getAllAccounts", produces = "application/json")
    public ResponseEntity<List<AccountDTO>> getAllAccounts()  throws Exception {
        List<AccountDTO> accountDTOs = accountService.getAllAccounts();
        return new  ResponseEntity<>(accountDTOs, HttpStatus.OK);
    }


    @Operation(operationId = "saveAccount")
    @PostMapping("/Save")
    public ResponseEntity<AccountDTO> save(@RequestBody AccountDTO accountDTO) throws Exception {
        AccountDTO newAccount = accountService.save(accountDTO) ;
        return new ResponseEntity<>(newAccount, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<AccountDTO>> saveAll(List<AccountDTO> entities) throws Exception {
        return null;
    }

    @Operation(operationId = "deleteAccount")
    @DeleteMapping("/Delete/{id}")
    public void delete(@PathVariable Long id) { accountService.delete(id);}


    // credit System
    @Operation(operationId = "getCreditsGivenByAccountAccount")
    @GetMapping(value = "/{accountId}/creditsGiven", produces = "application/json")

    public ResponseEntity<List<CreditEntityDTO>> getCreditsGivenByAccount(@PathVariable Long accountId) {
        List<CreditEntityDTO> creditsGiven = accountService.getCreditsGivenByAccount(accountId);
        return ResponseEntity.ok(creditsGiven);
    }

    @Operation(operationId = "getCreditsReceivedByAccountAccount")
    @GetMapping(value = "/{accountId}/creditsReceived", produces = "application/json")

    public ResponseEntity<List<CreditEntityDTO>> getCreditsReceivedByAccount(@PathVariable Long accountId) {
        List<CreditEntityDTO> creditsReceived = accountService.getCreditsReceivedByAccount(accountId);
        return ResponseEntity.ok(creditsReceived);
    }

    @Operation(operationId = "getRepaymentsReceivedByAccountAccount")
    @GetMapping(value = "/{accountId}/repaymentsReceived", produces = "application/json")

    public ResponseEntity<List<RepaymentEntityDTO>> getRepaymentsReceivedByAccount(@PathVariable Long accountId) {
        List<RepaymentEntityDTO> repaymentsReceived = accountService.getRepaymentsReceivedByAccount(accountId);
        return ResponseEntity.ok(repaymentsReceived);
    }

    @Operation(operationId = "getRepaymentsMadeByAccountAccount")
    @GetMapping(value = "/{accountId}/repaymentsMade", produces = "application/json")

    public ResponseEntity<List<RepaymentEntityDTO>> getRepaymentsMadeByAccount(@PathVariable Long accountId) {
        List<RepaymentEntityDTO> repaymentsMade = accountService.getRepaymentsMadeByAccount(accountId);
        return ResponseEntity.ok(repaymentsMade);
    }

    @Operation(operationId = "depositAccountAccount")
    @PostMapping("/DepositAccount/{accountId}/{amountToDepose}")
    @GetMapping(value = "/{accountId}/creditsReceived", produces = "application/json")

    public ResponseEntity<AccountDTO> depositAccount(@PathVariable Long accountId,@PathVariable float amountToDepose) throws Exception {
        AccountDTO newAccount = null;// accountService.depositAccount(accountId, amountToDepose) ;
        return new ResponseEntity<>(newAccount, HttpStatus.CREATED);
    }
    // End credit System



    //TODELETE
    @Override
    public ResponseEntity<List<AccountDTO>> getAll(Long page, Long size) throws Exception {
        return null;
    }

    @Operation(operationId = "getAllAccount")
    @GetMapping(value = "/GetAll", produces = "application/json")
    public ResponseEntity<List<AccountDTO>> getAll() throws Exception {
        List<AccountDTO> accounts = accountService.getAll();
        return new ResponseEntity<>(accounts,HttpStatus.OK);
    }

    @Operation(operationId = "searchAccount")
    @Override
    public ResponseEntity<List<AccountDTO>> search(SearchCriteria criteria) throws Exception {
        return null;
    }

}
