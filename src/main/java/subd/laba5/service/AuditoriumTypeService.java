package subd.laba5.service;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import subd.laba5.models.Auditorium_type;

import java.util.List;
import java.util.Scanner;

public class AuditoriumTypeService {
    public void AuditoriumTypeMenu(SessionFactory sf) {
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
            Auditorium_type auditorium_type = new Auditorium_type(name);
            session.save(auditorium_type);
        }
        catch (Exception ex){
            System.out.println(ex);
        }

    }

    private void Read(Session session) {
        List<Auditorium_type> auditorium_types = session.createQuery("SELECT a from Auditorium_type a", Auditorium_type.class).getResultList();
        System.out.println(auditorium_types);
    }

    private void Update(Session session) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Input id of auditorium_type:");
            int id = scanner.nextInt();

            System.out.println("Input Name:");
            String name  = scanner.next();

            Auditorium_type auditorium_type = session.get(Auditorium_type.class, id);
            auditorium_type.setName(name);
            session.save(auditorium_type);
        }
        catch (Exception ex){
            System.out.println(ex);
        }

    }

    private void Delete(Session session) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Input id of auditorium_type:");
            int id = scanner.nextInt();
            Auditorium_type auditorium_type = session.get(Auditorium_type.class, id);
            session.delete(auditorium_type);
        }
        catch (Exception ex){
            System.out.println(ex);
        }

    }

    private void Filter(Session session) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Input name of auditorium_type:");
            String  names = scanner.next();
            List<Auditorium_type> auditorium_types = session.createQuery("SELECT a from Auditorium_type a WHERE name = \'" + names+ "\'", Auditorium_type.class).getResultList();
            System.out.println(auditorium_types);
        }
        catch (Exception ex){
            System.out.println(ex);
        }

    }
}
