package com.example.IgniteSelfBudgetControlMultiUser.Services;


import com.example.IgniteSelfBudgetControlMultiUser.Entities.UserEntity;

import java.util.List;

public interface IUserEntityService {
    List<UserEntity> advancedSearch(Long currentPos, Long step, String searchCriteria) throws Exception;

    UserEntity save(UserEntity entity, Long param1 ) throws Exception;
    UserEntity save(UserEntity entity, Long param1,Long param2) throws Exception;
    UserEntity save(UserEntity entity, Long param1,Long param2,Long param3) throws Exception;
}
