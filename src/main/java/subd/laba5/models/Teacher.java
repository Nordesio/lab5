package subd.laba5.models;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "teacher", schema = "public", catalog = "test")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Teacher {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "serial_t")
    @SequenceGenerator(name="serial_t", sequenceName = "serial_t", allocationSize = 1)
    @Id
    @Column(name = "teacher_id")
    private int id;

    @Column(name = "name")
    private String name;

    public Teacher(String name){
        this.name = name;
    }
    @Override
    public String toString() {
        return "Teacher {" +
                "id= " + id +
                "name='" + name + '\'' +
                "}" + "\n";
    }

}
