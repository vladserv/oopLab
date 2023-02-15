public class TPerson {
    private final String namePerson;
    private final String surnamePerson;
    private final String patronymicPerson;

    public TPerson(String surname, String name, String patronymic){
        this.surnamePerson = surname.toUpperCase();
        this.namePerson = name.toLowerCase();
        this.patronymicPerson = patronymic.toLowerCase();
    }

    public String getFullData(){return (this.surnamePerson + " " + this.namePerson + " " + this.patronymicPerson);}
}
