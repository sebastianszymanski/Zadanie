import java.util.*;

public class SSTF {
	private int _przesuniecia = 0;
	private int _currentPos = 0;
	private ArrayDeque<Zgloszenie> _listaZgloszen;
	private Kolejka _kolej = new Kolejka();
	private ArrayList<Zgloszenie> _wykonane = new ArrayList<Zgloszenie>();
	
	public SSTF(ArrayDeque<Zgloszenie> lista)
	{
		_listaZgloszen = lista;
	}
	
	public int znajdzNajblizszy(int currentpos)
	{
		int najin = 0;
		int odl = 600;
		for (int i = 0; i < _kolej.rozmiar(); i++)
		{
			int tem = Math.abs(_kolej.getZgloszenie(i).getBlok() - currentpos);
			if (tem < odl)
			{
				odl = tem;
				najin = i;
			}
		}
		return najin;
	}
	
	public void wykonajSSTF()
	{
		_kolej.dodaj(_listaZgloszen.remove());
		int nr = 0;
		while (!_listaZgloszen.isEmpty() || !_kolej.czyPusta())
		{
			if (!_listaZgloszen.isEmpty() && _przesuniecia == _listaZgloszen.peek().getCzasZgloszenia())
			{
				_kolej.dodaj(_listaZgloszen.remove());
			}
			if (_kolej.czyPusta() && !_listaZgloszen.isEmpty())
			{
				_przesuniecia++;
			}
			if (!_kolej.czyPusta() && _kolej.getZgloszenie(0).getBlok() - _currentPos > 0)
			{
				_currentPos++;
				_przesuniecia++;
			} else if (!_kolej.czyPusta() && _kolej.getZgloszenie(0).getBlok() - _currentPos < 0)
			{
				_currentPos--;
				_przesuniecia++;
			} else if (!_kolej.czyPusta() && _kolej.getZgloszenie(0).getBlok() - _currentPos == 0)
			{
				_wykonane.add(_kolej.getZgloszenie(0));
				_kolej.usun(0);
				if (_kolej.rozmiar() > 1)
				{
				int ind = znajdzNajblizszy(_currentPos);
				_kolej.zamien(0, ind);
				}
				nr++;
			}
		}
		System.out.println("[SSTF] Przemieszczenia glowicy na proces " + (_przesuniecia/nr));
	}
}
