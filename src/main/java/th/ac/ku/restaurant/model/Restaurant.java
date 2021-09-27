package th.ac.ku.restaurant.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

// @Entity บอก JPA ว่าเป็นตารางในฐานข้อมูล (JPA จะสร้างตารางชื่อ restaurant ให้โดยอัตโนมัติ)
// และให้ map ข้อมูลในตารางมาเป็น object ของคลาสนี้
@Entity
public class Restaurant {

    // @Id บอก JPA ว่าเป็น primary key
    // @GeneratedValue บอก JPA ว่า generate id ให้โดยอัตโนมัติ
    // โดยเลือกวิธีในการ generate ได้ โดยแบบ IDENTITY จะเป็นการสร้าง id
//    @Type(type = "org.hibernate.type.UUIDCharType")
//    @Column(columnDefinition = "CHAR(36)")

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String address;
    private String phone;
    private int numSeats;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getNumSeats() {
        return numSeats;
    }

    public void setNumSeats(int numSeats) {
        this.numSeats = numSeats;
    }

}
