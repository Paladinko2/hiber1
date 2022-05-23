package com.tasks;

import com.Utis.Gruppyi;
import com.Utis.NewHibernateUtil;
import com.Utis.Studentyi;
//import com.Utis.StudentyiStatus;
import com.mysql.cj.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.Date;
import java.util.List;

public class SecondTask {

    public SecondTask() {
        org.hibernate.Session s = NewHibernateUtil.getSessionFactory().openSession();
        Transaction t3 = s.beginTransaction();

        List<Studentyi> studs = s.createQuery("from Studentyi where Status = :status_name").setParameter("status_name", "отчислен").list();

        for (Studentyi stud : studs) {
            System.out.println(stud.getFamiliya() + " " + stud.getImya() + " " + stud.getOtchestvo() + ", Group: " + stud.getGruppyi().getNazvanie() + ", Status: " + stud.getStatus());
        }

        //SQL QUERY: select * from studentyi_status where Status="отчислен" AND StatusDate IN (select MAX(StatusDate) from studentyi_status);

//        List<StudentyiStatus> date = s.createQuery("from StudentyiStatus where Status = :status_name").setParameter("status_name", "отчислен").list();
        List<Studentyi> lastStud = s.createQuery("from Studentyi s where s.statusDate in ( select max(st.statusDate) from Studentyi st where st.status = :status)").setParameter("status", "отчислен").list();

//        Date maxOtchislDate = date.get(0).getId().getStatusDate();

//        for (int i = 0; i < date.size() - 1; i++) {
//            Date temp = date.get(i + 1).getId().getStatusDate();
//            if (temp.after(maxOtchislDate)) {
//                maxOtchislDate = temp;
//            }
//        }
//        System.out.println("Max date is: " + maxOtchislDate);

//        List<Studentyi> lastStud = s.createQuery("from StudentyiStatus where (StatusDate = :status_date and Status = :status_name)").setParameter("status_date", maxOtchislDate).setParameter("status_name", "отчислен").list();

        for (Studentyi st : lastStud) {
            System.out.println("Последний отчисленный студент: " + st.getFamiliya() + " " +  st.getImya() + " " + st.getOtchestvo() + ", Номер зачётки: " + st.getNomerZachetki() + ", Дата отчисления: " + st.getStatusDate());
        }

        s.flush();
        t3.commit();

        s.close();
    }
}
