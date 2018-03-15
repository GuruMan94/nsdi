package ge.tsotne.nsdi.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="users")
@Data
public class MyUser {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false,unique = true)
    private String username;
    @Column(nullable = false)
    private String password;
    private Boolean active;
}
