package subd.laba5.service;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import subd.laba5.models.Auditoriumtype;

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
            System.out.println("Input Type:");
            String type_a = scanner.next();
            Auditoriumtype auditoriumtype = new Auditoriumtype(type_a);
            session.save(auditoriumtype);
        }
        catch (Exception ex){
            System.out.println(ex);
        }

    }

    private void Read(Session session) {
        List<Auditoriumtype> auditoriumtypes = session.createQuery("SELECT a from Auditoriumtype a", Auditoriumtype.class).getResultList();
        System.out.println(auditoriumtypes);
    }

    private void Update(Session session) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Input id of auditoriumtype:");
            int id = scanner.nextInt();

            System.out.println("Input Type:");
            String type_a  = scanner.next();

            Auditoriumtype auditoriumtype = session.get(Auditoriumtype.class, id);
            auditoriumtype.setType_a(type_a);
            session.save(auditoriumtype);
        }
        catch (Exception ex){
            System.out.println(ex);
        }

    }

    private void Delete(Session session) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Input id of auditoriumtype:");
            int id = scanner.nextInt();
            Auditoriumtype auditoriumtype = session.get(Auditoriumtype.class, id);
            session.delete(auditoriumtype);
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
            List<Auditoriumtype> auditoriumtypes = session.createQuery("SELECT a from Auditoriumtype a WHERE type_a = \'" + names+ "\'", Auditoriumtype.class).getResultList();
            System.out.println(auditoriumtypes);
        }
        catch (Exception ex){
            System.out.println(ex);
        }

    }
}
