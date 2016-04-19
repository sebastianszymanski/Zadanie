import java.util.*;

public class Wykonaj {

	public static void stworzListeProcesow(ArrayDeque<Proces> lista, ArrayDeque<Proces> lista2, ArrayDeque<Proces> lista3, ArrayDeque<Proces> lista4, int ilosc, int maxCzasWykonania, int maxCzasDolaczenia)
	{
		Random gen = new Random();
		int tw = 0;
		for (int i = 1; i <= ilosc; i++)
		{
			int tem = gen.nextInt(maxCzasWykonania) + 1;
			lista.add(new Proces(i, tem, tw));
			lista2.add(new Proces(i, tem, tw));
			lista3.add(new Proces(i, tem, tw));
			lista4.add(new Proces(i, tem, tw));
			tw += gen.nextInt(maxCzasDolaczenia) + 1;
		}
	}
	
	public static void main(String[] args) {
		ArrayDeque<Proces> lista = new ArrayDeque<>();
		ArrayDeque<Proces> lista2 = new ArrayDeque<>();
		ArrayDeque<Proces> lista3 = new ArrayDeque<>();
		ArrayDeque<Proces> lista4 = new ArrayDeque<>();
		stworzListeProcesow(lista,lista2,lista3,lista4, 500, 60, 40);
		FCFS fc = new FCFS(lista);
		fc.wykonajFCFS();
		SJFnw sj = new SJFnw(lista2);
		sj.wykonajSJFnw();
		SJFww sjw = new SJFww(lista3);
		sjw.wykonajSJFww();
		RR r = new RR(lista4, 20);
		r.wykonajRR();

	}

}
