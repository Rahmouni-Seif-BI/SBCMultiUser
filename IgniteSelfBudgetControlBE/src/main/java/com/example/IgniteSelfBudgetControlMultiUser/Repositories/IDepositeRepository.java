package com.example.IgniteSelfBudgetControlMultiUser.Repositories;


import com.example.IgniteSelfBudgetControlMultiUser.Entities.Deposite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IDepositeRepository extends JpaRepository<Deposite,Long> {
    List<Deposite> getDepositeByAccount_Id(Long accountId);

}
