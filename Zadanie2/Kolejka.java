import java.util.*;

public class Kolejka {
	ArrayList<Zgloszenie> _kolejka = new ArrayList<Zgloszenie>();
	ZgloszenieComparator com = new ZgloszenieComparator();
	ZgloszenieRevComparator comw = new ZgloszenieRevComparator();
	int _elementow = 0;
	
	public void dodaj(Zgloszenie zg)
	{
		_kolejka.add(zg);
		_elementow++;
	}
	
	public void dodajNaPozycje(int ind, Zgloszenie zg)
	{
		_kolejka.add(ind, zg);
		_elementow++;
	}
	
	public void sortojrev()
	{
		_kolejka.sort(comw);
	}
	
	public void zamien(int l1, int l2)
	{
		Zgloszenie tem = _kolejka.get(l1);
		_kolejka.set(l1, _kolejka.get(l2));
		_kolejka.set(l2, tem);
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
	
	public Zgloszenie getZgloszenie(int ind)
	{
		return _kolejka.get(ind);
	}
	
	public boolean czyPusta()
	{
		return _kolejka.isEmpty();
	}
	
	public Zgloszenie usun(int ind)
	{
		_elementow--;
		return _kolejka.remove(ind);
	}
	
	public void setZgloszenie(int ind, Zgloszenie zg)
	{
		_kolejka.set(ind, zg);
	}
	
	public int rozmiar()
	{
		return _kolejka.size();
	}
	
	public void wypisz()
	{
		for (int i = 0; i < _kolejka.size(); i++)
		{
			System.out.println("Zg³oszenie " + _kolejka.get(i).getNr() + " : dostêp do bloku " + _kolejka.get(i).getBlok());
		}
	}
}
