package subd.laba5.service;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import subd.laba5.models.Auditorium;
import subd.laba5.models.Auditorium_type;

import java.util.List;
import java.util.Scanner;
public class AuditoriumService {
    public void AuditoriumMenu(SessionFactory sf) {
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
            System.out.println("Input Seat:");
            int seat = scanner.nextInt();
            System.out.println("Input Cabinet:");
            String cabinet  = scanner.next();
            System.out.println("Input id of auditorium type");
            int auditorium_type_id = scanner.nextInt();
            Auditorium auditorium = new Auditorium(seat, cabinet, session.get(Auditorium_type.class, auditorium_type_id));
            session.save(auditorium);
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
            System.out.println("Input id of auditorium:");
            int id = scanner.nextInt();
            System.out.println("Input Seat:");
            int seat = scanner.nextInt();
            System.out.println("Input Cabinet:");
            String cabinet  = scanner.next();
            System.out.println("Input id of auditorium type");
            int auditorium_type_id = scanner.nextInt();
            Auditorium auditorium = session.get(Auditorium.class, id);
            auditorium.setSeat(seat);
            auditorium.setCabinet(cabinet);
            auditorium.setAuditorium_type(session.get(Auditorium_type.class, auditorium_type_id));
            session.save(auditorium);
        }
        catch (Exception ex){
            System.out.println(ex);
        }

    }

    private void Delete(Session session) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Input id of auditorium:");
            int id = scanner.nextInt();
            Auditorium auditorium = session.get(Auditorium.class, id);
            session.delete(auditorium);
        }
        catch (Exception ex){
            System.out.println(ex);
        }

    }

    private void Filter(Session session) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Input seat of auditorium:");
            int seats = scanner.nextInt();
            List<Auditorium> auditoriums = session.createQuery("SELECT a from Auditorium a WHERE seat = \'" + seats + "\'", Auditorium.class).getResultList();
            System.out.println(auditoriums);
        }
        catch (Exception ex){
            System.out.println(ex);
        }

    }
}
