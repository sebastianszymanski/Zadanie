
public class Strona {

	private int _wartosc;
	private int _bitpom;
	
	public Strona(int war, int bit)
	{
		_wartosc = war;
		_bitpom = bit;
	}
	
	public int getWartosc()
	{
		return _wartosc;
	}
	
	public int getBitPom()
	{
		return _bitpom;
	}
	
	public void setBitPom(int bit)
	{
		_bitpom = bit;
	}
	
	public void incrBitPom()
	{
		_bitpom++;
	}
}
