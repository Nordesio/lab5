package subd.laba5.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import subd.laba5.models.*;
import java.util.List;
import java.util.Scanner;
public class MainSQLRequestLogic {
    public void work (SessionFactory sessionFactory) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        List<Shedule> shedules = session.createQuery("SELECT s FROM Shedule s",
                Shedule.class).getResultList();
        System.out.println("~Shedules~");
        for (int i = 0; i < shedules.size(); i++) {
            System.out.format("\n%s\t\t\t%s\t\t\t%s\t\t\t%s\t\t\t%s\t\t\t%s\t\t\t%s", shedules.get(i).getDay().toString(),
                    shedules.get(i).getNumber(), shedules.get(i).getGroup(),shedules.get(i).getDiscipline(),
                    shedules.get(i).getTeacher(),shedules.get(i).getAuditorium(),shedules.get(i).getTime());
        }
        session.getTransaction().commit();
    }
}
