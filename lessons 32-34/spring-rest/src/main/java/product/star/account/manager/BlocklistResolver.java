package product.star.account.manager;

public interface BlocklistResolver {

    boolean isBlocklisted(long accountId);
}
