package com.example.IgniteSelfBudgetControlMultiUser.Services;

import com.example.IgniteSelfBudgetControlMultiUser.ABC.Utils.Global;
import com.example.IgniteSelfBudgetControlMultiUser.DTO.AccountDTO;
import com.example.IgniteSelfBudgetControlMultiUser.DTO.LabelValueObject;
import com.example.IgniteSelfBudgetControlMultiUser.Entities.Spending;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.time.LocalDate;

// Get the current date

@Service
@Slf4j
@AllArgsConstructor
public class DashboardServiceImp  {


    @Autowired
    DepositeServiceImp depositeServiceImp;

    @Autowired
    SpendingServiceImp spendingServiceImp;

    @Autowired
    AccountServiceImp accountServiceImp;

    @Autowired
    private Global global;

    public List<LabelValueObject> getSpendingsByPurposePerMonth(String purpose){

        List<LabelValueObject> labelValueObjects = new ArrayList<>();


        // Get getSpendingsList
        List<Spending> spendingList = spendingServiceImp.getSpendingsByPurpose(purpose);

        // Create a map to store purpose and their occurrence count
        Map<String, Float> purposeCountMap = new HashMap<>();

        LocalDate currentDate = LocalDate.now();

        // Get the current month
        int currentMonth = currentDate.getMonthValue();
        // Iterate through the spendingList and count occurrences of each purpose
        for(
                Spending spending :spendingList)
        {
            if (spending.getActionDate().getMonth() +1 == currentMonth)
            {
                String purposeDescription = spending.getPurpose().getDescription();
                purposeCountMap.put(purposeDescription,  (purposeCountMap.getOrDefault(purposeDescription, (float) 0) + spending.getAmountToSpend()));
            }

        }

        // Create Objects for each distinct purpose and their occurrence count
        for(
                Map.Entry<String, Float> entry :purposeCountMap.entrySet())
        {
            LabelValueObject obj = new LabelValueObject(entry.getKey(),entry.getValue());

            labelValueObjects.add(obj);
        }
        return labelValueObjects;
    }






   public List<LabelValueObject> getSpendingsByPurpose(){

       List<LabelValueObject> labelValueObjects = new ArrayList<>();

       // Get getSpendingsList
       List<Spending> spendingList = spendingServiceImp.getAll();

       // Create a map to store purpose and their occurrence count
       Map<String, Float> purposeCountMap = new HashMap<>();

       // Iterate through the spendingList and count occurrences of each purpose
       for(
               Spending spending :spendingList)
       {
           String purposeDescription = spending.getPurpose().getDescription();
           purposeCountMap.put(purposeDescription, purposeCountMap.getOrDefault(purposeDescription, (float) 0) + spending.getAmountToSpend());
       }

       // Create Objects for each distinct purpose and their occurrence count
       for(
               Map.Entry<String, Float> entry :purposeCountMap.entrySet())
       {
           LabelValueObject obj = new LabelValueObject(entry.getKey(),entry.getValue());

           labelValueObjects.add(obj);
       }
       return labelValueObjects;
   }



    public List<LabelValueObject> getDepositeByAccount(){

        List<LabelValueObject> labelValueObjects = new ArrayList<>();

        // Get getSpendingsList
        List<AccountDTO> accountDTOS = accountServiceImp.getAllAccounts();

        // Create a map to store purpose and their occurrence count
        Map<String, Float> accountCountMap = new HashMap<>();

        // Iterate through the spendingList and count occurrences of each purpose
        for(
                AccountDTO accountDTO :accountDTOS)
        {
            String accountDescription = accountDTO.getDescription();
         //   accountCountMap.put(accountDescription, (accountCountMap.getOrDefault(accountDescription, (float) 0) + accountDTO.getCalculatedAmountBalance()));
        }

        // Create Objects for each distinct  and their occurrence count
        for(
                Map.Entry<String, Float> entry :accountCountMap.entrySet())
        {
            LabelValueObject obj = new LabelValueObject(entry.getKey(),entry.getValue());

            labelValueObjects.add(obj);
        }
        return labelValueObjects;
    }

    public List<LabelValueObject> getSpendingsByAccount(){

        List<LabelValueObject> labelValueObjects = new ArrayList<>();

        // Get getSpendingsList
        List<AccountDTO> accountDTOS = accountServiceImp.getAllAccounts();

        // Create a map to store purpose and their occurrence count
        Map<String, Float> accountCountMap = new HashMap<>();

        // Iterate through the spendingList and count occurrences of each purpose
        for(
                AccountDTO accountDTO :accountDTOS)
        {
            String accountDescription = accountDTO.getDescription();
       //     accountCountMap.put(accountDescription, (accountCountMap.getOrDefault(accountDescription, (float) 0) + accountDTO.getCalculatedAmountConsumed()));
        }

        // Create Objects for each distinct  and their occurrence count
        for(
                Map.Entry<String, Float> entry :accountCountMap.entrySet())
        {
            LabelValueObject obj = new LabelValueObject(entry.getKey(),entry.getValue());

            labelValueObjects.add(obj);
        }
        return labelValueObjects;
    }

    public List<LabelValueObject> getRestAmountByAccount(){

        List<LabelValueObject> labelValueObjects = new ArrayList<>();

        // Get getSpendingsList
        List<AccountDTO> accountDTOS = accountServiceImp.getAllAccounts();

        // Create a map to store purpose and their occurrence count
        Map<String, Float> accountCountMap = new HashMap<>();

        // Iterate through the spendingList and count occurrences of each purpose
        for(
                AccountDTO accountDTO :accountDTOS)
        {
            String accountDescription = accountDTO.getDescription();
           // accountCountMap.put(accountDescription, (accountCountMap.getOrDefault(accountDescription, (float) 0) + accountDTO.getCalculatedAmountRest()));
        }

        // Create Objects for each distinct  and their occurrence count
        for(
                Map.Entry<String, Float> entry :accountCountMap.entrySet())
        {
            LabelValueObject obj = new LabelValueObject(entry.getKey(),entry.getValue());

            labelValueObjects.add(obj);
        }
        return labelValueObjects;
    }

}
