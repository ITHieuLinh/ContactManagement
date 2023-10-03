package controller;

import Repository.ContactRepository;
import Repository.IContactRepository;
import view.Menu;

public class ContactManagement extends Menu<String> {

    private IContactRepository contactRepository;
    static String[] mc = {"Add a contact", "Display all contact", "Delete a Contact", "Exit"};

    public ContactManagement() {
        super("\nContact program", mc);

        contactRepository = new ContactRepository();
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                contactRepository.createContact();
                break;
            case 2:
                contactRepository.printAllContact();
                break;
            case 3:
                contactRepository.deleteContactd();
                break;
            case 4:
                System.exit(0);
        }
    }

}
