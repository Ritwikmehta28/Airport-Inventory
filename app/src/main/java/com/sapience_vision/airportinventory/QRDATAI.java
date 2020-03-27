package com.sapience_vision.airportinventory;

public class QRDATAI
{
    private String id;
    private String details;
    private String installation;
    private String person;
    private String specification;

    public QRDATAI()
    {

    }

    public void SetInstallationData(String ID, String details, String installation, String person, String specification)
    {
        this.id = ID;
        this.details = details;
        this.installation = installation;
        this.person = person;
        this.specification = specification;
    }



    public String getID() {
        return id;
    }

    public String getDetails() {
        return details;
    }

    public String getInstallation() {
        return installation;
    }

    public String getPerson() {
        return person;
    }

    public String getSpecification() {
        return specification;
    }



    public void setID(String ID) {
        this.id = ID;
    }

    public void setDetails(String details){
        this.details = details;
    }

    public void setInstallation(String installation) {
        this.installation = installation;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }


}
