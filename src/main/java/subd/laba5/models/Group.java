package subd.laba5.models;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "group", schema = "public", catalog = "test")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Group {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_group")
    private int id;

    @Column(name = "year")
    private int year;
    @Column(name = "name")
    private String name;
    @Column(name = "amount")
    private int amount;

    public Group(int year, String name, int amount){
        this.year = year;
        this.name = name;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Group {" +
                "id= " + id +
                "year='" + year + '\'' +
                "name='" + name + '\'' +
                "amount='" + amount + '\'' +
                "}" + "\n";
    }

}
