package com.mindhub.homebanking;

import com.mindhub.homebanking.models.*;
import com.mindhub.homebanking.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

@SpringBootApplication
public class HomebankingApplication {
    public static void main(String[] args) {
        SpringApplication.run(HomebankingApplication.class, args);
    }

    @Bean
    public CommandLineRunner initData (ClientRepository clientRepository, AccountRepository accountRepository, TransactionRepository transactionRepository, LoanRepository loanRepository, ClientLoanRepository clientLoanRepository){
        return args -> {
            Client client1 = new Client("Melba", "Morel", "melba@mindhub.com");
            Client client2 = new Client("Fede", "Paez", "fedepaez@outlook.com");
            Account account1 = new Account("VIN001", LocalDate.now(), 5000.34);
            Account account2 = new Account("VIN002", LocalDate.now().plusDays(1), 7500.76);
            Account account3 = new Account("VIN003", LocalDate.now().plusDays(2), 3000000.42);
            Account account4 = new Account("VIN004", LocalDate.now().plusDays(4), 5000000.37);
            Transaction trans1 = new Transaction(5340.02, "retail purchase", TransactionType.CREDIT, LocalDateTime.now());
            Transaction trans2 = new Transaction(482.02, "retail purchase", TransactionType.CREDIT, LocalDateTime.now());
            Transaction trans3 = new Transaction(-5084.06, "supermarket purchase", TransactionType.DEBIT, LocalDateTime.now());
            Transaction trans4 = new Transaction(4432.06, "retail purchase", TransactionType.CREDIT, LocalDateTime.now());
            Transaction trans5 = new Transaction(965321.02, "retail purchase", TransactionType.CREDIT, LocalDateTime.now());
            Transaction trans6 = new Transaction(-125480.15, "retail purchase", TransactionType.DEBIT, LocalDateTime.now());
            Transaction trans7 = new Transaction(4421.02, "supermarket purchase", TransactionType.CREDIT, LocalDateTime.now());
            Transaction trans8 = new Transaction(315.06, "retail purchase", TransactionType.CREDIT, LocalDateTime.now());
            Transaction trans9 = new Transaction(-4215.03, "retail purchase", TransactionType.DEBIT, LocalDateTime.now());
            Transaction trans10 = new Transaction(1544.82, "retail purchase", TransactionType.CREDIT, LocalDateTime.now());
            Transaction trans11 = new Transaction(432.65, "supermarket purchase", TransactionType.CREDIT, LocalDateTime.now());
            Transaction trans12 = new Transaction(814.21, "retail purchase", TransactionType.CREDIT, LocalDateTime.now());
            Transaction trans13 = new Transaction(-32.25, "retail purchase", TransactionType.DEBIT, LocalDateTime.now());
            Transaction trans14 = new Transaction(215.36, "supermarket purchase", TransactionType.CREDIT, LocalDateTime.now());
            Transaction trans15 = new Transaction(-215.25, "retail purchase", TransactionType.DEBIT, LocalDateTime.now());
            Transaction trans16 = new Transaction(1256.25, "retail purchase", TransactionType.CREDIT, LocalDateTime.now());
            Loan loan1 = new Loan("Mortgage", 500000, Arrays.asList(12,24,36,48,60));
            Loan loan2 = new Loan("Personal", 100000, Arrays.asList(6,12,24));
            Loan loan3 = new Loan("Automotive", 300000, Arrays.asList(6,12,24,36));
            ClientLoan clientLoan1 = new ClientLoan(400000, 60);
            ClientLoan clientLoan2 = new ClientLoan(50000, 12);
            ClientLoan clientLoan3 = new ClientLoan(100000, 24);
            ClientLoan clientLoan4 = new ClientLoan(200000, 36);

            client1.addClientLoan(clientLoan1);
            loan1.addClientLoan(clientLoan1);
            client1.addClientLoan(clientLoan2);
            loan2.addClientLoan(clientLoan2);
            client2.addClientLoan(clientLoan3);
            loan2.addClientLoan(clientLoan3);
            client2.addClientLoan(clientLoan4);
            loan3.addClientLoan(clientLoan4);
            client1.addAccount(account1);
            client1.addAccount(account2);
            client2.addAccount(account3);
            client2.addAccount(account4);
            account1.addTransaction(trans1);
            account1.addTransaction(trans2);
            account1.addTransaction(trans3);
            account1.addTransaction(trans4);
            account2.addTransaction(trans5);
            account2.addTransaction(trans6);
            account2.addTransaction(trans7);
            account2.addTransaction(trans8);
            account3.addTransaction(trans9);
            account3.addTransaction(trans10);
            account3.addTransaction(trans11);
            account3.addTransaction(trans12);
            account4.addTransaction(trans13);
            account4.addTransaction(trans14);
            account4.addTransaction(trans15);
            account4.addTransaction(trans16);
            clientRepository.save(client1);
            clientRepository.save(client2);
            accountRepository.save(account1);
            accountRepository.save(account2);
            accountRepository.save(account3);
            accountRepository.save(account4);
            transactionRepository.save(trans1);
            transactionRepository.save(trans2);
            transactionRepository.save(trans3);
            transactionRepository.save(trans4);
            transactionRepository.save(trans5);
            transactionRepository.save(trans6);
            transactionRepository.save(trans7);
            transactionRepository.save(trans8);
            transactionRepository.save(trans9);
            transactionRepository.save(trans10);
            transactionRepository.save(trans11);
            transactionRepository.save(trans12);
            transactionRepository.save(trans13);
            transactionRepository.save(trans14);
            transactionRepository.save(trans15);
            transactionRepository.save(trans16);
            loanRepository.save(loan1);
            loanRepository.save(loan2);
            loanRepository.save(loan3);
            clientLoanRepository.save(clientLoan1);
            clientLoanRepository.save(clientLoan2);
            clientLoanRepository.save(clientLoan3);
            clientLoanRepository.save(clientLoan4);

        };
    }
};