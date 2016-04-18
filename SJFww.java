import java.util.*;

public class SJFww {
	private int _czas;
	private ArrayDeque<Proces> _listaProcesow;
	private Kolejka _kolej = new Kolejka();
	private ArrayList<Proces> _wykonane = new ArrayList<Proces>();
	
	public SJFww(ArrayDeque<Proces> lista)
	{
		_listaProcesow = lista;
	}
	
	public void wykonajSJFww()
	{
		_kolej.dodaj(_listaProcesow.remove());
		int nr = 0;
		int oczekiwanie = 0;
		while (!_listaProcesow.isEmpty() || nr < _kolej.rozmiar())
		{
			_czas++;
			
			if (!_listaProcesow.isEmpty() && _czas == _listaProcesow.peek().getZgloszenie())
			{
				_kolej.dodaj(_listaProcesow.remove());
				_kolej.sortuj();
			}
			if (nr < _kolej.rozmiar() && _kolej.getProces(0) != null)
			{
				_kolej.getProces(0).zwiekszWykonano(1);
			}
			if (nr < _kolej.rozmiar() && _kolej.getProces(0).isDone())
			{
				_wykonane.add(_kolej.getProces(nr));
				_kolej.usun(0);
				nr++;
			}
			for (int i = 0; i < _kolej.rozmiar(); i++)
			{
				_kolej.getProces(i).zwiekszOczekiwania(1);
			}
		}
		for (int i = 0; i < _wykonane.size(); i++)
		{
			oczekiwanie += _wykonane.get(i).getCzasOczekiwania();
		}
		System.out.println("[SJF wyw�aszczaj�cy] �redni czas oczekiwania " + (oczekiwanie/(nr+1)) + " s");
		System.out.println("[SJF wyw�aszczaj�cy] �redni czas wykonywania procesu " + (_czas/(nr+1)) + " s");
	}
}
