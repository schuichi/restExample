package com.tomekD.dao;

import com.tomekD.error.EntityNotFoundException;
import com.tomekD.model.Loan;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class LoanRepository {
    private final Map<Long, Loan> loanMap = new ConcurrentHashMap<>();
    public Loan update(Long id, Loan loan) throws EntityNotFoundException{
        if (!exists(id)){
            throw new EntityNotFoundException("Element" + id + "nie istnieje");
        }
        loan.setId(id);
        return loanMap.put(id, loan);
    }


    public Loan save(Loan loan) {
        return loanMap.put(loan.getId(), loan);
    }

    public Loan findOne(Long id) throws EntityNotFoundException{
        if (!exists(id)){
            throw new EntityNotFoundException("Element" + id + "nie istnieje");
        }
        return loanMap.get(id);
    }

    public List<Loan> findAll(){
        return new ArrayList<>(loanMap.values());
    }

    public void delete(Long id) throws EntityNotFoundException{
        if (!exists(id)){
            throw new EntityNotFoundException("Element" + id + "nie istnieje");
        }
        loanMap.remove(id);
    }

    public boolean exists(Long id){
        return loanMap.containsKey(id);
    }


}
