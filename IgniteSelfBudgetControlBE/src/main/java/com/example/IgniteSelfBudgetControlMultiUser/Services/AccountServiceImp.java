package com.example.IgniteSelfBudgetControlMultiUser.Services;

import com.example.IgniteSelfBudgetControlMultiUser.ABC.IAbstractService;
import com.example.IgniteSelfBudgetControlMultiUser.ABC.Utils.AccountMapper;
import com.example.IgniteSelfBudgetControlMultiUser.ABC.Utils.CreditEntityMapper;
import com.example.IgniteSelfBudgetControlMultiUser.ABC.Utils.Global;
import com.example.IgniteSelfBudgetControlMultiUser.ABC.Utils.RepaymentEntityMapper;
import com.example.IgniteSelfBudgetControlMultiUser.DTO.AccountDTO;
import com.example.IgniteSelfBudgetControlMultiUser.DTO.CreditEntityDTO;
import com.example.IgniteSelfBudgetControlMultiUser.DTO.RepaymentEntityDTO;
import com.example.IgniteSelfBudgetControlMultiUser.Entities.*;
import com.example.IgniteSelfBudgetControlMultiUser.Models.SearchCriteria;
import com.example.IgniteSelfBudgetControlMultiUser.Repositories.IAccountRepository;
import com.example.IgniteSelfBudgetControlMultiUser.Repositories.IDepositeRepository;
import com.example.IgniteSelfBudgetControlMultiUser.Repositories.ISpendingRepository;
import com.example.IgniteSelfBudgetControlMultiUser.Repositories.IUserEntityRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import javax.persistence.EntityNotFoundException;
import javax.validation.ValidationException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
@Service
@Slf4j
@AllArgsConstructor
public class AccountServiceImp   implements IAccountService, IAbstractService<AccountDTO> {

    @Autowired
    IAccountRepository iAccountRepository;

    @Autowired
    ISpendingRepository iSpendingRepository;

    @Autowired
    IDepositeRepository iDepositeRepository;

    @Autowired
    private CreditEntityMapper creditEntityMapper;

    @Autowired
    private RepaymentEntityMapper repaymentEntityMapper;


    @Autowired
    private IUserEntityRepository iUserEntityRepository;

    @Autowired
    private Global global;

    @Autowired
    AccountMapper accountMapper;


    @Override
    public AccountDTO getById(Long id)
    {
        UserEntity user = global.getCurrentUser();
        Account account = iAccountRepository.getAccountByIdAndUserId(id, user.getId());
        account.setOwner(user.getName() + " " + user.getSurname());
        AccountDTO accountDTO  = accountMapper.toAccountDTO(account);

        //Calculate Spent
        //Calculate total deposit
        //Calculate Rest

        return accountDTO;
    }

    public List<AccountDTO> getAllAccounts()
    {
        UserEntity user = global.getCurrentUser();
        List<Account> accounts = iAccountRepository.findAccountsByUser_Id(user.getId());
        List<AccountDTO> accountDTOS = new ArrayList<>();

        for (Account account : accounts) {
            accountDTOS.add(getById(account.getId()));
        }
        return accountDTOS;
    }

    @Override
    public AccountDTO save(AccountDTO entity) throws Exception
    {
        UserEntity user = global.getCurrentUser();
        Account account = accountMapper.fromAccountDTO(entity);
        account.setUser(user);
        account = iAccountRepository.save(account);

        return  getById(account.getId());
    }

    @Override
    public List<AccountDTO> saveAll(List<AccountDTO> entities) throws Exception {
        return null;
    }

    @Override
    public void delete(Long id) {
        iAccountRepository.deleteById(id);
    }


    // credit System
    public void calculateSpendings(AccountDTO accountDTO) {
//        float amountConsumed = 0;
//        List<Spending> spendings = iSpendingRepository.getSpendingsByAccount_Id(accountDTO.getId());
//        for (Spending spending : spendings) {
//            amountConsumed += spending.getAmountToSpend();
//        }
//        accountDTO.setCalculatedAmountconsumed(amountConsumed);
    }

    public void calculateRemainingBalance(AccountDTO accountDTO) {
//        float remainingBalance = accountDTO.getCalculatedAmountbalance() - accountDTO.getCalculatedAmountconsumed();
//        accountDTO.setCalculatedAmountRest(remainingBalance);
    }


    //Credit
    public List<CreditEntityDTO> getCreditsGivenByAccount(Long accountId) {
//        AccountDTO creditorAccount = iAccountRepository.findById(accountId)
//                .orElseThrow(() -> new NotFoundException("Creditor accountDTO not found"));
//        return creditEntityMapper.toDTOList(creditorAccount.getCreditsGiven()); // Use the mapper to map entities to DTOs;
        return  null;
    }


    @Override
    public List<CreditEntityDTO> getCreditsReceivedByAccount(Long accountId) {
//        AccountDTO debtorAccount = iAccountRepository.findById(accountId)
//                .orElseThrow(() -> new NotFoundException("Debtor accountDTO not found"));
//        return creditEntityMapper.toDTOList(debtorAccount.getCreditsReceived()); // Use the mapper to map entities to DTOs;
    return null;
    }

    @Override
    public List<RepaymentEntityDTO> getRepaymentsReceivedByAccount(Long accountId) {
//        AccountDTO creditorAccount = iAccountRepository.findById(accountId)
//                .orElseThrow(() -> new NotFoundException("Creditor accountDTO not found"));
//        return repaymentEntityMapper.toDTOList(creditorAccount.getRepaymentsReceived()); // Use the mapper to map entities to DTOs;
        return null;
    }

    @Override
    public List<RepaymentEntityDTO> getRepaymentsMadeByAccount(Long accountId) {
//        AccountDTO debtorAccount = iAccountRepository.findById(accountId)
//                .orElseThrow(() -> new NotFoundException("Debtor accountDTO not found"));
//        return repaymentEntityMapper.toDTOList(debtorAccount.getRepaymentsMade()); // Use the mapper to map entities to DTOs;
        return null;
    }
    // END credit System



    //TODELETE
    @Override
    public List<AccountDTO> search(SearchCriteria criteria) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void validate(AccountDTO entity) throws ValidationException {

    }
    public Account depositAccount(Long accountId, float amountToDepose) throws Exception {
        return null;
    }


    @Override
    public List<AccountDTO> getAll() {
        return null;
    }

}
