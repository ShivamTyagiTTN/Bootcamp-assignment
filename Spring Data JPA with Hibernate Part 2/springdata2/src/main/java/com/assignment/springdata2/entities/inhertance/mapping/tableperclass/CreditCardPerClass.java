package com.assignment.springdata2.entities.inhertance.mapping.tableperclass;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "card_perclass")
public class CreditCardPerClass extends PaymentPerClass {

    @Column(name = "cardnumber")
    private String cardNumber;

    public String getCreditCard() {
        return cardNumber;
    }

    public void setCreditCard(String cardNumber) {
        this.cardNumber = cardNumber;
    }
}
