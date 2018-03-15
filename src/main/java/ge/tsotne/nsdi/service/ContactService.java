package ge.tsotne.nsdi.service;

import ge.tsotne.nsdi.model.Contact;
import ge.tsotne.nsdi.model.Contact_;
import ge.tsotne.nsdi.model.User;
import ge.tsotne.nsdi.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Predicate;
import java.util.List;
import java.util.Optional;

@Service
public class ContactService {
    private ContactRepository contactRepository;

    @Autowired
    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public List<Contact> findContacts(String phoneNumber,
                                      String firstName,
                                      String lastName) {
        User myUser = MyUserService.getUser();
        return contactRepository.findAll((root, query, cb) -> {
            Predicate p = cb.conjunction();
            if (!StringUtils.isEmpty(phoneNumber)) {
                p = cb.and(p,cb.equal(root.get(Contact_.phoneNumber),phoneNumber));
            }

            if (!StringUtils.isEmpty(firstName)) {
                p = cb.and(p,cb.like(root.get(Contact_.firstName),firstName+'%'));
            }
            if (!StringUtils.isEmpty(lastName)) {
                p = cb.and(p,cb.like(root.get(Contact_.lastName),lastName+'%'));
            }
            p = cb.and(p,cb.equal(root.get(Contact_.active),true));
            p = cb.and(p,cb.equal(root.get(Contact_.userId),myUser.getId()));
            return p;
        });
    }

    public Contact save(Contact contact) {
        return contactRepository.save(contact);
    }

    public void delete(long id) {
        Optional<Contact> contact = contactRepository.findById(id);
        contact.ifPresent(c->{
            c.setActive(false);
            contactRepository.save(c);
        });
    }
}
