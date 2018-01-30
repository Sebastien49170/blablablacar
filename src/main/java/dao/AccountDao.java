package dao;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

import domain.account.Account;

@Repository
public interface AccountDao extends CrudRepository<Account, Long> {
    public List<Account> findAllByFirstName(String firstName);
}
