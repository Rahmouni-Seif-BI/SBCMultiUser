package com.example.IgniteSelfBudgetControlMultiUser.Controllers;

import com.example.IgniteSelfBudgetControlMultiUser.ABC.IAbstractController;
import com.example.IgniteSelfBudgetControlMultiUser.Entities.Deposite;
import com.example.IgniteSelfBudgetControlMultiUser.Models.SearchCriteria;
import com.example.IgniteSelfBudgetControlMultiUser.Services.DepositeServiceImp;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/Deposite")
@RestController

public class DepositeController implements IAbstractController<Deposite> {

    @Autowired
    DepositeServiceImp depositeService;





    @PostMapping("/Save/{accountId}")
    @Operation(operationId = "saveDeposite")
    public ResponseEntity<Deposite> save(@RequestBody Deposite deposite, @PathVariable Long accountId) throws Exception {
        Deposite newDeposite = depositeService.save(deposite,accountId) ;
        return new ResponseEntity<>(newDeposite, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Deposite> save(Deposite entity) throws Exception {
        return null;
    }

    @Override
    public ResponseEntity<List<Deposite>> saveAll(List<Deposite> entities) throws Exception {
        return null;
    }

    @Override
    @Operation(operationId = "loadDeposite")
    @GetMapping(value = "/Load/{id}", produces = "application/json")
    public ResponseEntity<Deposite> load(@PathVariable Long id) {
        Deposite deposite = depositeService.getById(id);
        return new ResponseEntity<>(deposite,HttpStatus.OK);
    }

    @Override
    @Operation(operationId = "getAllDeposites")
    @GetMapping(value = "/GetAll", produces = "application/json")
    public ResponseEntity<List<Deposite>> getAll() throws Exception {
        List<Deposite> deposites = depositeService.getAll();
        return new ResponseEntity<>(deposites,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Deposite>> getAll(Long page, Long size) throws Exception {
        return null;
    }

    @Override
    @Operation(operationId = "deleteDeposite")
    @DeleteMapping("/Delete/{id}")
    public void delete(@PathVariable Long id) {
        depositeService.delete(id);
    }

    @Override
    public ResponseEntity<List<Deposite>> search(SearchCriteria criteria) throws Exception {
        return null;
    }

    @Operation(operationId = "getDepositesByAccount")
    @GetMapping(value = "/GetDepositesByAccount/{accountId}", produces = "application/json")
    public ResponseEntity<List<Deposite>> getDepositesByAccount(@PathVariable Long accountId) throws Exception {
        List<Deposite> depositesByAccountId = depositeService.getDepositesByAccount(accountId);
        return new ResponseEntity<>(depositesByAccountId,HttpStatus.OK);
    }
}
