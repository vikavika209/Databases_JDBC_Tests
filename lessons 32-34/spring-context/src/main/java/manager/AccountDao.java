package manager;

import java.util.Optional;

public interface AccountDao {

    void addAccount(Account account);
    Optional<Account> findAccount(long accountId);
    Account getAccount(long  accountId);
    void setAmount(long accountId, long amount);
}
