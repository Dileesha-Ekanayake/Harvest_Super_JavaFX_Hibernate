import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

@Entity
@Table(name = "gender")
@NamedQueries({
        @NamedQuery(name = "Gender.findAll", query = "SELECT e FROM Gender e"),
        @NamedQuery(name = "Gender.findById", query = "SELECT g FROM Gender g where g.id= :id")

})
public class Gender {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gender", fetch = FetchType.EAGER)
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
    public String toString() {

        return name;
    }

    public boolean equals(Gender obj){
        return obj.id==this.id;
    }
}
