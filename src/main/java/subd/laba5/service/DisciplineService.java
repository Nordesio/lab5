package subd.laba5.service;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import subd.laba5.models.Discipline;

import java.util.List;
import java.util.Scanner;
public class DisciplineService {
    public void DisciplineMenu(SessionFactory sf) {
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
            System.out.println("Input Name:");
            String name = scanner.next();
            Discipline discipline = new Discipline(name);
            session.save(discipline);
        }
        catch (Exception ex){
            System.out.println(ex);
        }

    }

    private void Read(Session session) {
        List<Discipline> disciplines = session.createQuery("SELECT d from Discipline d", Discipline.class).getResultList();
        System.out.println(disciplines);
    }

    private void Update(Session session) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Input id of discipline:");
            int id = scanner.nextInt();

            System.out.println("Input Name:");
            String name  = scanner.next();

            Discipline discipline = session.get(Discipline.class, id);
            discipline.setName(name);
            session.save(discipline);
        }
        catch (Exception ex){
            System.out.println(ex);
        }

    }

    private void Delete(Session session) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Input id of discipline:");
            int id = scanner.nextInt();
            Discipline discipline = session.get(Discipline.class, id);
            session.delete(discipline);
        }
        catch (Exception ex){
            System.out.println(ex);
        }

    }

    private void Filter(Session session) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Input name of discipline:");
            String names = scanner.next();
            List<Discipline> disciplines = session.createQuery("SELECT d from Discipline a WHERE name = \'" + names+ "\'", Discipline.class).getResultList();
            System.out.println(disciplines);
        }
        catch (Exception ex){
            System.out.println(ex);
        }

    }
}
