package blacar.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import blacar.domain.account.Account;
import blacar.repository.AccountRepository;
import blacar.repository.RideRepository;
import blacar.service.AccountService;



@RestController
@RequestMapping("/api/account")
public class AccountApi {

	@Autowired
	AccountService accountService;
	
	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	RideRepository rideRepository;
	
	
	@GetMapping("{id}")
    public Account find(@PathVariable("id") Long accountId) {
        return accountRepository.findOne(accountId);
    }

    @GetMapping
    public Iterable<Account> findAll() {
        return accountRepository.findAll();
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
        accountService.addRideToUser(accountId, rideId);
    }
}