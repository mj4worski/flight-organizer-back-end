package client;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@ToString(exclude = "password")
@Entity
@Getter @Setter
public class Client {

    @Id
    @GeneratedValue
    private Long id;

    private String login;

    @JsonIgnore
    private String password;

    private String role;

    protected Client() {
    }

}
