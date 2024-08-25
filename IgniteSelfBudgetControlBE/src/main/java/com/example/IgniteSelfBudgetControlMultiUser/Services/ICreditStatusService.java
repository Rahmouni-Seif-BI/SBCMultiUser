package com.example.IgniteSelfBudgetControlMultiUser.Services;

import com.example.IgniteSelfBudgetControlMultiUser.Entities.CreditStatus;

import java.util.List;

public interface ICreditStatusService {
    List<CreditStatus> advancedSearch(Long currentPos, Long step, String searchCriteria) throws Exception;
}
