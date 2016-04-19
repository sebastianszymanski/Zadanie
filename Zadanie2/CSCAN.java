import java.util.*;

public class CSCAN {
	private int _przesuniecia = 0;
	private int _currentPos = 0;
	private ArrayDeque<Zgloszenie> _listaZgloszen;
	private Kolejka _kolej = new Kolejka();
	private ArrayList<Zgloszenie> _wykonane = new ArrayList<Zgloszenie>();
	private int _zakres = 0;
	
	public CSCAN(ArrayDeque<Zgloszenie> lista, int zakres)
	{
		_listaZgloszen = lista;
		_zakres = zakres;
	}
	
	public void wykonajCSCAN()
	{
		_kolej.dodaj(_listaZgloszen.remove());
		int nr = 0;
		int dod = 0;
		int przesunieciadod = 0;
		while (!_listaZgloszen.isEmpty() || !_kolej.czyPusta())
		{
			if (!_listaZgloszen.isEmpty() && _przesuniecia == _listaZgloszen.peek().getCzasZgloszenia())
			{
				if (_listaZgloszen.peek().getBlok() < _currentPos)
				{
					_kolej.dodaj(_listaZgloszen.remove());
					_kolej.sortuj();
					dod++;
				} else if (_listaZgloszen.peek().getBlok() >= _currentPos)
				{
					_kolej.dodaj(_listaZgloszen.remove());
					_kolej.sortuj();
				}
			}
			if (_kolej.czyPusta() && !_listaZgloszen.isEmpty())
			{
				_przesuniecia++;
			}
			if (!_kolej.czyPusta())
			{
				_currentPos++;
				_przesuniecia++;
			}
			if ((_kolej.rozmiar() - dod > 0) && _kolej.getZgloszenie(dod).getBlok() - _currentPos == 0)
			{
				_wykonane.add(_kolej.getZgloszenie(dod));
				_kolej.usun(dod);
				nr++;
			}
			if (_currentPos == _zakres)
			{
				_kolej.sortuj();
				_currentPos = 0;
				przesunieciadod += _zakres;
				dod = 0;
			}
		}
		System.out.println("[CSCAN] Przemieszczenia glowicy na proces " + ((_przesuniecia+przesunieciadod)/nr));
	}
}
