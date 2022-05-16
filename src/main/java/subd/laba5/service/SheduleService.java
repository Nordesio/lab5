package subd.laba5.service;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import subd.laba5.models.*;


import java.util.List;
import java.util.Scanner;
public class SheduleService {
    public void SheduleMenu(SessionFactory sf) {
        System.out.println("Input a number to choose the action:"
                + "\n1) Create" + "\n2) Read" + "\n3) Update" + "\n4) Delete" + "\n5) Filter");
        Scanner scn = new Scanner(System.in);
        int input = scn.nextInt();

        Session session = null;
        session = sf.getCurrentSession();
        session.beginTransaction();

        try {
            switch (input){
                case 1:
                    Create(session);
                    break;
                case 2:
                    Read(session);
                    break;
                case 3:
                    Update(session);
                    break;
                case 4:
                    Delete(session);
                    break;
                case 5:
                    Filter(session);
                    break;
            }
            session.getTransaction().commit();
        }
        catch (Exception ex){
            System.out.println(ex);
        }

    }

    private void Create(Session session) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Input Day:");
            String day = scanner.next();
            System.out.println("Input Number:");
            int number  = scanner.nextInt();
            System.out.println("Input id of group");
            int group_id = scanner.nextInt();
            System.out.println("Input id of discipline");
            int discipline_id = scanner.nextInt();
            System.out.println("Input id of teacher");
            int teacher_id = scanner.nextInt();
            System.out.println("Input id of auditorium");
            int auditorium_id = scanner.nextInt();
            System.out.println("Input Time:");
            String time  = scanner.next();
            Shedule shedule = new Shedule(day, number, session.get(Group.class, group_id), session.get(Discipline.class, discipline_id),
                    session.get(Teacher.class, teacher_id),session.get(Auditorium.class, auditorium_id), time);
            session.save(shedule);
        }
        catch (Exception ex){
            System.out.println(ex);
        }

    }

    private void Read(Session session) {
        List<Auditorium> auditoriums = session.createQuery("SELECT a from Auditorium a", Auditorium.class).getResultList();
        System.out.println(auditoriums);
    }

    private void Update(Session session) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Input id of shedule:");
            int id = scanner.nextInt();
            System.out.println("Input Day:");
            String day = scanner.next();
            System.out.println("Input Number:");
            int number  = scanner.nextInt();
            System.out.println("Input id of group");
            int group_id = scanner.nextInt();
            System.out.println("Input id of discipline");
            int discipline_id = scanner.nextInt();
            System.out.println("Input id of teacher");
            int teacher_id = scanner.nextInt();
            System.out.println("Input id of auditorium");
            int auditorium_id = scanner.nextInt();
            System.out.println("Input Time:");
            String time  = scanner.next();
            Shedule shedule = session.get(Shedule.class, id);
            shedule.setDay(day);
            shedule.setNumber(number);
            shedule.setGroup(session.get(Group.class, group_id));
            shedule.setDiscipline(session.get(Discipline.class, discipline_id));
            shedule.setTeacher(session.get(Teacher.class, teacher_id));
            shedule.setAuditorium(session.get(Auditorium.class, auditorium_id));
            shedule.setTime(time);
            session.save(shedule);
        }
        catch (Exception ex){
            System.out.println(ex);
        }

    }

    private void Delete(Session session) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Input id of shedule:");
            int id = scanner.nextInt();
            Shedule shedule = session.get(Shedule.class, id);
            session.delete(shedule);
        }
        catch (Exception ex){
            System.out.println(ex);
        }

    }

    private void Filter(Session session) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Input group of shedule:");
            int group = scanner.nextInt();
            List<Shedule> shedules = session.createQuery("SELECT s from Shedule s WHERE seat = \'" + group + "\'", Shedule.class).getResultList();
            System.out.println(shedules);
        }
        catch (Exception ex){
            System.out.println(ex);
        }

    }
}
