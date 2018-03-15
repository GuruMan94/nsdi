package ge.tsotne.nsdi.model;

import ge.tsotne.nsdi.service.MyUserService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "contacts")
public class Contact {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    private String phoneNumber;
    @Column(nullable = false)
    private Boolean active;
    @Column(nullable = false,updatable = false)
    private Long userId;

    @PrePersist
    public void prePersist(){
        userId = MyUserService.getUser().getId();
        active = true;
    }
}
