package controller;

import java.util.Date;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dao.AccountDao;
import domain.account.Account;



@RequestMapping("/signup")
public class Signup {

	public Account signup(@RequestParam("password") String password, @RequestParam("firstName") String firstName,@RequestParam("lastName") String lastName,@RequestParam("birthday") Date birthday,@RequestParam("email") String email) {
    return new Account();
	}
}