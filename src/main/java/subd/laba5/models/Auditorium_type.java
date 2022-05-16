package subd.laba5.models;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "auditorium_type", schema = "public", catalog = "test")
@Getter
@Setter
public class Auditorium_type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_auditorium_type")
    private int id;

    @Column(name = "name")
    private String name;

    public Auditorium_type(String name){
        this.name = name;
    }
    @Override
    public String toString() {
        return "Auditorium_type {" +
                "id= " + id +
                "name='" + name + '\'' +
                "}" + "\n";
    }
}
