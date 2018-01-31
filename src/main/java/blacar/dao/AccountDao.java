package blacar.dao;

import org.springframework.stereotype.Repository;

import blacar.domain.account.Account;

import org.springframework.data.repository.CrudRepository;
import java.util.List;



@Repository
public interface AccountDao extends CrudRepository<Account, Long> {
    public List<Account> findAllByFirstName(String firstName);
}
