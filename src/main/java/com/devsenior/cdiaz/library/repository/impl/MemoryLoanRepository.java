package com.devsenior.cdiaz.library.repository.impl;

import java.util.ArrayList;
import java.util.List;

import com.devsenior.cdiaz.library.exceptions.NotFoundException;
import com.devsenior.cdiaz.library.model.Loan;
import com.devsenior.cdiaz.library.model.User;
import com.devsenior.cdiaz.library.repository.LoanRepository;

public class MemoryLoanRepository implements LoanRepository {

    List<Loan> loans = new ArrayList<>();

    @Override
    public void save(Loan loan) {
        loans.add(loan);
    }

    @Override
    public Loan findById(int id) {
        Loan response = null;

        for (var loan : loans) {
            if (loan.getId().equals(id)) {
                response = loan;
                break;
            }
        }

        if (response == null) {
            throw new NotFoundException("Préstamo no encontrado");
        }

        return response;
    }

    @Override
    public List<Loan> findByUser(User user) {
        var response = new ArrayList<Loan>();

        for (var loan : loans) {
            if (loan.getUser().getId().equals(user.getId())) {
                response.add(loan);
            }
        }

        return response;
    }

}
