package manager;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AccountManagerMain {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AccountManagerConfig.class);

        var account1 = new Account(1, 1000L);
        var account2 = new Account(2, 2000L);

        var accountDao = applicationContext.getBean(AccountDao.class);
        accountDao.addAccount(account1);
        accountDao.addAccount(account2);

        var phoneToCardResolver = applicationContext.getBean(PhoneToAccountResolver.class);
        var phoneNumber = "1234567";
        phoneToCardResolver.addMapping(phoneNumber, account2);

        var accountService = applicationContext.getBean(AccountService.class);
        accountService.transferByPhoneNumber(account1.getId(), phoneNumber, 500L);

        System.out.println(account1);
        System.out.println(account2);

        accountService.transfer(account1.getId(), account2.getId(), 250L);

        System.out.println(account1);
        System.out.println(account2);

        //accountService.transferByPhoneNumber(account1.getId(), "123", 100L);
    }
}
