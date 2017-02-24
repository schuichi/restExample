package com.tomekD.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;


@XmlRootElement
@Entity
public class Loan {

    @Id
    @GeneratedValue
    @XmlElement
    private Long id;

    @XmlElement
    private Long loanAmount;

    @XmlElement
    private int loanMonths;

    public Loan(Long id, Long loanAmount, int loanMonths) {
        this.id = id;
        this.loanAmount = loanAmount;
        this.loanMonths = loanMonths;
    }

    @XmlElement
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @XmlElement
    public Long getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(Long loanAmount) {
        this.loanAmount = loanAmount;
    }

    @XmlElement
    public int getLoanMonths() {
        return loanMonths;
    }

    public void setLoanMonths(int loanMonths) {
        this.loanMonths = loanMonths;
    }
}
