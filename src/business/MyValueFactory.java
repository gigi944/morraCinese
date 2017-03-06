package business;

import javafx.scene.control.SpinnerValueFactory;

public class MyValueFactory extends SpinnerValueFactory<Integer> {
	
	

	@Override
	public void decrement(int steps) {
		if((this.getValue()-steps)<=0)
			this.setValue(1);
		else
			this.setValue(this.getValue()-steps);
		if(this.getValue()%2==0)
			this.setValue(this.getValue()-1);
	}

	@Override
	public void increment(int steps) {
		this.setValue(this.getValue()+steps);
		if(this.getValue()%2==0)
			this.setValue(this.getValue()+1);
	}

}
