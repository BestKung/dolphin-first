/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.co.geniustree.dental.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Best
 */
@Entity
@Table(name = "DOCTOR")
public class Doctor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "EMAIL", nullable = false)
    @NotBlank(message = "E-mail not Empty")
    @Email(message = "example@example.com")
    private String email;

    @Column(name = "PERSONAL_ID")
    private String pid;

    @Column(name = "NAME_TH", nullable = false)
    @NotBlank(message = "Name(TH) not Empty")
    private String nameTh;

    @Column(name = "NAME_ENG")
    private String nameEng;

    @Column(name = "CER_NO")
    private String cerNo;

    @Column(name = "CER_TYPE")
    private String cerType;

    @Temporal(TemporalType.DATE)
    @Column(name = "BIRTH_DATE")
    private Date birthDate;

    @Column(name = "SEX")
    private String sex;
    @Column(name = "BLOOD")
    private String blood;

    @Column(name = "ADDRESS", nullable = false)
    @NotBlank(message = "Address not Empty")
    private String address;

    @Column(name = "TEL")
    private String tel;

    @Column(name = "MOBILE", nullable = false)
    @NotBlank(message = "Mobile not Empty")
    private String mobile;

    @Column(name = "WORK_STATUS")
    private String workStatus;

    @Column(name = "DETAIL")
    private String detail;

    @OneToOne(cascade = javax.persistence.CascadeType.ALL)
    @JoinColumn(name = "IMAGE_ID" , nullable = true)
    private EmployeeImage employeeImage;
    
    @OneToOne(cascade = javax.persistence.CascadeType.ALL)
    @JoinColumn(name = "BANK_ID", nullable = true)
    private Bank bank;

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

    public String getCerNo() {
        return cerNo;
    }

    public void setCerNo(String serNo) {
        this.cerNo = cerNo;
    }

    public String getCerType() {
        return cerType;
    }

    public void setCerType(String cerType) {
        this.cerType = cerType;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getWorkStatus() {
        return workStatus;
    }

    public void setWorkStatus(String workStatus) {
        this.workStatus = workStatus;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public EmployeeImage getEmployeeImage() {
        return employeeImage;
    }

    public void setEmployeeImage(EmployeeImage employeeImage) {
        this.employeeImage = employeeImage;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
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
        final Doctor other = (Doctor) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    
}
