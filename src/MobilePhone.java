import java.util.ArrayList;

public class MobilePhone {
    private String myNumber;
    private ArrayList<Contacts> myContacts;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<Contacts>();
    }


    public boolean addNewContact(Contacts contacts){

        if(findContact(contacts.getContactName())>=0){
            System.out.println("Contact already exists.");
            return false;
        }

        /**
         * Here we are adding a new contact. findContact() method is the method we can use to traverse the list of contacts by names and returns
         * the position of the contact.
         */
        myContacts.add(contacts);
        return true;

    }


    public boolean updateContact(Contacts oldContact, Contacts newContact){
        int contactPosition= findContact(oldContact);
        if(findContact(oldContact.getContactName())<0){
            System.out.println("This contact is not found");
            return false;

        }
        this.myContacts.set(contactPosition,oldContact);
        System.out.println(oldContact.getContactName()+" was replaced by "+newContact.getContactName());

        return true;
    }

    //This method can be used to find the contact by returning its index.
    private int findContact(Contacts contacts){
        return this.myContacts.indexOf(contacts);
    }


    /**
     * This method compares the name using equals method and returns the position of the contact name in an arraylist.
     * @param contactName
     * @return
     */
    private int findContact(String contactName){
        for(int i=0;i<myContacts.size();i++){
            Contacts contacts= this.myContacts.get(i);
            if(contactName.equals(contacts)){
                return i;
            }
        }
        return -1;
    }


public boolean removeContact(Contacts contact){
        int foundPosition=findContact(contact);
        if(foundPosition<0){
            System.out.println("Contact is not on the phone.");
            return false;
        }
        this.myContacts.remove(foundPosition);
        System.out.println(contact.getContactName()+" has been removed.");
        return true;

}

    /**
     * This method queries the arraylist and returns the position of the contact.
     * @param name
     * @return
     */
    public Contacts queryContact(String name){
        int position= findContact(name);
        if(position>=0){
            return this.myContacts.get(position);
        }
        return null;

}

public void printContacts(){
    System.out.println("Contact list:");
    for(int i=0;i<myContacts.size();i++){
        System.out.println(i+1+"."+this.myContacts.get(i).getContactName()+" -> "+this.myContacts.get(i).getPhoneNumber());
    }

    }

}