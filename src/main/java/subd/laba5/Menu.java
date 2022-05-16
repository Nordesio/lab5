package subd.laba5;

import subd.laba5.models.*;
import subd.laba5.service.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.Scanner;
public class Menu {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .addAnnotatedClass(Auditorium.class)
                .addAnnotatedClass(Auditoriumtype.class)
                .addAnnotatedClass(Discipline.class)
                .addAnnotatedClass(Group.class)
                .addAnnotatedClass(Shedule.class)
                .addAnnotatedClass(Teacher.class)
                .buildSessionFactory();

        boolean isMenu = true;
        while(isMenu){
            try {

                System.out.println("\n\nInput a number to work with:"
                        + "\n1) Auditoriums" + "\n2) Auditorium types" + "\n3) Discipline" + "\n4) Groups"
                        + "\n5) Shedules" + "\n6) Teachers" + "\n7)MainRequest"
                        + "\nInput 0 to finish");

                Scanner scn = new Scanner(System.in);
                int input = scn.nextInt();

                switch (input){
                    case 0:
                        isMenu = false;
                        break;
                    case 1:
                        AuditoriumService au = new AuditoriumService();
                        try {
                            au.AuditoriumMenu(sessionFactory);
                        }
                        catch (Exception ex){
                            System.out.println(ex);
                            au.AuditoriumMenu(sessionFactory);
                        }
                        break;
                    case 2:
                        AuditoriumTypeService aut = new AuditoriumTypeService();
                        try {
                            aut.AuditoriumTypeMenu(sessionFactory);
                        }
                        catch (Exception ex){
                            System.out.println(ex);
                            aut.AuditoriumTypeMenu(sessionFactory);
                        }

                        break;
                    case 3:
                        DisciplineService ds = new DisciplineService();
                        try {
                            ds.DisciplineMenu(sessionFactory);
                        }
                        catch (Exception ex){
                            System.out.println(ex);
                            ds.DisciplineMenu(sessionFactory);
                        }

                        break;
                    case 4:
                        GroupService gr = new GroupService();
                        try {
                            gr.GroupMenu(sessionFactory);
                        }
                        catch (Exception ex){
                            System.out.println(ex);
                            gr.GroupMenu(sessionFactory);
                        }

                        break;
                    case 5:
                        SheduleService sd = new SheduleService();
                        try {
                            sd.SheduleMenu(sessionFactory);
                        }
                        catch (Exception ex){
                            System.out.println(ex);
                            sd.SheduleMenu(sessionFactory);
                        }

                        break;
                    case 6:
                        TeacherService tr = new TeacherService();
                        try {
                            tr.TeacherMenu(sessionFactory);
                        }
                        catch (Exception ex){
                            System.out.println(ex);
                            tr.TeacherMenu(sessionFactory);
                        }

                        break;
                    case 7:
                        RequestService rq = new RequestService();
                        try {
                            rq.Request(sessionFactory);
                        }
                        catch (Exception ex){
                            System.out.println(ex);
                            rq.Request(sessionFactory);
                        }

                        break;
                }
            }
            catch (Exception ex){
                System.out.println(ex);
            }
        }
        sessionFactory.close();
    }
}
