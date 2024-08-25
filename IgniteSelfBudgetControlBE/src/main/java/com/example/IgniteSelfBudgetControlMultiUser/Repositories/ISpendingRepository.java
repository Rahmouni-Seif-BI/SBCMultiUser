package com.example.IgniteSelfBudgetControlMultiUser.Repositories;


import com.example.IgniteSelfBudgetControlMultiUser.Entities.Spending;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ISpendingRepository extends JpaRepository<Spending,Long> {
    List<Spending> getSpendingsByAccount_Id(Long accountId);
    List<Spending> getSpendingsByPurposeCode(String purpose);


}
