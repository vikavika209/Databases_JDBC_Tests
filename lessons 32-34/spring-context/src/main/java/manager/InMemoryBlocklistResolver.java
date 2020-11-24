package manager;

import java.util.Set;

public class InMemoryBlocklistResolver implements BlocklistResolver {
    private final Set<Long> blockedAccounts;

    public InMemoryBlocklistResolver(Set<Long> blockedAccounts) {
        this.blockedAccounts = blockedAccounts;
    }

    @Override
    public boolean isBlocklisted(long accountId) {
        return blockedAccounts.contains(accountId);
    }
}
