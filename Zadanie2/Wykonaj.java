import java.util.*;

public class Wykonaj {

	public final static int BLOK_MAX = 600;
	private final static int MAX_ZGLOSZEN = 150;
	
	public static void stworzListeZgloszen(ArrayDeque<Zgloszenie> array, ArrayDeque<Zgloszenie> array2, ArrayDeque<Zgloszenie> array3, ArrayDeque<Zgloszenie> array4, int maxCzasDolaczenia)
	{
		Random gen = new Random();
		int zw = 0;
		for (int i = 0; i < MAX_ZGLOSZEN; i++)
		{
			array.add(new Zgloszenie(i+1, zw));
			array2.add(new Zgloszenie(i+1, zw));
			array3.add(new Zgloszenie(i+1, zw));
			array4.add(new Zgloszenie(i+1, zw));
			zw += gen.nextInt(maxCzasDolaczenia)+1;
		}
	}
	
	public static void main(String[] args) {
		ArrayDeque<Zgloszenie> array = new ArrayDeque<Zgloszenie>();
		ArrayDeque<Zgloszenie> array2 = new ArrayDeque<Zgloszenie>();
		ArrayDeque<Zgloszenie> array3 = new ArrayDeque<Zgloszenie>();
		ArrayDeque<Zgloszenie> array4 = new ArrayDeque<Zgloszenie>();
		stworzListeZgloszen(array, array2, array3, array4, 20);
		FCFS fc = new FCFS(array);
		fc.wykonajFCFS();
		SSTF ss = new SSTF(array2);
		ss.wykonajSSTF();
		SCAN sc = new SCAN(array3, BLOK_MAX);
		sc.wykonajSCAN();
		CSCAN csc = new CSCAN(array4, BLOK_MAX);
		csc.wykonajCSCAN();
	}

}
