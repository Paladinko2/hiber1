package com.tasks;

import com.Utis.Gruppyi;
import com.Utis.NewHibernateUtil;
import com.Utis.Studentyi;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;

public class FourthTask {

    public FourthTask() {
        org.hibernate.Session s = NewHibernateUtil.getSessionFactory().openSession();
        Transaction t = s.beginTransaction();

        Integer lessThan = 5;

        List<Gruppyi> grs = s.createQuery("from Gruppyi").list();
        for (Gruppyi gruppyi : grs) {
            System.out.println("Size of " + gruppyi.getNazvanie() + " is: " + gruppyi.getStudentyis().size() + "; Year: " + gruppyi.getDataFormir().getYear());
        }

        List<Gruppyi> gruppyis = s.createQuery("from Gruppyi g").list();
        for (int i = 0; i < gruppyis.size(); i++) {
            for (int j = 0; j < gruppyis.size(); j++) {
                if (gruppyis.get(i).getDataFormir().getYear() == gruppyis.get(j).getDataFormir().getYear() && i != j) {
                    if (gruppyis.get(i).getStudentyis().size() + gruppyis.get(j).getStudentyis().size() < lessThan) {
                        System.out.println("Группы для объединения: " + gruppyis.get(i).getNazvanie() + ", " + gruppyis.get(i).getStudentyis().size() + "чел. и " + gruppyis.get(j).getNazvanie() + ", " + gruppyis.get(j).getStudentyis().size() + "чел." );
                        gruppyis.get(i).getStudentyis().addAll(gruppyis.get(j).getStudentyis());
                        for (Studentyi studentyi : gruppyis.get(j).getStudentyis()){
                            studentyi.setGruppyi(gruppyis.get(i));
                            s.saveOrUpdate(studentyi);
                        }
                        s.saveOrUpdate(gruppyis.get(i));
                        s.delete(gruppyis.get(j));
                        System.out.println("Группы объединены в " + gruppyis.get(i).getNazvanie() + " c количеством учащихся: " + gruppyis.get(i).getStudentyis().size());
                    }
                }
            }
        }

        s.flush();
        t.commit();

        s.close();
    }

}
