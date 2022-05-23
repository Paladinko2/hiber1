package com.Utis;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "uchebnyieplanyi")
public class Uchebnyieplanyi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "KodPlana", nullable = false)
    private Integer id;

    @Column(name = "NomerPlana", nullable = false, length = 10)
    private String nomerPlana;

    @Column(name = "DataUtv", nullable = false)
    private LocalDate dataUtv;

    @Column(name = "Nomer", nullable = false, length = 10)
    private String nomer;

    @Column(name = "Status", length = 50)
    private String status;

    @Column(name = "StatusDate")
    private LocalDate statusDate;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "kodPlana")
    private Gruppyi gruppyis;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomerPlana() {
        return nomerPlana;
    }

    public void setNomerPlana(String nomerPlana) {
        this.nomerPlana = nomerPlana;
    }

    public LocalDate getDataUtv() {
        return dataUtv;
    }

    public void setDataUtv(LocalDate dataUtv) {
        this.dataUtv = dataUtv;
    }

    public String getNomer() {
        return nomer;
    }

    public void setNomer(String nomer) {
        this.nomer = nomer;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getStatusDate() {
        return statusDate;
    }

    public void setStatusDate(LocalDate statusDate) {
        this.statusDate = statusDate;
    }

    public Gruppyi getGruppyis() {
        return gruppyis;
    }

    public void setGruppyis(Gruppyi gruppyis) {
        this.gruppyis = gruppyis;
    }

}