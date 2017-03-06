package business;

public class Forbice implements PlayableElement {
	
	private static Forbice forbice;

	@Override
	public int result(PlayableElement element) {
		int result=-2;
		if(element instanceof Carta)
			result = 1;
		else if(element instanceof Forbice)
			result = 0;
		else if(element instanceof Sasso)
			result = -1;
		return result;
	}
	
	public static Forbice getInstance(){
		if(forbice==null)
			forbice=new Forbice();
		return forbice;
	}

	@Override
	public String toString() {
		return "Forbice";
	}

	
	
}
