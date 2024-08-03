package unah.lenguajes.examen.modelos;

import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "prestamos")
@Data
public class prestamos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigoprestamo")
    private int codigoPrestamo;

    @Column(name = "fechaapertura")
    private Date fechaApertura;

    @Column(name = "monto")
    private double monto;

    @Column(name = "cuota")
    private double cuota;

    @Column(name = "plazo")
    private int plazo;

    @Column(name = "interes")
    private double interes;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "dni", referencedColumnName = "dni")
    private cliente cliente;

    @OneToMany(mappedBy = "prestamos", cascade = CascadeType.ALL)
    private List<cuotas> cuotas;
}
