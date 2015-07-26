/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.co.geniustree.dental.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Best
 */
@Entity
@Table(name = "EMPLOYEE")
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "EMAIL", nullable = false, unique = true)
    @NotBlank(message = "E-mail not Empty")
    @Email(message = "E-mail Incompatible example@example.xom")
    private String email;
    @Column(name = "PASSWORD", nullable = false)
    @NotBlank(message = "Password not Empty")
    private String password;
    @Column(name = "PID", nullable = false)
    @NotBlank(message = "Personal ID not Empty")
    private String pid;
    @Column(name = "NAME_TH", nullable = false)
    @NotBlank(message = "Name(TH) not Empty")
    private String nameTh;
    @Column(name = "NAME_ENG")
    private String nameEng;
    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name = "BIRTH_DATE")
    private Date birthDate;
    @Column(name = "SEX")
    private String sex;
    @Column(name = "BLOOD", nullable = false)
    @NotBlank(message = "Blood not Empty")
    private String blood;
    @Column(name = "MARRY_STATUS")
    private String marryStatus;
    @Column(name = "NATION", nullable = false)
    @NotBlank(message = "Nation not Empty")
    private String nation;
    @Column(name = "RACE", nullable = false)
    @NotBlank(message = "Race not Empty")
    private String race;
    @Column(name = "SOLDER_STATUS")
    private String soldierStatus;
    @Column(name = "ADDRESS_OF_PID")
    private String addressOfPid;
    @Column(name = "CURRENT_ADDRESS", nullable = false)
    @NotBlank(message = "Current Address not Empty")
    private String currentAddress;
    @Column(name = "TEL")
    private String tel;
    @Column(name = "MOBILE", nullable = false)
    @NotBlank(message = "Mobile not Empty")
    private String mobile;
    @Column(name = "START_WORK", nullable = false)
    @NotBlank(message = "Start Work not Empty")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date startWork;
    @Column(name = "END_WORK")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date endWork;
    @Column(name = "WORK_STATUS", nullable = false)
    @NotBlank(message = "Work Satus not Empty")
    private String workStatus;
    @Column(name = "PICTURE")
    private String picture;
    private boolean enable;

    @ManyToOne
    @JoinColumn(name = "DEPARTMENT_ID")
    private Department department;

    @OneToOne
    @JoinColumn(name = "CONTACT_ID")
    private Contact contact;

    @OneToOne
    @JoinColumn(name = "BANK_ID")
    private Bank bank;

    @ManyToMany
    @Column(name = "ROLE")
    private List<Authority> roles;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getNameTh() {
        return nameTh;
    }

    public void setNameTh(String nameTh) {
        this.nameTh = nameTh;
    }

    public String getNameEng() {
        return nameEng;
    }

    public void setNameEng(String nameEng) {
        this.nameEng = nameEng;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBlood() {
        return blood;
    }

    public void setBlood(String blood) {
        this.blood = blood;
    }

    public String getMarryStatus() {
        return marryStatus;
    }

    public void setMarryStatus(String marryStatus) {
        this.marryStatus = marryStatus;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getSoldierStatus() {
        return soldierStatus;
    }

    public void setSoldierStatus(String soldierStatus) {
        this.soldierStatus = soldierStatus;
    }

    public String getAddressOfPid() {
        return addressOfPid;
    }

    public void setAddressOfPid(String addressOfPid) {
        this.addressOfPid = addressOfPid;
    }

    public String getCurrentAddress() {
        return currentAddress;
    }

    public void setCurrentAddress(String currentAddress) {
        this.currentAddress = currentAddress;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Date getStartWork() {
        return startWork;
    }

    public void setStartWork(Date startWork) {
        this.startWork = startWork;
    }

    public Date getEndWork() {
        return endWork;
    }

    public void setEndWork(Date endWork) {
        this.endWork = endWork;
    }

    public String getWorkStatus() {
        return workStatus;
    }

    public void setWorkStatus(String workStatus) {
        this.workStatus = workStatus;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public List<Authority> getRoles() {
        return roles;
    }

    public void setRoles(List<Authority> roles) {
        this.roles = roles;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Employee other = (Employee) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
