package cn.edu.nju.rm.model;

/**
 * @author wangxue
 */
public class Account {

    private String uid;

    private String name;

    private String telephone;

    private String password;

    private String email;

    private String introduction;

    private String occupation;


    public Account(String uid, String password){
        this.uid = uid;
        this.password = password;
    }

    public Account(String uid, String password, String name, String telephone,
                   String email, String occupation, String introduction){
        this.uid = uid;
        this.password = password;
        this.name = name;
        this.telephone = telephone;
        this.password = password;
        this.email = email;
        this.occupation = occupation;
        this.introduction = introduction;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid == null ? null : uid.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation == null ? null : occupation.trim();
    }
}