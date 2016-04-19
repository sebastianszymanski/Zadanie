import java.util.*;

public class Kolejka {
	ArrayList<Proces> _kolejka = new ArrayList<Proces>();
	ProcesComparator com = new ProcesComparator();
	int _elementow = 0;
	
	public Kolejka()
	{
		
	}
	
	public void dodaj(Proces pro)
	{
		_kolejka.add(pro);
		_elementow++;
	}
	
	public void dodajNaPozycje(int ind, Proces pro)
	{
		_kolejka.add(ind, pro);
		_elementow++;
	}
	
	public void sortuj()
	{
		_kolejka.sort(com);
	}
	
	public int getElementy()
	{
		return _elementow;
	}
	
	public void czysc()
	{
		_kolejka.clear();
	}
	
	public Proces getProces(int ind)
	{
		return _kolejka.get(ind);
	}
	
	public boolean czyPusta()
	{
		return _kolejka.isEmpty();
	}
	
	public Proces usun(int ind)
	{
		_elementow--;
		return _kolejka.remove(ind);
	}
	
	public void setProces(int ind, Proces pro)
	{
		_kolejka.set(ind, pro);
	}
	
	public int rozmiar()
	{
		return _kolejka.size();
	}
	
	public void wypisz()
	{
		for (int i = 0; i < _kolejka.size(); i++)
		{
			System.out.println(_kolejka.get(i));
		}
	}
}
