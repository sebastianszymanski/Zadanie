import java.util.*;

public class Wykonaj {

	public static void stworzListeProcesow(ArrayDeque<Proces> array, int ilosc, int maxCzasWykonania, int maxCzasDolaczenia)
	{
		Random gen = new Random();
		int tw = 0;
		for (int i = 1; i <= ilosc; i++)
		{
			array.add(new Proces(i, gen.nextInt(maxCzasWykonania) + 1, tw));
			tw += gen.nextInt(maxCzasDolaczenia) + 1;
		}
	}
	
	public static void main(String[] args) {
		ArrayDeque<Proces> lista = new ArrayDeque<>();
		stworzListeProcesow(lista, 300, 30, 10);
		ArrayDeque<Proces> lista2 = lista.clone();
		ArrayDeque<Proces> lista3 = lista.clone();
		ArrayDeque<Proces> lista4 = lista.clone();
		FCFS fc = new FCFS(lista);
		fc.wykonajFCFS();
		SJFnw sj = new SJFnw(lista2);
		sj.wykonajSJFnw();
		SJFww sjw = new SJFww(lista3);
		sjw.wykonajSJFww();
		RR r = new RR(lista4, 5);
		r.wykonajRR();

	}

}
