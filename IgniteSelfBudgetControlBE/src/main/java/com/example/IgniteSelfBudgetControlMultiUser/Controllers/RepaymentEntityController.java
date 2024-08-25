package com.example.IgniteSelfBudgetControlMultiUser.Controllers;

import com.example.IgniteSelfBudgetControlMultiUser.ABC.IAbstractController;
import com.example.IgniteSelfBudgetControlMultiUser.DTO.RepaymentEntityDTO;
import com.example.IgniteSelfBudgetControlMultiUser.Entities.RepaymentEntity;
import com.example.IgniteSelfBudgetControlMultiUser.Models.SearchCriteria;
import com.example.IgniteSelfBudgetControlMultiUser.Services.RepaymentEntityServiceImp;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/RepaymentEntity")
@RestController

public class RepaymentEntityController implements IAbstractController<RepaymentEntity> {

    @Autowired
    RepaymentEntityServiceImp repaymentEntityService;

    @Override
    @PostMapping("/Save")
    @Operation(operationId = "saveRepaymentEntity")
    public ResponseEntity<RepaymentEntity> save(@RequestBody RepaymentEntity repaymentEntity) throws Exception {
        RepaymentEntity newRepaymentEntity = repaymentEntityService.save(repaymentEntity) ;
        return new ResponseEntity<>(newRepaymentEntity, HttpStatus.CREATED);
    }

    @Operation(operationId = "SaveRepaymentEntity")
    @PostMapping("/Save/{creditorAccountId}/{debitorAccountId}")
    public ResponseEntity<RepaymentEntity> save(@RequestBody RepaymentEntity RepaymentEntity, @PathVariable Long creditorAccountId, @PathVariable Long debitorAccountId) throws Exception {
        RepaymentEntity newRepaymentEntity = repaymentEntityService.save(RepaymentEntity, creditorAccountId, debitorAccountId) ;
        return new ResponseEntity<>(newRepaymentEntity, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<RepaymentEntity>> saveAll(List<RepaymentEntity> entities) throws Exception {
        return null;
    }

    @Override
    @GetMapping(value = "/Load/{id}", produces = "application/json")
    @Operation(operationId = "loadRepaymentEntity")
    public ResponseEntity<RepaymentEntity> load(@PathVariable Long id) {
        RepaymentEntity repaymentEntity = repaymentEntityService.getById(id);
        return new ResponseEntity<>(repaymentEntity,HttpStatus.OK);
    }

    @Override
    @GetMapping(value = "/GetAll", produces = "application/json")
    @Operation(operationId = "getAllRepaymentEntities")
    public ResponseEntity<List<RepaymentEntity>> getAll() throws Exception {
        List<RepaymentEntity> repaymentEntities = repaymentEntityService.getAll();
        return new ResponseEntity<>(repaymentEntities,HttpStatus.OK);
    }

    @Operation(operationId = "getAllRepaymentEntitiesDTO")
    @GetMapping(value = "/GetAllDTO", produces = "application/json")
    public ResponseEntity<List<RepaymentEntityDTO>> getAllRepaymentEntities() throws Exception {
        List<RepaymentEntityDTO> repaymentEntityDTOS = repaymentEntityService.getRepaymentEntities();
        return new ResponseEntity<>(repaymentEntityDTOS,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<RepaymentEntity>> getAll(Long page, Long size) throws Exception {
        return null;
    }

    @Override
    @DeleteMapping("/Delete/{id}")
    @Operation(operationId = "deleteRepaymentEntity")
    public void delete(@PathVariable Long id) {
        repaymentEntityService.delete(id);
    }

    @Override
    public ResponseEntity<List<RepaymentEntity>> search(SearchCriteria criteria) throws Exception {
        return null;
    }

}
