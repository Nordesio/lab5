package subd.laba5.models;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "shedule", schema = "public", catalog = "test")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Shedule {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_shedule")
    private int id;

    @Column(name = "day")
    private String day;

    @Column(name = "number")
    private int number;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name="id_group")
    private Group group;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name="id_discipline")
    private Discipline discipline;
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name="id_teacher")
    private Teacher teacher;
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name="id_auditorium")
    private Auditorium auditorium;

    @Column(name = "time")
    private String time;

    public Shedule (String day, int number, Group group, Discipline discipline, Teacher teacher, Auditorium auditorium, String time) {
        this.day = day;
        this.number = number;
        this.group = group;
        this.discipline = discipline;
        this.teacher = teacher;
        this.auditorium = auditorium;
        this.time = time;
    }

    @Override
    public String toString() {
        return "Shedule {" +
                "id= " + id +
                "day='" + day + '\'' +
                "number='" + number + '\'' +
                "group='" + group.getId() + '\'' +
                "discipline='" + discipline.getId() + '\'' +
                "teacher='" + teacher.getId() + '\'' +
                "auditorium='" + auditorium.getId() + '\'' +
                "time='" + time + '\'' +
                "}" + "\n";
    }
}
