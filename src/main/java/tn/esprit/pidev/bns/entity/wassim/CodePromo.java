package tn.esprit.pidev.bns.entity.wassim;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class CodePromo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String code;
    private Double reduction;
    private LocalDate dateFin;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Double getReduction() {
        return reduction;
    }

    public void setReduction(Double reduction) {
        this.reduction = reduction;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }
    @OneToMany(mappedBy = "codePromo", cascade = CascadeType.ALL)
    private List<Chat> chats;

}
