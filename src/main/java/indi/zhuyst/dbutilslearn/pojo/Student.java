package indi.zhuyst.dbutilslearn.pojo;

/**
 * Created by zhuyst on 2017/5/31.
 */
public class Student {
    private String id;

    private String name;

    private String phone;

    private String email;

    private String dorm;

    private Integer floor;

    private String room;

    public Student(){}

    public Integer getFloor() {
        return floor;
    }

    public String getDorm() {
        return dorm;
    }

    public String getEmail() {
        return email;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getRoom() {
        return room;
    }

    public void setDorm(String dorm) {
        this.dorm = dorm;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public void setRoom(String room) {
        this.room = room;
    }
}
