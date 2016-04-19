import java.util.*;

public class ZgloszenieComparator implements Comparator<Zgloszenie> {


	public int compare(Zgloszenie zg1, Zgloszenie zg2) {
		if (zg1.getBlok() < zg2.getBlok())
		{
			return -1;
		} else if (zg1.getBlok() > zg2.getBlok())
		{
			return 1;
		} else
			return 0;
		}
	}

