package com.example.IgniteSelfBudgetControlMultiUser.Repositories;


import com.example.IgniteSelfBudgetControlMultiUser.Entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserEntityRepository extends JpaRepository<UserEntity,Long> {

    UserEntity getUserEntityByLoginAndPass(String login, String pass);
    UserEntity findUserEntityByLogin(String login);
}
