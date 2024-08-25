package com.example.IgniteSelfBudgetControlMultiUser.Repositories;


import com.example.IgniteSelfBudgetControlMultiUser.Entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IAccountRepository extends JpaRepository<Account,Long> {

    public List<Account>  findAccountsByUser_Id( Long userId);
    public Account  getAccountByIdAndUserId(Long accountId, Long userId);
}
