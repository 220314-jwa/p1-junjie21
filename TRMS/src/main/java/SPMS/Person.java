package SPMS;

import java.util.List;
import java.util.ArrayList;

public class Person {
    private String firstName;
    private String lastName;
    private int role_id;
    private List<Genre> genre;

    // Constructor sets everything to default values
    public Person() {
        firstName = "";
        lastName = "";
        role_id = 0;
        genre = new ArrayList<>();       // use arraylist to store data faster
    }

    public int getRole_id() {
        return role_id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    @Override
    public int hashCode(){
        final int prime = 31;
        int result = 1;
        result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
        result = prime * result + ((lastName == null ) ? 0 : lastName.hashCode());
        result = prime * result + role_id;
        return result;
    }

    @Override
    // Checking if user enter valid input
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Person other = (Person) obj;
        if (firstName == null) {
            return false;
        } else if (!firstName.equals(other.firstName)) {
            return false;
        }
        if(role_id != other.role_id)
            return false;
        if(lastName == null){
            if(other.lastName != null)
                return false;
        }else if(!lastName.equals(other.lastName))
            return false;

        return true;
    }

}
