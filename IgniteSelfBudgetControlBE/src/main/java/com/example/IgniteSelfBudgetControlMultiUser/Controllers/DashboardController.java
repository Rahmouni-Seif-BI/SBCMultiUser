package com.example.IgniteSelfBudgetControlMultiUser.Controllers;

import com.example.IgniteSelfBudgetControlMultiUser.Services.DashboardServiceImp;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.example.IgniteSelfBudgetControlMultiUser.DTO.LabelValueObject;
@RequestMapping("/Dashboard")
@RestController

public class DashboardController{

    @Autowired
    DashboardServiceImp dashboardServiceImp;

    @GetMapping(value = "/GetSpendingsByPurpose", produces = "application/json")
    @Operation(operationId = "getSpendingsByPurpose")
    public ResponseEntity<List<LabelValueObject>> GetSpendingsByPurpose() throws Exception {
        List<LabelValueObject> objectsList = dashboardServiceImp.getSpendingsByPurpose();
        return new ResponseEntity<>(objectsList,HttpStatus.OK);
    }
    @GetMapping(value = "/GetSpendingsByPurposePerMonth/{purpose}", produces = "application/json")
    @Operation(operationId = "getSpendingsByPurposePerMonth")
    public ResponseEntity<List<LabelValueObject>> GetSpendingsByPurposePerMonth(@PathVariable String purpose) throws Exception {
        List<LabelValueObject> objectsList = dashboardServiceImp.getSpendingsByPurposePerMonth(purpose);
        return new ResponseEntity<>(objectsList,HttpStatus.OK);
    }

    @GetMapping(value = "/GetDepositeByAccount", produces = "application/json")
    @Operation(operationId = "getDepositeByAccount")
    public ResponseEntity<List<LabelValueObject>> GetDepositeByAccount() throws Exception {
        List<LabelValueObject> objectsList = dashboardServiceImp.getDepositeByAccount();
        return new ResponseEntity<>(objectsList,HttpStatus.OK);
    }

    @GetMapping(value = "/GetSpendingsByAccount", produces = "application/json")
    @Operation(operationId = "getSpendingsByAccount")
    public ResponseEntity<List<LabelValueObject>> GetSpendingsByAccount() throws Exception {
        List<LabelValueObject> objectsList = dashboardServiceImp.getSpendingsByAccount();
        return new ResponseEntity<>(objectsList,HttpStatus.OK);
    }

    @GetMapping(value = "/GetRestAmountByAccount", produces = "application/json")
    @Operation(operationId = "getRestAmountByAccount")
    public ResponseEntity<List<LabelValueObject>> GetRestAmountByAccount() throws Exception {
        List<LabelValueObject> objectsList = dashboardServiceImp.getRestAmountByAccount();
        return new ResponseEntity<>(objectsList,HttpStatus.OK);
    }

}
