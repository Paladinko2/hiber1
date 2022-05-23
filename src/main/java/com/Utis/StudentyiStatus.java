package com.Utis;

import javax.persistence.*;

@Entity
@Table(name = "studentyi_status")
public class StudentyiStatus {
    @EmbeddedId
    private StudentyiStatusId id;

    @MapsId("nomerZachetki") // использование одного первичного ключа для разных таблиц
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "NomerZachetki", nullable = false)
    private Studentyi nomerZachetki;

    @Column(name = "Status", length = 50)
    private String status;

    public StudentyiStatusId getId() {
        return id;
    }

    public void setId(StudentyiStatusId id) {
        this.id = id;
    }

    public Studentyi getNomerZachetki() {
        return nomerZachetki;
    }

    public void setNomerZachetki(Studentyi nomerZachetki) {
        this.nomerZachetki = nomerZachetki;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}