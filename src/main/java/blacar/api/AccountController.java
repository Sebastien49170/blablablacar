package blacar.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import blacar.dao.AccountDao;
import blacar.domain.account.Account;
import blacar.service.AccountService;



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
        accountService.signup(account);
    }
    
    @PostMapping("/addvehicle/{aid}/{vid}")
    public void addVehicleToUser(@PathVariable("aid") Long accountId, @PathVariable("vid") Long vehiculeId) {
        accountService.addVehicleToUser(accountId, vehiculeId);
    }
       
    @PostMapping("/addride/{aid}/{rid}")
    public void addRideToUser(@PathVariable("aid") Long accountId, @PathVariable("rid") Long rideId) {
        accountService.addVehicleToUser(accountId, rideId);
    }
}