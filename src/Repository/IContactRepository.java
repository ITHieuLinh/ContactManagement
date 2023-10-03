package Repository;

import java.util.ArrayList;
import java.util.List;
import model.Contact;


public interface IContactRepository {

    void addContact(ArrayList<Contact> contacts, int type);

    void deleteContact(int contactId);

    List<Contact> getAllContact();

    Contact getContactById(int contactId);

}
