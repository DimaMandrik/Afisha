package by.mandrik.afisha.logic.impl;
import by.mandrik.afisha.entity.Afisha;
import by.mandrik.afisha.entity.Event;
import by.mandrik.afisha.logic.AfishaVisitor;

public class ConsolAfishaVisitor implements AfishaVisitor {

	@Override
	public void showAfisha(Afisha afisha) {
		for (Event event : afisha.getEvents()){
			System.out.println(event);
		}
	}
}
