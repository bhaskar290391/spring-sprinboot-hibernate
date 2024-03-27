package com.practise.aopDemo;

import com.practise.aopDemo.dao.AccountDao;
import com.practise.aopDemo.dao.MembershipDao;
import com.practise.aopDemo.model.Account;
import com.practise.aopDemo.service.FortuneService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AopDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopDemoApplication.class, args);
	}


	@Bean
	public CommandLineRunner runner(AccountDao dao, MembershipDao member, FortuneService service){

		return runner ->{
			//beforeAdviceAspect(dao, member);
			//afterreturningAdvice(dao);

			//afterThrowingAdvice( dao);
			//afterFinallyAdvice( dao);

			aroundAdvice(service);
		};
	}

	private void aroundAdvice(FortuneService service) throws InterruptedException {

		Object result=null;


		try {
			result = service.getFortuneSevice(true);
		}catch (Exception exc){
			System.out.println("The expextion is ==> "+exc);
			//result="Error occured but solution found";
			throw exc;
		}

		System.out.println("The result from Main program is ====>"+result);
	}

	private void afterFinallyAdvice(AccountDao dao) {
		try{
			List<Account> account = dao.findAccount(false);
			System.out.println("Account ==> from afterFinallyAdvice" +account);
		}catch (Exception exc){
			System.out.println("Exception in the afterFinallyAdvice main program ---> "+exc);
		}
	}

	private void afterThrowingAdvice(AccountDao dao) {
		try{
			List<Account> account = dao.findAccount(true);
			System.out.println("Account ==> from afterThrowingAdvice" +account);
		}catch (Exception exc){
			System.out.println("Exception in the main program ---> "+exc);
		}
	}

	private void afterreturningAdvice(AccountDao dao) {
		List<Account> data=dao.findAccount(false);
		System.out.println("Final result ==>"+data);
	}

	private void beforeAdviceAspect(AccountDao dao, MembershipDao member) {

		Account account=new Account();
		dao.addAccount(account,true);
		dao.doWork();

		dao.setServiceCode("Test123");
		dao.setName("Bhaskar");

		dao.getName();
		dao.getServiceCode();

		member.addSillyMembers();
		member.goingToSleep();
	}

}
