package product.star.account.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import product.star.account.manager.facade.AccountFacade;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final AccountFacade accountFacade;

    @Autowired
    public AccountController(AccountFacade accountFacade) {
        this.accountFacade = accountFacade;
    }

    @PostMapping
    public AccountDto createAccount(
            @RequestParam long amount
    ) {
        return accountFacade.createAccount(amount);
    }

    @GetMapping("/{accountId}")
    public AccountDto getAccount(
            @PathVariable long accountId
    ) {
        return accountFacade.getAccount(accountId);
    }

    @PostMapping("/transfers")
    public TransactionResponse transfer(
            @RequestBody TransactionDto transactionDto
    ) {
        return accountFacade.transfer(transactionDto);
    }


}
