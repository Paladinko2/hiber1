package com.tasks;

import com.Utis.Gruppyi;
import com.Utis.NewHibernateUtil;
import com.Utis.Studentyi;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.Date;
import java.util.List;

public class FirstTask {

    public FirstTask() {
        Session s = NewHibernateUtil.getSessionFactory().openSession();
        Transaction t1 = s.beginTransaction();
        List<Studentyi> q = s.createQuery("from Studentyi s").list();
        for (Studentyi u : q) {
            System.out.print(u.getImya() + "; ");
//            u.setStatusDate(new Date());
            s.saveOrUpdate(u);
        }
        s.flush();
        t1.commit();

        Transaction t2 = s.beginTransaction();

        Query groupQ = s.createQuery("from Gruppyi g where g.nazvanie = :name");
        groupQ.setParameter("name", "ИТ-2");
        Gruppyi gr = (Gruppyi) ((org.hibernate.query.Query<?>) groupQ).list().get(0);

//        Studentyi d = new Studentyi(19555, gr, "Kapytok", "Boris", "Aleksandrovich",
//                "Borisov", "Smolenskaya 30", "421058371",
//                "зачислен", new Date());

//        s.persist(d);

        s.flush();
        t2.commit();

        s.close();
    }
}
