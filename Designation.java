import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

@Entity
@Table(name = "designation")
@NamedQueries({
        @NamedQuery(name = "Designation.findAll", query = "SELECT e FROM Designation e"),
        @NamedQuery(name = "Designation.findAllById", query = "SELECT d FROM Designation d where d.id= :id")

})
public class Designation {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "designation", fetch = FetchType.EAGER)
    private List<Employee> employees;

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

    @Override
    public String toString(){

        return name;
    }

    public boolean equals(Designation obj){
        return obj.id==this.id;
    }
}

