package manager;

public interface BlocklistResolver {

    boolean isBlocklisted(long accountId);
}
