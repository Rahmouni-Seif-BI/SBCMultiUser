package com.example.IgniteSelfBudgetControlMultiUser.Services;

import com.example.IgniteSelfBudgetControlMultiUser.DTO.CreditEntityDTO;
import com.example.IgniteSelfBudgetControlMultiUser.DTO.RepaymentEntityDTO;
import com.example.IgniteSelfBudgetControlMultiUser.Entities.Account;

import java.util.List;

public interface IAccountService {
    Account depositAccount(Long accountId, float amountToDepose) throws Exception;

    List<CreditEntityDTO> getCreditsGivenByAccount(Long accountId);
    List<CreditEntityDTO> getCreditsReceivedByAccount(Long accountId);
    List<RepaymentEntityDTO> getRepaymentsReceivedByAccount(Long accountId);
    List<RepaymentEntityDTO> getRepaymentsMadeByAccount(Long accountId);
}
