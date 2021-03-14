package com.assignment.springdata2.entities.inhertance.mapping.singletable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("cc")
public class CreditCardSingle extends PaymentSingle {

    @Column(name = "cardnumber")
    private String cardNumber;

    public String getCreditCard() {
        return cardNumber;
    }

    public void setCreditCard(String cardNumber) {
        this.cardNumber = cardNumber;
    }
}