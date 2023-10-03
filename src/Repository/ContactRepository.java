package Repository;

import DataAccess.ContactDao;
import java.util.ArrayList;
import java.util.List;
import model.Contact;

public class ContactRepository implements IContactRepository {

    private List<Contact> contact;

    public ContactRepository() {
        this.contact = new ArrayList<>();
    }

    @Override
    public void addContact(ArrayList<Contact> contacts, int type) {
        ContactDao.Instance().createContact(contacts, type);
    }

    @Override
    public void deleteContact(int contactId) {
        contact.removeIf(contact -> contact.getContactId() == contactId);
    }

    @Override
    public List<Contact> getAllContact() {
        return contact;
    }

    @Override
    public Contact getContactById(int contactId) {
        for (Contact c : contact) {
            if (c.getContactId() == contactId) {
                return c;
            }
        }
        return null;
    }
}
