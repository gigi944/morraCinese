package business;

public class Carta implements PlayableElement {
	
	private static Carta carta;

	@Override
	public int result(PlayableElement element) {
		int result=-2;
		if(element instanceof Carta)
			result = 0;
		else if(element instanceof Forbice)
			result = -1;
		else if(element instanceof Sasso)
			result = 1;
		return result;
	}
	
	public static Carta getInstance(){
		if(carta==null)
			carta=new Carta();
		return carta;
	}

	@Override
	public String toString() {
		return "Carta";
	}
	
	

}
