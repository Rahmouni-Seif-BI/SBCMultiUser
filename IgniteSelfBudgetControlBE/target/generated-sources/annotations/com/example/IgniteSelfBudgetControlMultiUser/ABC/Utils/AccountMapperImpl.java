package com.example.IgniteSelfBudgetControlMultiUser.ABC.Utils;

import com.example.IgniteSelfBudgetControlMultiUser.DTO.AccountDTO;
import com.example.IgniteSelfBudgetControlMultiUser.Entities.Account;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-25T17:40:55+0100",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.10 (Amazon.com Inc.)"
)
@Component
public class AccountMapperImpl implements AccountMapper {

    @Override
    public AccountDTO toAccountDTO(Account account) {
        if ( account == null ) {
            return null;
        }

        AccountDTO accountDTO = new AccountDTO();

        accountDTO.setId( account.getId() );
        accountDTO.setCode( account.getCode() );
        accountDTO.setDescription( account.getDescription() );
        accountDTO.setOwner( account.getOwner() );

        return accountDTO;
    }

    @Override
    public Account fromAccountDTO(AccountDTO accountDTO) {
        if ( accountDTO == null ) {
            return null;
        }

        Account account = new Account();

        account.setId( accountDTO.getId() );
        account.setCode( accountDTO.getCode() );
        account.setDescription( accountDTO.getDescription() );
        account.setOwner( accountDTO.getOwner() );

        return account;
    }
}
