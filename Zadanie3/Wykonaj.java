import java.util.*;

public class Wykonaj {

	public static void stworzListeOdwolan(ArrayDeque<Integer> array1, ArrayDeque<Integer> array2, ArrayDeque<Integer> array3, ArrayDeque<Integer> array4, ArrayDeque<Integer> array5, int ilosc, int iloscStron)
	{
		Random gen = new Random();
		for (int i = 0; i < ilosc; i++)
		{
			int tem = gen.nextInt(iloscStron)+1;
			array1.add(tem);
			array2.add(tem);
			array3.add(tem);
			array4.add(tem);
			array5.add(tem);
		}
	}
	
	public static void stworzListeRamek(ArrayList<Strona> arr, int iloscRamek)
	{
		for(int i = 0; i < iloscRamek; i++)
		{
			arr.add(new Strona(0, 0));
		}
	}
	
	public static void zerojListeRamek(ArrayList<Strona> arr)
	{
		for(int i = 0; i < arr.size(); i++)
		{
			arr.set(i, new Strona(0, 0));
		}
	}
	
	public static void main(String[] args)
	{
		ArrayDeque<Integer> lista1 = new ArrayDeque<Integer>();
		ArrayDeque<Integer> lista2 = new ArrayDeque<Integer>();
		ArrayDeque<Integer> lista3 = new ArrayDeque<Integer>();
		ArrayDeque<Integer> lista4 = new ArrayDeque<Integer>();
		ArrayDeque<Integer> lista5 = new ArrayDeque<Integer>();
		stworzListeOdwolan(lista1, lista2, lista3, lista4, lista5, 1000, 30);
		ArrayList<Strona> ramki = new ArrayList<Strona>();
		stworzListeRamek(ramki, 10);
		FIFO fi = new FIFO(lista1, ramki);
		fi.wykonajFIFO();
		zerojListeRamek(ramki);
		OPT op = new OPT(lista2, ramki);
		op.wykonajOPT();
		zerojListeRamek(ramki);
		LRU lr = new LRU(lista3, ramki);
		lr.wykonajLRU();
		zerojListeRamek(ramki);
		ALRU alr = new ALRU(lista4, ramki);
		alr.wykonajALRU();
		zerojListeRamek(ramki);
		RAND ra = new RAND(lista5, ramki);
		ra.wykonajRAND();
		zerojListeRamek(ramki);
	}
}
