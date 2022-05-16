package subd.laba5.models;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "auditoriumtype", schema = "public", catalog = "test")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Auditoriumtype {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "serial_au_type")
    @SequenceGenerator(name="serial_au_type", sequenceName = "serial_au_type", allocationSize = 1)

    @Column(name = "auditoriumtype_id")
    private int id;

    @Column(name = "type_a")
    private String type_a;

    public Auditoriumtype(String type_a){
        this.type_a = type_a;
    }
    @Override
    public String toString() {
        return "Auditoriumtype {" +
                "id= " + id +
                "type='" + type_a + '\'' +
                "}" + "\n";
    }
}
