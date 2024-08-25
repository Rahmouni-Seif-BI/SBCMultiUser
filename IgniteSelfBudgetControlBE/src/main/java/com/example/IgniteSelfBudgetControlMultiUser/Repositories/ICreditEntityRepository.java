package com.example.IgniteSelfBudgetControlMultiUser.Repositories;


import com.example.IgniteSelfBudgetControlMultiUser.Entities.CreditEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICreditEntityRepository extends JpaRepository<CreditEntity,Long> {
}
