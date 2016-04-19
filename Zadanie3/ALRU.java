import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Random;

public class ALRU {
	private ArrayDeque<Integer> _listaOdwolan = new ArrayDeque<Integer>();
	private Kolejka _kolej = new Kolejka();
	private int _bledyStrony;
	private ArrayList<Strona> _listaRamek = new ArrayList<Strona>();
	Random gen = new Random();
	
	public ALRU(ArrayDeque<Integer> arr, ArrayList<Strona> arrl)
	{
		_listaOdwolan = arr;
		_listaRamek = arrl;
	}
	
	public void wykonajALRU()
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
					_listaRamek.get(i).setBitPom(1);
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
					_listaRamek.get(i).setBitPom(0);
					wyk = true;
				}
			}
			if (!wyk)
			{
				boolean znal = false;
				for (int i = 0; i < _listaRamek.size() && !znal; i++)
				{
					if (_listaRamek.get(i).getBitPom() == 1)
					{
						_listaRamek.get(i).setBitPom(1);
					} else
					{
						Strona tym = new Strona(_kolej.getOdwolanie(0), 0);
						_listaRamek.set(i, tym);
						_kolej.usun(0);
						for (int z = 0; z < gen.nextInt(2) + 1 && !_listaOdwolan.isEmpty(); z++)
							_kolej.dodaj(_listaOdwolan.remove());
						_bledyStrony++;
						znal = true;
					}
				}
				if (!znal)
				{
					Strona tym = new Strona(_kolej.getOdwolanie(0), 0);
					_listaRamek.set(0, tym);
					_kolej.usun(0);
					for (int z = 0; z < gen.nextInt(2) + 1 && !_listaOdwolan.isEmpty(); z++)
						_kolej.dodaj(_listaOdwolan.remove());
					_bledyStrony++;
					znal = true;
				}

			}
		}
		System.out.println("[ALRU] B³edy strony: " + _bledyStrony);
	}
}