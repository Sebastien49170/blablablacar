package blacar.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import blacar.domain.account.Account;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long>{
	
	public Account findByLogin(String login);
	
	
	}

