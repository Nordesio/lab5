package subd.laba5.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import subd.laba5.models.Group;


import java.util.List;
import java.util.Scanner;

public class GroupService {
    public void GroupMenu(SessionFactory sf) {
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
            System.out.println("Input Year:");
            int year = scanner.nextInt();
            System.out.println("Input Name:");
            String name  = scanner.next();
            System.out.println("Input Amount");
            int amount = scanner.nextInt();
            Group group = new Group(year, name, amount);
            session.save(group);
        }
        catch (Exception ex){
            System.out.println(ex);
        }

    }

    private void Read(Session session) {
        List<Group> groups = session.createQuery("SELECT g from Group g", Group.class).getResultList();
        System.out.println(groups);
    }

    private void Update(Session session) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Input id of group:");
            int id = scanner.nextInt();
            System.out.println("Input Year:");
            int year = scanner.nextInt();
            System.out.println("Input Name:");
            String name  = scanner.next();
            System.out.println("Input Amount");
            int amount = scanner.nextInt();
            Group group = session.get(Group.class, id);
            group.setYear(year);
            group.setName(name);
            group.setAmount(amount);
            session.save(group);
        }
        catch (Exception ex){
            System.out.println(ex);
        }

    }

    private void Delete(Session session) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Input id of group:");
            int id = scanner.nextInt();
            Group group = session.get(Group.class, id);
            session.delete(group);
        }
        catch (Exception ex){
            System.out.println(ex);
        }

    }

    private void Filter(Session session) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Input year of group:");
            int years = scanner.nextInt();
            List<Group> groups = session.createQuery("SELECT g from Group g WHERE year = \'" + years + "\'", Group.class).getResultList();
            System.out.println(groups);
        }
        catch (Exception ex){
            System.out.println(ex);
        }

    }
}
