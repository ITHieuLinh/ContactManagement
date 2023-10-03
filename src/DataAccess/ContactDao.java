package DataAccess;

import common.Library;
import common.Validation;
import java.util.ArrayList;

import model.Contact;

public class ContactDao {

    Library l;
    Validation valid;
    ArrayList<Contact> list;
    private static ContactDao instance = null;

    public ContactDao() {
        l = new Library();
        valid = new Validation();
        list = new ArrayList<>();
    }

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

    public void createContact() {
        int contactId = generateID();
        String name = l.inputString("Enter Name: ");
        String group = l.inputString("Enter group: ");
        String address = l.inputString("Enter address: ");
        String phone = l.inputString("Enter phone: ");
        while (!valid.checkInputPhone(phone)) {
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

        list.add(new Contact(contactId, name, group, address, phone, firstName, lastName));
        System.out.println("Add successful!!!");
    }

    public void printAllContact() {
        if (list.isEmpty()) {
            System.out.println("Empty!!!");
        } else {
            System.out.printf("%-5s%-25s%-20s%-20s%-20s%-20s%-20s\n", "Id", "Name", "First name", "Last name", "Group", "Address", "Phone");

            for (Contact contact : list) {
                System.out.printf("%-5d%-25s%-20s%-20s%-20s%-20s%-20s\n", contact.getContactId(), contact.getFullName(),
                        contact.getFirstName(), contact.getLastName(),
                        contact.getGroup(), contact.getAddress(), contact.getPhone());
            }
        }
    }

    public void deleteContactd() {
        if (list.isEmpty()) {
            System.out.println("Empty!!!");
            return;
        }
        int idDelete = l.getInt("Enter id: ", 1, list.size() + 1);
        ArrayList<Contact> contactDelete = getContactById(list, idDelete);
        list.removeAll(contactDelete);
        System.err.println("Delete successful.");
    }

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
