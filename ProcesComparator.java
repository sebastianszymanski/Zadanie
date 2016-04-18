import java.util.*;

public class ProcesComparator implements Comparator<Proces>{


	public int compare(Proces pro1, Proces pro2) {
		if (pro1.getPozostalo() < pro2.getPozostalo())
		{
			return 1;
		} else if (pro1.getPozostalo() > pro2.getPozostalo())
		{
			return -1;
		} else if (pro1.getNr() < pro2.getNr())
		{
			return 1;
		} else
		{
			return -1;
		}
		
	}

}
