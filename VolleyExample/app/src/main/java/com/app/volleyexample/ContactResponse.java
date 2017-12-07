package com.app.volleyexample;

import java.util.List;

/**
 * Created by iSaleem on 12/7/17.
 */

public class ContactResponse {
    private List<Contact> contacts = null;

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }
}
