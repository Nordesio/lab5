package subd.laba5.models;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "auditorium", schema = "public", catalog = "test")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Auditorium {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_auditorium")
    private int id;

    @Column(name = "seat")
    private int seat;

    @Column(name = "cabinet")
    private String cabinet;

    @ManyToOne(optional = false, cascade = {CascadeType.REFRESH, CascadeType.PERSIST})
    @JoinColumn(name="id_auditorium_type")
    private Auditorium_type auditorium_type;

    public Auditorium (int seat, String cabinet, Auditorium_type auditorium_type){
        this.seat = seat;
        this.cabinet = cabinet;
        this.auditorium_type = auditorium_type;
    }

    @Override
    public String toString() {
        return "Auditorium {" +
                "id= " + id +
                "seat='" + seat + '\'' +
                "cabinet='" + cabinet + '\'' +
                "auditorium_type_id='" + auditorium_type.getId() + '\'' +
                "}" + "\n";
    }

}
