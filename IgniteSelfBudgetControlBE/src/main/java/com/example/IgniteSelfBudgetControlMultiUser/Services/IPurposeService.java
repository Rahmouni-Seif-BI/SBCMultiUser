package com.example.IgniteSelfBudgetControlMultiUser.Services;

import com.example.IgniteSelfBudgetControlMultiUser.Entities.Purpose;

import java.util.List;

public interface IPurposeService {
    List<Purpose> advancedSearch(Long currentPos, Long step, String searchCriteria) throws Exception;
}
