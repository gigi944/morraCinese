package business;

public class Sasso implements PlayableElement {
	
	private static Sasso sasso;

	@Override
	public int result(PlayableElement element) {
		int result=-2;
		if(element instanceof Carta)
			result = -1;
		else if(element instanceof Forbice)
			result = 1;
		else if(element instanceof Sasso)
			result = 0;
		return result;
	}

	public static Sasso getInstance(){
		if(sasso==null)
			sasso=new Sasso();
		return sasso;
	}

	@Override
	public String toString() {
		return "Sasso";
	}

	
	
}
