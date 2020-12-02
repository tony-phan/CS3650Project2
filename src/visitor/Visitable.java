package visitor;
// Visitor Pattern
public interface Visitable {
	
	public void accept(UsersVisitor visitor);
	
}
