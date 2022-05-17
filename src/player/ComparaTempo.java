package player;

import java.util.Comparator;

public class ComparaTempo implements Comparator<Jogador> {

    @Override
    public int compare(Jogador o1, Jogador o2) {

        return o1.getTempo().compareTo(o2.getTempo());
    }

}