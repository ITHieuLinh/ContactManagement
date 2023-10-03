package controller;

import Repository.IContactRepository;
import common.Library;
import model.Contact;
import view.Menu;

import java.util.ArrayList;

public class ContactManagement extends Menu<String> {

    private IContactRepository contactRepository;
    static String[] mc = {"Add a contact", "Display all contact", "Delete a Contact", "Exit"};
    Library l;
    ArrayList<Contact> contacts = new ArrayList<>();

    public ContactManagement(IContactRepository contactRepository) {
        super("      Contact program ", mc);
        l = new Library();
        contactRepository = contactRepository;
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                contactRepository.addContact(contacts, 1);
                break;
            case 2:
                contactRepository.getAllContact();
                break;
            case 3:
                contactRepository.deleteContact(n);
                break;
            case 4:
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice");
        }
    }

}
