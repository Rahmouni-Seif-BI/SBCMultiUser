package com.example.IgniteSelfBudgetControlMultiUser.Repositories;


import com.example.IgniteSelfBudgetControlMultiUser.Entities.CreditStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICreditStatusRepository extends JpaRepository<CreditStatus,Long> {
}
