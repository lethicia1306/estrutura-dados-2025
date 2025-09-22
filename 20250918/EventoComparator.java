
import java.util.Comparator;
public class EventoComparator implements Comparator <Evento>{

    @Override
    public int  compare(Evento a1, Evento a2){
        return a1.nomeEvento.compareTo(a2.nomeEvento);


    }
    

}
