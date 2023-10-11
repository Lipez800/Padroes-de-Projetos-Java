package me.dio.domain.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity(name = "tb_account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String number;

    private String agency;

    @Column(precision = 13, scale = 2)
    private BigDecimal balance;

    @Column(name = "additional_limit", precision = 13, scale = 2)
    private BigDecimal limit;

    public Account() {
    }

    public Account(String number, String agency, BigDecimal balance, BigDecimal limit) {
        this.number = number;
        this.agency = agency;
        this.balance = balance;
        this.limit = limit;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getLimit() {
        return limit;
    }

    public void setLimit(BigDecimal limit) {
        this.limit = limit;
    }

    // Método para realizar um depósito
    public void deposit(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) > 0) {
            balance = balance.add(amount);
        } else {
            throw new IllegalArgumentException("O valor do depósito deve ser maior que zero.");
        }
    }

    // Método para realizar um saque
    public void withdraw(BigDecimal amount) {
        BigDecimal totalAmount = balance.add(limit);
        if (amount.compareTo(BigDecimal.ZERO) > 0 && amount.compareTo(totalAmount) <= 0) {
            balance = balance.subtract(amount);
        } else {
            throw new IllegalArgumentException("Valor de saque inválido.");
        }
    }

    // Métodos equals e hashCode para comparação de objetos
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Account account = (Account) o;
        return Objects.equals(id, account.id) &&
                Objects.equals(number, account.number) &&
                Objects.equals(agency, account.agency) &&
                Objects.equals(balance, account.balance) &&
                Objects.equals(limit, account.limit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, number, agency, balance, limit);
    }

    // Método toString para representação em string do objeto
    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", agency='" + agency + '\'' +
                ", balance=" + balance +
                ", limit=" + limit +
                '}';
    }
}
