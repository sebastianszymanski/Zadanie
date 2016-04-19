import java.util.*;

public class FCFS {
	private int _czasFCFS = 0;
	private ArrayDeque<Proces> _listaProcesowFCFS = new ArrayDeque<Proces>();
	private Kolejka _kolejFCFS = new Kolejka();
	private ArrayList<Proces> _wykonaneFCFS = new ArrayList<Proces>();
	
	public FCFS(ArrayDeque<Proces> lista)
	{
		_listaProcesowFCFS.clear();
		_listaProcesowFCFS = lista;
	}
	
	public void wykonajFCFS()
	{
		_kolejFCFS.dodaj(_listaProcesowFCFS.remove());
		int nr = 0;
		int oczekiwanie = 0;
		while (!_listaProcesowFCFS.isEmpty() || !_kolejFCFS.czyPusta())
		{
			_czasFCFS++;
			if (!_listaProcesowFCFS.isEmpty() && _czasFCFS == _listaProcesowFCFS.peek().getZgloszenie())
				_kolejFCFS.dodaj(_listaProcesowFCFS.remove());
			if (!_kolejFCFS.czyPusta())
			{
				_kolejFCFS.getProces(0).zwiekszWykonano(1);
			}
			if (!_kolejFCFS.czyPusta() && _kolejFCFS.getProces(0).isDone())
			{
				_wykonaneFCFS.add(_kolejFCFS.getProces(0));
				_kolejFCFS.usun(0);
				nr++;
			}
			for (int i = 1; i < _kolejFCFS.rozmiar(); i++)
			{
				_kolejFCFS.getProces(i).zwiekszOczekiwania(1);
			}
		}
		for (int i = 0; i < _wykonaneFCFS.size(); i++)
		{
			oczekiwanie += _wykonaneFCFS.get(i).getCzasOczekiwania();
		}
		System.out.println("[FCFS] Œredni czas oczekiwania " + (oczekiwanie/(nr+1)) + " s");
		System.out.println("[FCFS] Œredni czas wykonywania procesu " + (_czasFCFS/(nr+1)) + " s");
	}
	
}
