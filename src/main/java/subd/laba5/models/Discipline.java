package subd.laba5.models;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.sql.Date;
@Entity
@Table(name = "discipline", schema = "public", catalog = "test")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Discipline {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "discipline_id")
    private int id;

    @Column(name = "name")
    private String name;


    public Discipline(String name){
        this.name = name;
    }
    @Override
    public String toString() {
        return "Discipline {" +
                "id= " + id +
                "name='" + name + '\'' +
                "}" + "\n";
    }

}
