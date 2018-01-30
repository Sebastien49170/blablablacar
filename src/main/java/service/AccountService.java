package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.AccountDao;
import domain.account.Account;

@Service
public class AccountService {

    @Autowired
    AccountDao accountDao;

    public void signup(Account account) {
        accountDao.save(account);
    }
}