package com.example.IgniteSelfBudgetControlMultiUser.Entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Account implements Serializable {



    private  static  final long serialVersionUID = 1L ;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String description;
    private String owner;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;


    //Credit Management System!

    @OneToMany(mappedBy = "creditorAccount")
    private List<CreditEntity> creditsGiven;

    @OneToMany(mappedBy = "debtorAccount")
    private List<CreditEntity> creditsReceived;

    @OneToMany(mappedBy = "creditorAccount")
    private List<RepaymentEntity> repaymentsReceived;

    @OneToMany(mappedBy = "debtorAccount")
    private List<RepaymentEntity> repaymentsMade;


    // END Credit Management System!


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public List<CreditEntity> getCreditsGiven() {
        return creditsGiven;
    }

    public void setCreditsGiven(List<CreditEntity> creditsGiven) {
        this.creditsGiven = creditsGiven;
    }

    public List<CreditEntity> getCreditsReceived() {
        return creditsReceived;
    }

    public void setCreditsReceived(List<CreditEntity> creditsReceived) {
        this.creditsReceived = creditsReceived;
    }

    public List<RepaymentEntity> getRepaymentsReceived() {
        return repaymentsReceived;
    }

    public void setRepaymentsReceived(List<RepaymentEntity> repaymentsReceived) {
        this.repaymentsReceived = repaymentsReceived;
    }

    public List<RepaymentEntity> getRepaymentsMade() {
        return repaymentsMade;
    }

    public void setRepaymentsMade(List<RepaymentEntity> repaymentsMade) {
        this.repaymentsMade = repaymentsMade;
    }
}
