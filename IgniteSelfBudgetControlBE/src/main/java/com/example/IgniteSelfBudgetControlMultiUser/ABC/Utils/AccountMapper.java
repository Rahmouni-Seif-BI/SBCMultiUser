package com.example.IgniteSelfBudgetControlMultiUser.ABC.Utils;

import com.example.IgniteSelfBudgetControlMultiUser.DTO.AccountDTO;
import com.example.IgniteSelfBudgetControlMultiUser.Entities.Account;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface AccountMapper {
    AccountDTO toAccountDTO(Account account);
    Account fromAccountDTO(AccountDTO accountDTO);
}
