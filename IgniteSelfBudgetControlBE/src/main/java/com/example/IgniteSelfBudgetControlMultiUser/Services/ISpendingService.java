package com.example.IgniteSelfBudgetControlMultiUser.Services;

import com.example.IgniteSelfBudgetControlMultiUser.Entities.Spending;

import java.util.List;

public interface ISpendingService {
    List<Spending> advancedSearch(Long currentPos, Long step, String searchCriteria) throws Exception;
    Spending save(Spending entity, Long param1 ) throws Exception;
    Spending save(Spending entity, Long param1,Long param2) throws Exception;
    Spending save(Spending entity, Long param1,Long param2,Long param3) throws Exception;
    List<Spending> getSpendingsByAccount(Long accountId) throws Exception;

}
