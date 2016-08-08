package com.bbayar.usingsugarorm;

import com.orm.SugarRecord;

public class Contact extends SugarRecord {

    String name;
    String mail;

    public Contact() {
    }

    public Contact(String name, String mail) {
        this.name = name;
        this.mail = mail;
    }

    @Override
    public String toString() {
        return String.format("Contact{name=%s, mail=%s}\n", name, mail);
    }
}
