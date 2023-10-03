package DataAccess;

import common.Library;
import common.Validation;
import java.util.ArrayList;

import model.Contact;

public class ContactDao {

    Library l = new Library();
    Validation v = new Validation();
    ArrayList<Contact> list = new ArrayList<>();
    private static ContactDao instance = null;

    public static ContactDao Instance() {
        if (instance == null) {
            synchronized (ContactDao.class) {
                if (instance == null) {
                    instance = new ContactDao();
                }
            }
        }
        return instance;
    }

    public void createContact(ArrayList<Contact> contacts, int type) {
        int contactId = generateID();
        String name = l.inputString("Enter Name: ");
        String group = l.inputString("Enter group: ");
        String address = l.inputString("Enter address: ");
        String phone = l.inputString("Enter phone: ");
        while (!v.checkInputPhone(phone)) {
            phone = l.inputString("Enter again: ");
        }
        String[] strSplit = name.split("\\s");
        String firstName = null;
        String lastName = null;
        try {
            firstName = strSplit[0];
            lastName = strSplit[1];
        } catch (Exception e) {
            lastName = "  ";
        }

        list.add(new Contact(contactId, name, group, address,
                phone, firstName, lastName));
        System.err.println("Add successful.");
    }

    //allow user display all contact
    public void printAllContact(ArrayList<Contact> lc) {
        if (lc.isEmpty()) {
            System.out.println("Empty");
        } else {
            System.out.printf("%-5s%-25s%-20s%-20s%-20s%-20s%-20s\n", "Id", "Name",
                    "First name", "Last name", "Group", "Address", "Phone");
            //print infomation of contact from first to last list contact
            for (Contact contact : lc) {
                System.out.printf("%-5d%-25s%-20s%-20s%-20s%-20s%-20s\n",
                        contact.getContactId(), contact.getFullName(),
                        contact.getFirstName(), contact.getLastName(),
                        contact.getGroup(), contact.getAddress(), contact.getPhone());
            }
        }
    }

    //allow user delete contact
    public void deleteContactd(ArrayList<Contact> lc) {
        if (lc.isEmpty()) {
            System.out.println("Empty");
            return;
        }
        int idDelete = l.getInt("Enter id: ", 1, list.size() + 1);
        ArrayList<Contact> contactDelete = getContactById(lc, idDelete);
        lc.removeAll(contactDelete);
        System.err.println("Delete successful.");
    }

    //get contact by id
    public ArrayList<Contact> getContactById(ArrayList<Contact> lc, int idDelete) {
        ArrayList<Contact> listContactById = new ArrayList<>();
        for (Contact contact : lc) {
            if (contact.getContactId() == idDelete) {
                listContactById.add(contact);
            }
        }
        return listContactById;
    }

    public int generateID() {
        int id = 0;
        if (list.isEmpty()) {
            return 1;
        } else {

            for (Contact s : list) {
                if (s.getContactId() == list.size()) {
                    id = s.getContactId() + 1;
                }
            }
        }
        return id;
    }
}
