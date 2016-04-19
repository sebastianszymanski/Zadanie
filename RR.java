import java.util.*;

public class RR {
	private int _czasRR = 0;
	private ArrayDeque<Proces> _listaProcesowRR  = new ArrayDeque<Proces>();
	private Kolejka _kolejRR = new Kolejka();
	private ArrayList<Proces> _wykonaneRR = new ArrayList<Proces>();
	private int _kwant;
	
	public RR(ArrayDeque<Proces> lista4, int kwant)
	{
		_listaProcesowRR.clear();
		_listaProcesowRR = lista4;
		_kwant = kwant;
	}
	
	public void wykonajRR()
	{
		_kolejRR.dodaj(_listaProcesowRR.remove());
		int nr = 0;
		int oczekiwanie = 0;
		int licznik = 0;
		while (!_listaProcesowRR.isEmpty() || !_kolejRR.czyPusta())
		{
			_czasRR++;
			licznik++;
			if (!_listaProcesowRR.isEmpty() && _czasRR == _listaProcesowRR.peek().getZgloszenie())
				_kolejRR.dodaj(_listaProcesowRR.remove());
			if (!_kolejRR.czyPusta())
			{
				_kolejRR.getProces(0).zwiekszWykonano(1);
			}
			
			if (!_kolejRR.czyPusta() && _kolejRR.getProces(0).isDone())
			{
				_wykonaneRR.add(_kolejRR.getProces(0));
				_kolejRR.usun(0);
				nr++;
				licznik = 0;
			} else if (!_kolejRR.czyPusta() && licznik == _kwant)
			{
				_kolejRR.dodaj(_kolejRR.usun(0));
				licznik = 0;
			}
			for (int i = 1; i < _kolejRR.rozmiar(); i++)
			{
				_kolejRR.getProces(i).zwiekszOczekiwania(1);
			}
		}
		for (int i = 0; i < _wykonaneRR.size(); i++)
		{
			oczekiwanie += _wykonaneRR.get(i).getCzasOczekiwania();
		}
		System.out.println("[RR] Œredni czas oczekiwania " + (oczekiwanie/(nr+1)) + " s");
		System.out.println("[RR] Œredni czas wykonywania procesu " + (_czasRR/(nr+1)) + " s");

	}
}
