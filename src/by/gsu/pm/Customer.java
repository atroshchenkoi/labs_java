package by.gsu.pm;

public class Customer implements Comparable<Customer> {

    private int id;
    private String surname;
    private String name;
    private String patronymic;
    private String address;
    private long cardNumber;
    private long accountNumber;

    public Customer(int id, String surname, String name, String patronymic, String address, long cardNumber, long accountNumber) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.address = address;
        this.cardNumber = cardNumber;
        this.accountNumber = accountNumber;
        this.patronymic = patronymic;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Override
    public String toString() {
        return id + " " + surname + " " + name + " " + patronymic  + ", адрес: " + address  + ", номер карты: " + cardNumber + ", номер аккаунта: " + accountNumber;
    }

    @Override
    public int compareTo(Customer o) {
        if (this.getSurname().compareTo(o.getSurname()) != 0) {
            return this.getSurname().compareTo(o.getSurname());
        }
        if (this.getName().compareTo(o.getName()) != 0) {
            return this.getName().compareTo(o.getName());
        }
        return this.getPatronymic().compareTo(o.getPatronymic());
    }
}

