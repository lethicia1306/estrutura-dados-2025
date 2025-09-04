import java.time.LocalDate;
import java.util.*;


public class main {
    public static void main(String[] args) {
        //Inclua seu código aqui...
          ArvoreBinaria<Evento> arvore = new ArvoreBinaria<>();
                List<Evento> eventos = new ArrayList<>();
        
                eventos.add(new Evento("Hackathon", LocalDate.of(2025, 9, 10)));
                eventos.add(new Evento("Workshop Java", LocalDate.of(2025, 8, 25)));
                eventos.add(new Evento("Feira de Empregos", LocalDate.of(2025, 10, 5)));
                eventos.add(new Evento("Palestra IA", LocalDate.of(2025, 9, 1)));
                eventos.add(new Evento("Curso Web", LocalDate.of(2025, 8, 30)));
                eventos.add(new Evento("Encontro Devs", LocalDate.of(2025, 9, 15)));
                eventos.add(new Evento("Semana Acadêmica", LocalDate.of(2025, 9, 20)));
                eventos.add(new Evento("Oficina Python", LocalDate.of(2025, 9, 5)));
                eventos.add(new Evento("Congresso Tech", LocalDate.of(2025, 10, 10)));
                eventos.add(new Evento("Bootcamp Cloud", LocalDate.of(2025, 8, 28)));
        
                Collections.shuffle(eventos); // embaralha a ordem
        
                for (Evento e : eventos) {
                    arvore.inserir(e);
                }
        
                System.out.println("🌲 Impressão Pré-Fixada:");
                arvore.imprimePreFixado();
        
                System.out.println("\n📅 Impressão Em Ordem (por data):");
                arvore.imprimeEmOrdem();
            }
        }
        
    
