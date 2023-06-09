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
@Table(name = "statusemployee")
@NamedQueries({
        @NamedQuery(name = "Statusemployee.findAll", query = "SELECT e FROM Statusemployee e"),
        @NamedQuery(name = "Statusemployee.findById", query = "SELECT d FROM Statusemployee d where d.id= :id")

})
public class Statusemployee {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "statusemployee", fetch = FetchType.EAGER)
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

    public boolean equals(Statusemployee obj){
        return obj.id==this.id;
    }

}

