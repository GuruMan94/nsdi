package ge.tsotne.nsdi.controller;

import ge.tsotne.nsdi.model.Contact;
import ge.tsotne.nsdi.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contacts")
public class ContactController {
    private ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping()
    public List<Contact> find(@RequestParam(required = false) String phoneNumber,
                              @RequestParam(required = false) String firstName,
                              @RequestParam(required = false) String lastName) {
        return contactService.findContacts(phoneNumber, firstName, lastName);
    }

    @PostMapping()
    public Contact add(@RequestBody Contact contact) {
        contact.setId(null);
        return contactService.save(contact);
    }

    @PatchMapping("/{id}")
    public Contact update(@PathVariable long id, @RequestBody Contact contact) {
        contact.setId(id);
        return contactService.save(contact);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        contactService.delete(id);
    }
}
