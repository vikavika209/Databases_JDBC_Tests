package product.star.account.manager.controller;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TransactionDto {

    @JsonProperty("fromId")
    private long fromId;
    @JsonProperty("toId")
    private long toId;
    @JsonProperty("amount")
    private long amount;

    public long getFromId() {
        return fromId;
    }

    public void setFromId(long fromId) {
        this.fromId = fromId;
    }

    public long getToId() {
        return toId;
    }

    public void setToId(long toId) {
        this.toId = toId;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }
}
