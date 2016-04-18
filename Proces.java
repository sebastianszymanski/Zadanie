
public class Proces {
	private int _nr;
	private int _zgloszony;
	private int _czasWykonania;
	private int _wykonano;
	private int _czasOczekiwania;
	
	public Proces(int numer, int czIs, int zglo)
	{
		_nr = numer;
		_zgloszony = zglo;
		_czasWykonania = czIs;
		_wykonano = 0;
		_czasOczekiwania = 0;
	}
	
	public int getPozostalo()
	{
		return _czasWykonania - _wykonano;
	}
	
	public String toString()
	{
		return (_nr + ": " + _czasWykonania);
	}
	
	public void setTime(int czas)
	{
		_czasWykonania = czas;
	}
	
	public int getCzasOczekiwania()
	{
		return _czasOczekiwania;
	}
	
	public void setCzasOczekiwania(int czas)
	{
		_czasOczekiwania = czas;
	}
	
	public void zwiekszOczekiwania(int czas)
	{
		_czasOczekiwania += czas;
	}
	
	public void setNr(int numer)
	{
		_nr = numer;
	}
	
	public int getZgloszenie()
	{
		return _zgloszony;
	}
	
	public int getTime()
	{
		return _czasWykonania;
	}
	
	public int getNr()
	{
		return _nr;
	}
	
	public void setZgloszenie(int zglo)
	{
		_zgloszony = zglo;
	}
	
	public void setWykonano(int wyk)
	{
		_wykonano = wyk;
	}
	
	public void zwiekszWykonano(int wyk)
	{
		_wykonano += wyk;
	}
	
	public int getWykonano()
	{
		return _wykonano;
	}
	
	public boolean isDone()
	{
		if (_wykonano >= _czasWykonania)
			return true;
		return false;
	}
}
