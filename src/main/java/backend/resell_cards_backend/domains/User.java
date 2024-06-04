package backend.resell_cards_backend.domains;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;

import java.util.Objects;


@Entity
public class User {

    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )

    private final Long id;

    @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}",
            flags = Pattern.Flag.CASE_INSENSITIVE)
    private final String email;
    private String password;

    public User(Long id, String email, String password){
        assert !email.isEmpty() && !password.isEmpty();

        this.id = id;
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }
    public String getEmail(){
        return email;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String newPassword) {
        assert !newPassword.isEmpty();

        this.password = newPassword;
    }


}
