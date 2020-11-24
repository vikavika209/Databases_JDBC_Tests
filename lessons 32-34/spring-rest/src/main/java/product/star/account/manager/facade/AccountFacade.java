package product.star.account.manager.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import product.star.account.manager.AccountDao;
import product.star.account.manager.AccountService;
import product.star.account.manager.controller.AccountDto;
import product.star.account.manager.controller.TransactionDto;
import product.star.account.manager.controller.TransactionResponse;
import product.star.account.manager.controller.TransactionResult;

@Service
public class AccountFacade {

    private final AccountDao accountDao;
    private final AccountService accountService;

    @Autowired
    public AccountFacade(AccountDao accountDao, AccountService accountService) {
        this.accountDao = accountDao;
        this.accountService = accountService;
    }

    public AccountDto createAccount(long amount) {
        var account = accountDao.addAccount(amount);
        return new AccountDto(account);
    }

    public AccountDto getAccount(long accountId) {
        var account = accountDao.getAccount(accountId);
        return new AccountDto(account);
    }

    public TransactionResponse transfer(TransactionDto transactionDto) {
        accountService.transfer(
                transactionDto.getFromId(),
                transactionDto.getToId(),
                transactionDto.getAmount()
        );
        return new TransactionResponse(TransactionResult.SUCCESS);
    }
}
