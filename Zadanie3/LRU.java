import java.util.*;

public class LRU {
	private ArrayDeque<Integer> _listaOdwolan = new ArrayDeque<Integer>();
	private Kolejka _kolej = new Kolejka();
	private int _bledyStrony;
	private ArrayList<Strona> _listaRamek = new ArrayList<Strona>();
	Random gen = new Random();
	
	public LRU(ArrayDeque<Integer> arr, ArrayList<Strona> arrl)
	{
		_listaOdwolan = arr;
		_listaRamek = arrl;
	}
	
	public void wykonajLRU()
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
					for(int k = 0; k < _listaRamek.size(); k++)
						_listaRamek.get(k).incrBitPom();
					_listaRamek.get(i).setBitPom(0);
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
					for(int k = 0; k < _listaRamek.size(); k++)
						_listaRamek.get(k).incrBitPom();
					_listaRamek.get(i).setBitPom(0);
					wyk = true;
				}
			}
			if (!wyk)
			{
				int ind = 0;
				for (int i = 1; i < _listaRamek.size(); i++)
				{
					if (_listaRamek.get(i).getBitPom() > _listaRamek.get(ind).getBitPom())
					{
						ind = i;
					}
				}
				for(int k = 0; k < _listaRamek.size(); k++)
					_listaRamek.get(k).incrBitPom();
				_listaRamek.remove(ind);
				Strona tym = new Strona(_kolej.getOdwolanie(0), 0);
				_listaRamek.add(tym);
				_kolej.usun(0);
				for (int z = 0; z < gen.nextInt(2) + 1 && !_listaOdwolan.isEmpty(); z++)
					_kolej.dodaj(_listaOdwolan.remove());
				_bledyStrony++;
			}
		}
		System.out.println("[LRU] B³edy strony: " + _bledyStrony);
	}
}
