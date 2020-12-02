package visitor;
import composite.Users;

public interface UsersVisitor {
	
	public void visitUser(Users user);

}
