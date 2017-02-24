package com.tomekD.api;


import com.tomekD.dao.LoanRepository;
import com.tomekD.error.EntityNotFoundException;
import com.tomekD.model.Loan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LoanRestController {


    private LoanRepository loanRepository;

    @Autowired
    public LoanRestController(LoanRepository loanRepository){
        this.loanRepository = loanRepository;
    }


    @RequestMapping(value = "/loan", method = RequestMethod.GET)
    public List<Loan> findAll(){
        return loanRepository.findAll();
    }


    @RequestMapping(value = "/loan", method = RequestMethod.POST)
    public ResponseEntity<Loan> createLoan(@RequestBody Loan loan){
        HttpStatus status = HttpStatus.OK;
        if (!loanRepository.exists(loan.getId())){
            status = HttpStatus.CREATED;
        }
        Loan saved = loanRepository.save(loan);
        return new ResponseEntity<Loan>(saved, status);
    }

    @RequestMapping(value = "loan/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Loan> updateLoan(@PathVariable Long id, @RequestBody Loan loan) throws EntityNotFoundException{
        Loan saved = loanRepository.update(id, loan);
        return new ResponseEntity<Loan>(saved, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/loan/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Loan> deleteLoan(@PathVariable Long id) throws EntityNotFoundException{
        loanRepository.delete(id);
        return new ResponseEntity<Loan>(HttpStatus.OK);
    }

}
