package com.example.IgniteSelfBudgetControlMultiUser.ABC.Utils;

import com.example.IgniteSelfBudgetControlMultiUser.Entities.Account;
import com.example.IgniteSelfBudgetControlMultiUser.Entities.Deposite;
import com.example.IgniteSelfBudgetControlMultiUser.Entities.UserEntity;
import com.example.IgniteSelfBudgetControlMultiUser.Repositories.IDepositeRepository;
import com.example.IgniteSelfBudgetControlMultiUser.Repositories.IUserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Global {
    @Autowired
    IDepositeRepository iDepositeRepository;

    @Autowired
    IUserEntityRepository iUserEntityRepository;

    public void calculateDeposits(Account account) {
//        float depositeAmount = 0;
//        List<Deposite> deposites = iDepositeRepository.getDepositeByAccount_Id(account.getId());
//        for (Deposite deposite : deposites) {
//            depositeAmount += deposite.getAmountToDeposite();
//        }
//        account.setCalculatedAmountbalance(depositeAmount);
    }

    public Integer calculateDepositsStat(Account account) {
        float depositeAmount = 0;
        List<Deposite> deposites = iDepositeRepository.getDepositeByAccount_Id(account.getId());
        for (Deposite deposite : deposites) {
            depositeAmount += deposite.getAmountToDeposite();
        }
        return  (int)depositeAmount;
    }

    private String getCurrentUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            return userDetails.getUsername();
        }
        return null;
    }

    public UserEntity getCurrentUser()
    {
        String userName = getCurrentUsername();
        UserEntity user = iUserEntityRepository.findUserEntityByLogin(userName);
        return user;
    }
}
