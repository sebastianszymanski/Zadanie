import java.util.ArrayDeque;
import java.util.Random;

public class test {

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
		stworzListeProcesow(lista, 10, 60, 40);
		ArrayDeque<Proces> lista2 = lista.clone();
		ArrayDeque<Proces> lista3 = lista.clone();
		Kolejka kol = new Kolejka();
		Kolejka kol2 = new Kolejka();
		for (;!lista.isEmpty();)
		{
			Proces temp = lista.pop();
			System.out.println(temp);
			kol.dodaj(temp);
		}
		System.out.println("");
		for (;!lista2.isEmpty();)
		{
			Proces temp = lista2.pop();
			System.out.println(temp);
			kol2.dodaj(temp);
		}
		System.out.println("");
		for (;!lista3.isEmpty();)
		{
			Proces temp = lista3.pop();
			System.out.println(temp);
		}
		System.out.println("");
		kol.wypisz();
		kol.sortuj();
		System.out.println("");
		kol.wypisz();
		System.out.println("");
		kol2.wypisz();


	}

}
