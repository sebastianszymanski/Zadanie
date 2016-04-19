import java.util.*;

public class Kolejka {
	ArrayList<Integer> _kolejka = new ArrayList<Integer>();
	int _elementow = 0;
	
	public void dodaj(int od)
	{
		_kolejka.add(od);
		_elementow++;
	}
	
	public void dodajNaPozycje(int ind, int od)
	{
		_kolejka.add(ind, od);
		_elementow++;
	}
	
	public int getElementy()
	{
		return _elementow;
	}
	
	public void czysc()
	{
		_kolejka.clear();
	}
	
	public int getOdwolanie(int ind)
	{
		return _kolejka.get(ind);
	}
	
	public boolean czyPusta()
	{
		return _kolejka.isEmpty();
	}
	
	public int usun(int ind)
	{
		_elementow--;
		return _kolejka.remove(ind);
	}
	
	public void setOdwolanie(int ind, int od)
	{
		_kolejka.set(ind, od);
	}
	
	public int rozmiar()
	{
		return _kolejka.size();
	}
	
	public void wypisz()
	{
		for (int i = 0; i < _kolejka.size(); i++)
		{
			System.out.println("Odwo³anie do ramki o nr " + _kolejka.get(i));
		}
	}
}
