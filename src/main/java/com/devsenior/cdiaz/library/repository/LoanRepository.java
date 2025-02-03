package com.devsenior.cdiaz.library.repository;

import java.util.List;

import com.devsenior.cdiaz.library.model.Loan;
import com.devsenior.cdiaz.library.model.User;

public interface LoanRepository {
    void save(Loan loan);

    Loan findById(int id);

    List<Loan> findByUser(User user);
}
