package Repository;

import DataAccess.ContactDao;

public class ContactRepository implements IContactRepository {

    @Override
    public void createContact() {
        ContactDao.Instance().createContact();
    }

    @Override
    public void printAllContact() {
        ContactDao.Instance().printAllContact();
    }

    @Override
    public void deleteContactd() {
        ContactDao.Instance().deleteContactd();
    }
}
