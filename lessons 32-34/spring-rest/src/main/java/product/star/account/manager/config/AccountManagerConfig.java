package product.star.account.manager.config;

import java.util.Set;
import product.star.account.manager.AccountDao;
import product.star.account.manager.AccountService;
import product.star.account.manager.BlocklistResolver;
import product.star.account.manager.InMemoryAccountDao;
import product.star.account.manager.InMemoryAccountService;
import product.star.account.manager.InMemoryBlocklistResolver;
import product.star.account.manager.InMemoryPhoneToAccountResolver;
import product.star.account.manager.PhoneToAccountResolver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(PropertiesConfiguration.class)
public class AccountManagerConfig {

    @Value("#{'${blocked.accounts}'.split(',')}")
    private Set<Long> blockedAccounts;

    @Bean
    public AccountDao accountDao() {
        return new InMemoryAccountDao();
    }

    @Bean
    public PhoneToAccountResolver phoneToAccountResolver() {
        return new InMemoryPhoneToAccountResolver();
    }

    @Bean
    public BlocklistResolver blocklistResolver() {
        return new InMemoryBlocklistResolver(
                blockedAccounts
        );
    }

    @Bean
    public AccountService accountService() {
        return new InMemoryAccountService(
                phoneToAccountResolver(),
                accountDao(),
                blocklistResolver()
        );
    }
}
