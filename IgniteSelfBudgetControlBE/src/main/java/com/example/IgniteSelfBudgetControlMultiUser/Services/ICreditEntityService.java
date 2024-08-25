package com.example.IgniteSelfBudgetControlMultiUser.Services;


import com.example.IgniteSelfBudgetControlMultiUser.Entities.CreditEntity;

import java.util.List;

public interface ICreditEntityService {
    List<CreditEntity> advancedSearch(Long currentPos, Long step, String searchCriteria) throws Exception;

    CreditEntity save(CreditEntity entity, Long param1 ) throws Exception;
    CreditEntity save(CreditEntity entity, Long param1,Long param2) throws Exception;
    CreditEntity save(CreditEntity entity, Long param1,Long param2,Long param3) throws Exception;
}
