package product.star.account.manager.controller;

public class TransactionResponse {
    private final TransactionResult transactionResult;

    public TransactionResponse(TransactionResult transactionResult) {
        this.transactionResult = transactionResult;
    }

    public TransactionResult getTransactionResult() {
        return transactionResult;
    }
}
