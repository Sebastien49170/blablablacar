package api;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dao.AccountDao;
import domain.account.Account;
import service.AccountService;


@RestController
@RequestMapping("/account")
public class AccountController {

	@Autowired
	AccountService accountService;
	
	@Autowired
	AccountDao accountDoa;
	
	
	@GetMapping("{id}")
    public Account find(@PathVariable("id") Long accountId) {
        return accountDoa.findOne(accountId);
    }

    @GetMapping
    public Iterable<Account> findAll() {
        return accountDoa.findAll();
    }

    @PostMapping
    public void signup(@RequestBody Account account) {
        System.out.println("signup | account: " + account);
        accountService.signup(account);
    }
}