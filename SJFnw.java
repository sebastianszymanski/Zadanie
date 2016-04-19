import java.util.*;

public class SJFnw {
	private int _czasSJFnw = 0;
	private ArrayDeque<Proces> _listaProcesowSJFnw  = new ArrayDeque<Proces>();
	private Kolejka _kolejSJFnw = new Kolejka();
	private ArrayList<Proces> _wykonaneSJFnw = new ArrayList<Proces>();
	
	public SJFnw(ArrayDeque<Proces> lista2)
	{
		_listaProcesowSJFnw.clear();
		_listaProcesowSJFnw = lista2;
	}
	
	public void wykonajSJFnw()
	{
		_kolejSJFnw.dodaj(_listaProcesowSJFnw.remove());
		int nr = 0;
		int oczekiwanie = 0;
		while (!_listaProcesowSJFnw.isEmpty() || !_kolejSJFnw.czyPusta())
		{
			_czasSJFnw++;
			if (!_listaProcesowSJFnw.isEmpty() && _czasSJFnw == _listaProcesowSJFnw.peek().getZgloszenie())
				_kolejSJFnw.dodaj(_listaProcesowSJFnw.remove());
			if (!_kolejSJFnw.czyPusta())
			{
				_kolejSJFnw.getProces(0).zwiekszWykonano(1);
			}
			if (!_kolejSJFnw.czyPusta() && _kolejSJFnw.getProces(0).isDone())
			{
				_wykonaneSJFnw.add(_kolejSJFnw.getProces(0));
				_kolejSJFnw.usun(0);
				_kolejSJFnw.sortuj();
				nr++;
			}
			for (int i = 1; i < _kolejSJFnw.rozmiar(); i++)
			{
				_kolejSJFnw.getProces(i).zwiekszOczekiwania(1);
			}
		}
		for (int i = 0; i < _wykonaneSJFnw.size(); i++)
		{
			oczekiwanie += _wykonaneSJFnw.get(i).getCzasOczekiwania();
		}
		System.out.println("[SJF] Œredni czas oczekiwania " + (oczekiwanie/(nr+1)) + " s");
		System.out.println("[SJF] Œredni czas wykonywania procesu " + (_czasSJFnw/(nr+1)) + " s");
	}
}
