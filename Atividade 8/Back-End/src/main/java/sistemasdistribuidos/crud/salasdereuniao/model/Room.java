package sistemasdistribuidos.crud.salasdereuniao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "saladereuniao")
public class Room {

  private long id;
  private String nome;
  private String data;
  private String horarioInicio;
  private String horarioFim;

  public Room(){

  }

  public Room(long id, String nome, String data, String horarioInicio, String horarioFim) {
    this.id = id;
    this.nome = nome;
    this.data = data;
    this.horarioInicio = horarioInicio;
    this.horarioFim = horarioFim;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  @Column(name = "nome", nullable = false)
  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  @Column(name = "data", nullable = false)
  public String getData() {
    return data;
  }

  public void setData(String data) {
    this.data = data;
  }

  @Column(name = "horarioInicio", nullable = false)
  public String getHorarioInicio() {
    return horarioInicio;
  }

  public void setHorarioInicio(String horarioInicio) {
    this.horarioInicio = horarioInicio;
  }

  @Column(name = "horarioFim", nullable = false)
  public String getHorarioFim() {
    return horarioFim;
  }

  public void setHorarioFim(String horarioFim) {
    this.horarioFim = horarioFim;
  }

  @Override
  public String toString() {
    return "Room [id=" + id +
            ", nome=" + nome +
            ", horarioInicio=" + horarioInicio +
            ", horarioFim=" + horarioFim + "]";
  }
}
