
import java.util.Objects;

public abstract class Account{
    private String id;
    private String password;
    private AccountStatus status;
    private Person person;

    public Account(String id, String password, Person person) {
        this.id = id;
        this.password = password;
        this.person = person;
        this.status = AccountStatus.ACTIVE;
    }
    
    public Account(Account a){
        this(a.id,a.password,a.person);
    }
    
    

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Account other = (Account) obj;
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        return true;
    }
    
    
}
