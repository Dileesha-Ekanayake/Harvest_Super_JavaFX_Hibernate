import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

@Entity
@Table(name = "employee")
@NamedQueries({
        @NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e"),
        @NamedQuery(name = "Employee.findAllByNic", query = " SELECT e FROM Employee e WHERE e.nic like :nic"),
        @NamedQuery(name = "Employee.findAllByName", query = " SELECT e FROM Employee e WHERE e.name like :name"),
        @NamedQuery(name = "Employee.findAllByGender", query = " SELECT e FROM Employee e WHERE e.gender = :gender"),
        @NamedQuery(name = "Employee.findAllByDesignation", query = " SELECT e FROM Employee e WHERE e.designation = :designation"),
        @NamedQuery(name = "Employee.findAllByNameGender", query = " SELECT e FROM Employee e WHERE e.gender = :gender and e.name like :name"),
        @NamedQuery(name = "Employee.findAllByGenderDesignation", query = " SELECT e FROM Employee e WHERE e.gender = :gender and e.designation = :designation"),
        @NamedQuery(name = "Employee.findAllByNameDesignation", query = " SELECT e FROM Employee e WHERE e.designation = :designation and e.name like :name"),
        @NamedQuery(name = "Employee.findAllByNameGenderDesignation", query = " SELECT e FROM Employee e WHERE e.gender = :gender and e.designation = :designation and e.name like :name")
})

public class Employee {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    @Patern(regexp = "^[A-Z][a-z]*$")
    public String name;

    @Column(name = "dob", columnDefinition = "date")
    private LocalDate dob;

    @Column(name = "nic", columnDefinition = "char")
    @Patern(regexp = "^([0-9]{9}[x|X|v|V]|[0-9]{12})$")
    public String nic;

    @Column(name = "mobile", columnDefinition = "char")
    @Patern(regexp = "^0[0-9]{9}$")
    public String mobile;

    @Column(name = "email")
    @Patern(regexp = "^[a-z]*@[a-z]*.[a-z]*$")
    public String email;

    // @JoinColumn(name = "gender_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Gender gender;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Designation designation;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Statusemployee statusemployee;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getNic() {
        return nic;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getMobile() {
        return mobile;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Gender getGender() {
        return gender;
    }

    public void setDesignation(Designation designation) {
        this.designation = designation;
    }

    public Designation getDesignation() {
        return designation;
    }

    public void setStatusemployee(Statusemployee statusemployee) {
        this.statusemployee = statusemployee;
    }

    public Statusemployee getStatusemployee() {
        return statusemployee;
    }

}