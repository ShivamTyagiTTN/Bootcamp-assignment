package com.assignment.springdata2.entities.inhertance.mapping.joined;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "cardjoined")
@PrimaryKeyJoinColumn(name = "id")
public class CreditCardJoined extends PaymentJoined {

    @Column(name = "cardnumber")
    private String cardNumber;

    public String getCreditCard() {
        return cardNumber;
    }

    public void setCreditCard(String cardNumber) {
        this.cardNumber = cardNumber;
    }
}
