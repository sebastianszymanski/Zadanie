import java.util.*;

public class FCFS {
	private int _przesuniecia = 0;
	private int _currentPos = 0;
	private ArrayDeque<Zgloszenie> _listaZgloszen;
	private Kolejka _kolej = new Kolejka();
	private ArrayList<Zgloszenie> _wykonane = new ArrayList<Zgloszenie>();
	
	public FCFS(ArrayDeque<Zgloszenie> lista)
	{
		_listaZgloszen = lista;
	}
	
	public void wykonajFCFS()
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
				nr++;
			}
		}
		System.out.println("[FCFS] Przemieszczenia glowicy na proces " + (_przesuniecia/nr));
	}
}
