package com.assignment.springdata2.service;

import com.assignment.springdata2.entities.inhertance.mapping.joined.CreditCardJoined;
import com.assignment.springdata2.entities.inhertance.mapping.singletable.ChequeSingle;
import com.assignment.springdata2.entities.inhertance.mapping.tableperclass.ChequePerClass;
import com.assignment.springdata2.repos.inheritance.mapping.PaymentJoinedRepository;
import com.assignment.springdata2.repos.inheritance.mapping.PaymentPerClassRepository;
import com.assignment.springdata2.repos.inheritance.mapping.PaymentSingleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InterfaceMappingPaymentService {

    @Autowired
    PaymentSingleRepository paymentSingleRepository;

    @Autowired
    PaymentJoinedRepository paymentJoinedRepository;

    @Autowired
    PaymentPerClassRepository paymentPerClassRepository;

    public void paymentSingle(){
        ChequeSingle chequeSingle = new ChequeSingle();

        chequeSingle.setId(1);
        chequeSingle.setAmount(200.0);
        chequeSingle.setChequeNumber("2833414593");
        paymentSingleRepository.save(chequeSingle);
    }

    public void paymentJoined(){

        CreditCardJoined ccJoined = new CreditCardJoined();

        ccJoined.setId(2);
        ccJoined.setAmount(500.0);
        ccJoined.setCreditCard("3892418243");
        paymentJoinedRepository.save(ccJoined);
    }

    public void paymentPerClass(){

        ChequePerClass chequePerClass = new ChequePerClass();

        chequePerClass.setId(3);
        chequePerClass.setAmount(2500.0);
        chequePerClass.setChequeNumber("3214653242");
        paymentPerClassRepository.save(chequePerClass);
    }


}
