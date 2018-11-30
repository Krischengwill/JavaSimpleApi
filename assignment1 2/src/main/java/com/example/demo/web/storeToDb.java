package com.example.demo.web;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class storeToDb {
    @Id
    @GeneratedValue
    private int id;
    private String str;
    private Integer strInt;

    public storeToDb(String str) {
        this.str = str;
        this.strInt = Integer.parseInt(str);
        this.id = id;
   }

    public Integer getStrInt() {
        return strInt;
    }

    public void setStrInt(Integer strInt) {
        this.strInt = Integer.parseInt(str);
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public int getid() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}


//    @Override
//    public String toString() {
//        return "storeToDb [id=" + id + ", str=" + str + ", strInt=" + strInt + "]";
//    }
//    }

