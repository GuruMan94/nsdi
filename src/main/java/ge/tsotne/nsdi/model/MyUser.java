package ge.tsotne.nsdi.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="user")
@Data
public class MyUser {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false,unique = true)
    private String userName;
    @Column(nullable = false)
    private String password;
}
