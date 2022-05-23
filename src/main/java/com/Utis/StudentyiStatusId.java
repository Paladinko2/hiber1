package com.Utis;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

@Embeddable
public class StudentyiStatusId implements Serializable {
    private static final long serialVersionUID = -5556754959042888423L;
    @Column(name = "NomerZachetki", nullable = false)
    private Long nomerZachetki;

    @Column(name = "StatusDate", nullable = false)
    private Date statusDate; // was LocalDate

    public Long getNomerZachetki() {
        return nomerZachetki;
    }

    public void setNomerZachetki(Long nomerZachetki) {
        this.nomerZachetki = nomerZachetki;
    }

    public Date getStatusDate() {
        return statusDate;
    } // was LocalDate

    public void setStatusDate(Date statusDate) {
        this.statusDate = statusDate;
    } // was LocalDate

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        StudentyiStatusId entity = (StudentyiStatusId) o;
        return Objects.equals(this.statusDate, entity.statusDate) &&
                Objects.equals(this.nomerZachetki, entity.nomerZachetki);
    }

    @Override
    public int hashCode() {
        return Objects.hash(statusDate, nomerZachetki);
    }

}