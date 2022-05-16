package subd.laba5.models;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Table(name = "auditorium", schema = "public", catalog = "test")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Auditorium {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "auditorium_id")
    private int id;

    @Column(name = "seat")
    private int seat;

    @ManyToOne(optional = false, cascade = {CascadeType.REFRESH, CascadeType.PERSIST})
    @JoinColumn(name="auditoriumtype_id")
    private Auditoriumtype auditoriumtype;

    @Column(name = "cabinet")
    private String cabinet;



    public Auditorium (int seat, Auditoriumtype auditoriumtype, String cabinet){
        this.seat = seat;
        this.auditoriumtype = auditoriumtype;
        this.cabinet = cabinet;
    }
    @Override
    public String toString() {
        return "Auditorium {" +
                "id= " + id +
                "seat='" + seat + '\'' +
                "auditoriumtype_id='" + auditoriumtype.getId() + '\'' +
                "cabinet='" + cabinet + '\'' +
                "}" + "\n";
    }

}
