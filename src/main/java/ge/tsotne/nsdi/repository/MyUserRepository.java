package ge.tsotne.nsdi.repository;

import ge.tsotne.nsdi.model.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyUserRepository extends JpaRepository<MyUser,Long> {
	MyUser getByUsername(String username);
}
