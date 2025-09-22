import java.time.LocalDate;

public class Evento implements Comparable<Evento> {
    String nomeEvento;
    String localização;
    LocalDate data;


    @Override
    public int compareTo(Evento outro){
        String valorAtual=this.nomeEvento + '-' + this.data + '-' + this.localização;
        String valorOutro= outro.nomeEvento + '-' + outro.data + '-' + outro.localização;
         // Retorna:
        // -1 se esse é menor do que outro
        // 1 se esse é maior do que outro
        // 0 se são iguais
        return valorAtual.compareTo(valorOutro);
    }

    String nomeOrganizador;
    String categoria;
    ///////////////////////////////////////
    

    public Evento( String nome, String localização, LocalDate data,  String nomeOrganizador, String categoria){
    this.nomeEvento = nome;
    this.localização = localização;
    this.data=data;
    this.nomeOrganizador= nomeOrganizador;
    this.categoria = categoria;
    }


  @Override
  public String toString(){
    return "Evento:" + this.nomeEvento + "-" + this.localização + "-" + this.data + "-" + this.nomeOrganizador + "-" + this.categoria + "\n";
  }






}