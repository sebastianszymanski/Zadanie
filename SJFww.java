import java.util.*;

public class SJFww {
	private int _czasSJFww = 0;
	private ArrayDeque<Proces> _listaProcesowSJFww  = new ArrayDeque<Proces>();
	private Kolejka _kolejSJFww = new Kolejka();
	private ArrayList<Proces> _wykonaneSJFww = new ArrayList<Proces>();
	
	public SJFww(ArrayDeque<Proces> lista3)
	{
		_listaProcesowSJFww.clear();
		_listaProcesowSJFww = lista3;
	}
	
	public void wykonajSJFww()
	{
		_kolejSJFww.dodaj(_listaProcesowSJFww.remove());
		int nr = 0;
		int oczekiwanie = 0;
		while (!_listaProcesowSJFww.isEmpty() || !_kolejSJFww.czyPusta())
		{
			_czasSJFww++;
			
			if (!_listaProcesowSJFww.isEmpty() && _czasSJFww == _listaProcesowSJFww.peek().getZgloszenie())
			{
				_kolejSJFww.dodaj(_listaProcesowSJFww.remove());
				_kolejSJFww.sortuj();
			}
			if (!_kolejSJFww.czyPusta())
			{
				_kolejSJFww.getProces(0).zwiekszWykonano(1);
			}
			if (!_kolejSJFww.czyPusta() && _kolejSJFww.getProces(0).isDone())
			{
				_wykonaneSJFww.add(_kolejSJFww.getProces(0));
				_kolejSJFww.usun(0);
				nr++;
			}
			for (int i = 1; i < _kolejSJFww.rozmiar(); i++)
			{
				_kolejSJFww.getProces(i).zwiekszOczekiwania(1);
			}
		}
		for (int i = 0; i < _wykonaneSJFww.size(); i++)
		{
			oczekiwanie += _wykonaneSJFww.get(i).getCzasOczekiwania();
		}
		System.out.println("[SJF wyw³aszczaj¹cy] Œredni czas oczekiwania " + (oczekiwanie/(nr+1)) + " s");
		System.out.println("[SJF wyw³aszczaj¹cy] Œredni czas wykonywania procesu " + (_czasSJFww/(nr+1)) + " s");
	}
}
