package com.example.dacn;

public class Contract {
    private String name_department;
    private String phone_number;

//    public Employee(String name, String department) {
//        this.name = name;
//        this.department = department;
//    }

    public String getName() {
        return name_department;
    }

    public void setName(String name_department) {
        this.name_department = name_department;
    }

    public String getPhoneNumber() {
        return phone_number;
    }

    public void setPhoneNumber(String phone_number) {
        this.phone_number = phone_number;
    }
}
