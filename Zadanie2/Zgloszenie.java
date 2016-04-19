import java.util.*;

public class Zgloszenie {
	private final static int BLOK_MAX = 600;
	private int _blok;
	private int _nr;
	private int _czasZgloszenia;
	public boolean _done;
	
	public Zgloszenie(int nr, int czzg)
	{
		Random gen = new Random();
		_nr = nr;
		_czasZgloszenia = czzg;
		_blok = gen.nextInt(BLOK_MAX) + 1;
		_done = false;
	}
	
	public int getBlok()
	{
		return _blok;
	}
	
	public int getNr()
	{
		return _nr;
	}
	
	public int getCzasZgloszenia()
	{
		return _czasZgloszenia;
	}
	
	public String toString()
	{
		return ("Nr zgloszenia: " + _nr + " blok: " + _blok + " czas zgloszenia: " +_czasZgloszenia);
	}
}
