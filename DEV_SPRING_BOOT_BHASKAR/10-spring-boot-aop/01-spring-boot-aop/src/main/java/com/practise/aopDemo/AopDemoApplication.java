package com.practise.aopDemo;

import com.practise.aopDemo.dao.AccountDao;
import com.practise.aopDemo.dao.MembershipDao;
import com.practise.aopDemo.model.Account;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopDemoApplication.class, args);
	}


	@Bean
	public CommandLineRunner runner(AccountDao dao, MembershipDao member){

		return runner ->{
			beforeAdviceAspect(dao, member);
			
		};
	}

	private void beforeAdviceAspect(AccountDao dao, MembershipDao member) {

		Account account=new Account();
		dao.addAccount(account,true);
		dao.doWork();

		member.addSillyMembers();
		member.goingToSleep();
	}

}
