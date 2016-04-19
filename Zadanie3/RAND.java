import java.util.*;

public class RAND {
	private ArrayDeque<Integer> _listaOdwolan = new ArrayDeque<Integer>();
	private Kolejka _kolej = new Kolejka();
	private int _bledyStrony;
	private ArrayList<Strona> _listaRamek = new ArrayList<Strona>();
	Random gen = new Random();
	
	public RAND(ArrayDeque<Integer> arr, ArrayList<Strona> arrl)
	{
		_listaOdwolan = arr;
		_listaRamek = arrl;
	}
	
	public void wykonajRAND()
	{
		for (int i = 0; i < 10; i++)
		{
		_kolej.dodaj(_listaOdwolan.remove());
		}
		while (!_listaOdwolan.isEmpty() || !_kolej.czyPusta())
		{
			boolean wyk = false;
			for (int i = 0; i < _listaRamek.size() && !wyk; i++)
			{
				if(_listaRamek.get(i).getWartosc() == _kolej.getOdwolanie(0))
				{
					_kolej.usun(0);
					for (int z = 0; z < gen.nextInt(2) + 1 && !_listaOdwolan.isEmpty(); z++)
						_kolej.dodaj(_listaOdwolan.remove());
					wyk = true;
				}
				if(_listaRamek.get(i).getWartosc() == 0)
				{
					Strona tym = new Strona(_kolej.getOdwolanie(0), 0);
					_listaRamek.set(i, tym);
					_bledyStrony++;
					_kolej.usun(0);
					for (int z = 0; z < gen.nextInt(2) + 1 && !_listaOdwolan.isEmpty(); z++)
						_kolej.dodaj(_listaOdwolan.remove());
					wyk = true;
				}
			}
			if (!wyk)
			{
				_listaRamek.remove(gen.nextInt(_listaRamek.size()));
				Strona tym = new Strona(_kolej.getOdwolanie(0), 0);
				_listaRamek.add(tym);
				_kolej.usun(0);
				for (int z = 0; z < gen.nextInt(2) + 1 && !_listaOdwolan.isEmpty(); z++)
					_kolej.dodaj(_listaOdwolan.remove());
				_bledyStrony++;
			}
		}
		System.out.println("[RAND] B³edy strony: " + _bledyStrony);
	}
}
