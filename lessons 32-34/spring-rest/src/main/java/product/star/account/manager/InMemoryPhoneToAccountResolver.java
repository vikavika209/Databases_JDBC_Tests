package product.star.account.manager;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.springframework.stereotype.Component;

@Component
public class InMemoryPhoneToAccountResolver implements PhoneToAccountResolver {
    private final Map<String, Account> phoneToAccountMapping;

    public InMemoryPhoneToAccountResolver() {
        this.phoneToAccountMapping = new HashMap<>();
    }

    @Override
    public Optional<Account> findAccountByPhoneNumber(String phoneNumber) {
        return Optional.ofNullable(phoneToAccountMapping.get(phoneNumber));
    }

    @Override
    public void addMapping(String phoneNumber, Account account) {
        phoneToAccountMapping.put(phoneNumber, account);
    }

    @Override
    public void removeMapping(String phoneNumber) {
        phoneToAccountMapping.remove(phoneNumber);
    }
}
