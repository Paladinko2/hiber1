package com.tasks;

import com.Utis.Gruppyi;
import com.Utis.NewHibernateUtil;
import org.hibernate.Transaction;

import java.util.List;

public class ThirdTask {

    public ThirdTask() {
        org.hibernate.Session s = NewHibernateUtil.getSessionFactory().openSession();
        Transaction t4 = s.beginTransaction();

        List<Gruppyi> k = s.createQuery("from Gruppyi where KodPlana = :kodplana").setParameter("kodplana", 2).list();

        for (Gruppyi gr : k) {
            System.out.println("Номер плана по коду 2: " + gr.getKodPlana().getNomerPlana() + ", Группа: " + gr.getNazvanie());
        }

        s.flush();
        t4.commit();

        s.close();
    }
}
