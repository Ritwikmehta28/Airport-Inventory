package com.sapience_vision.airportinventory;

public class QRDATAS {
    private String Maintainname;
    private String PersonM;
    private String details1;
    private String details2;

    public QRDATAS()
    {

    }

    public QRDATAS(String maintainname, String personM, String details1, String details2) {
        this.Maintainname = maintainname;
        this.PersonM = personM;
        this.details1 = details1;
        this.details2 = details2;
    }

    public String getMaintainname() {
        return Maintainname;
    }

    public String getPersonM() {
        return PersonM;
    }

    public String getDetails1() {
        return details1;
    }

    public String getDetails2() {
        return details2;
    }

    public void setMaintainname(String maintainname) {
        Maintainname = maintainname;
    }

    public void setPersonM(String personM) {
        PersonM = personM;
    }

    public void setDetails1(String details1) {
        this.details1 = details1;
    }

    public void setDetails2(String details2) {
        this.details2 = details2;
    }
}
