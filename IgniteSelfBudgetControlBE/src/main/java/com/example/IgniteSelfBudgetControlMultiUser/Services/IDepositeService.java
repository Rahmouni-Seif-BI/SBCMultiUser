package com.example.IgniteSelfBudgetControlMultiUser.Services;

import com.example.IgniteSelfBudgetControlMultiUser.Entities.Deposite;

import java.util.List;

public interface IDepositeService {
    List<Deposite> advancedSearch(Long currentPos, Long step, String searchCriteria) throws Exception;
    Deposite save(Deposite entity, Long param1 ) throws Exception;
    Deposite save(Deposite entity, Long param1,Long param2) throws Exception;
    Deposite save(Deposite entity, Long param1,Long param2,Long param3) throws Exception;
    List<Deposite> getDepositesByAccount(Long accountId) throws Exception;

}
