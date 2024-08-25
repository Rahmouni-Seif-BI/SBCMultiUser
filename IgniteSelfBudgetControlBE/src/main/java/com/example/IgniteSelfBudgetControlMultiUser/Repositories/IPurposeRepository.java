package com.example.IgniteSelfBudgetControlMultiUser.Repositories;


import com.example.IgniteSelfBudgetControlMultiUser.Entities.Purpose;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPurposeRepository extends JpaRepository<Purpose,Long> {
}
