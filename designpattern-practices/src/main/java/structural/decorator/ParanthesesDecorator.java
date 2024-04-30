package structural.decorator;

public class ParanthesesDecorator extends Decorator {

	public ParanthesesDecorator(Component component) {
		super(component);
	}

	@Override
	public String operation() {
		String text = component.operation();
		return "(" + text + ")";
	}

}
