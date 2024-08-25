package com.example.IgniteSelfBudgetControlMultiUser.Repositories;


import com.example.IgniteSelfBudgetControlMultiUser.Entities.RepaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepaymentEntityRepository extends JpaRepository<RepaymentEntity,Long> {
}
