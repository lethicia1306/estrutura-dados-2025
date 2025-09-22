import java.time.LocalDate;
import java.util.*;

public class main {

    public static void main(String[] args) {

        //Inclua seu código aqui...
          ArvoreBinaria<Evento> arvore = new ArvoreBinaria<>();
                List<Evento> eventos = new ArrayList<>();
        
                eventos.add(new Evento("Hackathon", "São Paulo", LocalDate.of(2025, 9, 10), "Ana Claudia", "Categoria de lógica"));
                eventos.add(new Evento("Conferência de IA", "Rio de Janeiro", LocalDate.of(2025, 10, 5), "Carlos Mendes", "Tecnologia e Inovação"));
                eventos.add(new Evento("Workshop de UX", "Curitiba", LocalDate.of(2025, 11, 12), "Fernanda Lima", "Design e Experiência do Usuário"));
                eventos.add(new Evento("Feira de Startups", "Belo Horizonte", LocalDate.of(2025, 9, 25), "João Pedro", "Empreendedorismo"));
                eventos.add(new Evento("Encontro de Devs", "Recife", LocalDate.of(2025, 12, 3), "Mariana Souza", "Desenvolvimento de Software"));
                eventos.add(new Evento("Congresso de Segurança Digital", "Brasília", LocalDate.of(2025, 10, 20), "Roberto Leal", "Cibersegurança"));
                
                
                Collections.shuffle(eventos); // embaralha a ordem
        
                for (Evento e : eventos) {
                    arvore.inserir(e);
                }
        
                System.out.println(" Impressão Pré-Fixada:");
                arvore.imprimePreFixado();
        
                System.out.println("\n Impressão Em Ordem (por data):");
                arvore.imprimeEmOrdem();
            }
        }
        
    
