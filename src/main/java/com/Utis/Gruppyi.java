package com.Utis;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "gruppyi")
public class Gruppyi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Shifr", nullable = false)
    private Integer id;

    @Column(name = "Nazvanie", nullable = false, length = 50)
    private String nazvanie;

    @Column(name = "DataFormir", nullable = false)
    private LocalDate dataFormir;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "KodPlana", nullable = false)
    private Uchebnyieplanyi kodPlana;

    @Column(name = "Status", length = 50)
    private String status;

    @Column(name = "StatusDate")
    private LocalDate statusDate;

    @OneToMany(mappedBy = "gruppyi")
    private Set<Studentyi> studentyis = new LinkedHashSet<>();

    public Set<Studentyi> getStudentyis() {
        return studentyis;
    }

    public void setStudentyis(Set<Studentyi> studentyis) {
        this.studentyis = studentyis;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNazvanie() {
        return nazvanie;
    }

    public void setNazvanie(String nazvanie) {
        this.nazvanie = nazvanie;
    }

    public LocalDate getDataFormir() {
        return dataFormir;
    }

    public void setDataFormir(LocalDate dataFormir) {
        this.dataFormir = dataFormir;
    }

    public Uchebnyieplanyi getKodPlana() {
        return kodPlana;
    }

    public void setKodPlana(Uchebnyieplanyi kodPlana) {
        this.kodPlana = kodPlana;
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

}