package com.example.demo.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users",schema = "public")
public class Users {
    @Id
    @GeneratedValue
    private Long userId;

    private String address;
    private String birthday;
    private String name;


    public Users(){}
    public Users(String address,String birthday,String name){
        this.address=address;
        this.birthday=birthday;
        this.name=name;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "Users{" +
                "user_id=" + userId +
                ", address='" + address + '\'' +
                ", birthday='" + birthday + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
