import java.util.*;

public class SCAN {
	private int _przesuniecia = 0;
	private int _currentPos = 0;
	private ArrayDeque<Zgloszenie> _listaZgloszen;
	private Kolejka _kolej = new Kolejka();
	private ArrayList<Zgloszenie> _wykonane = new ArrayList<Zgloszenie>();
	private int _zakres = 0;
	
	public SCAN(ArrayDeque<Zgloszenie> lista, int zakres)
	{
		_listaZgloszen = lista;
		_zakres = zakres;
	}
	
	public void wykonajSCAN()
	{
		_kolej.dodaj(_listaZgloszen.remove());
		int nr = 0;
		int przebieg = 1;
		int dod = 0;
		while (!_listaZgloszen.isEmpty() || !_kolej.czyPusta())
		{
			if (!_listaZgloszen.isEmpty() && _przesuniecia == _listaZgloszen.peek().getCzasZgloszenia())
			{
				if (_listaZgloszen.peek().getBlok() < _currentPos && przebieg == 1)
				{
					_kolej.dodaj(_listaZgloszen.remove());
					_kolej.sortuj();
					dod++;
				} else if (_listaZgloszen.peek().getBlok() >= _currentPos && przebieg == 1)
				{
					_kolej.dodaj(_listaZgloszen.remove());
					_kolej.sortuj();
				} else if (_listaZgloszen.peek().getBlok() > _currentPos && przebieg == 0)
				{
					_kolej.dodaj(_listaZgloszen.remove());
					_kolej.sortojrev();
					dod++;
				} else if (_listaZgloszen.peek().getBlok() <= _currentPos && przebieg == 0)
				{
					_kolej.dodaj(_listaZgloszen.remove());
					_kolej.sortojrev();
				}
			}
			if (_kolej.czyPusta() && !_listaZgloszen.isEmpty())
			{
				_przesuniecia++;
			}
			if (!_kolej.czyPusta() && przebieg == 1)
			{
				_currentPos++;
				_przesuniecia++;
			} else if (!_kolej.czyPusta() && przebieg == 0)
			{
				_currentPos--;
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
				przebieg--;
				_kolej.sortojrev();
				dod = 0;
			} else if (_currentPos == 0)
			{
				przebieg++;
				_kolej.sortuj();
				dod = 0;
			}
		}
		System.out.println("[SCAN] Przemieszczenia glowicy na proces " + (_przesuniecia/nr));
	}
}
