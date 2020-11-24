package manager;

public interface AccountService {

    void transfer(long from, long to, long amount);
    void transferByPhoneNumber(long from, String phoneNumber, long amount);

}
