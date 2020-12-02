package GUI;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

import composite.User;
import composite.UserGroup;
import composite.Users;

@SuppressWarnings("serial")
public class UserTree extends JPanel {
	
	private JTree userTree;
	private DefaultTreeModel userTreeModel;
	private DefaultMutableTreeNode root;
	
	public UserTree() {
		super(new GridLayout(1, 0));
		
		root = new DefaultMutableTreeNode("Root");
		userTreeModel = new DefaultTreeModel(root);
		userTree = new JTree(userTreeModel);
		userTree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		userTree.setShowsRootHandles(true);
		JScrollPane scrollPane = new JScrollPane(userTree);
		add(scrollPane);
	}

	public JTree getUserTree() {
		return userTree;
	}

	public DefaultTreeModel getUserTreeModel() {
		return userTreeModel;
	}

	public DefaultMutableTreeNode getRoot() {
		return root;
	}
	
	public Users getCurrentNode() {
		if(userTree.getSelectionPath() != null) {
			DefaultMutableTreeNode currentNode = (DefaultMutableTreeNode) (userTree.getSelectionPath().getLastPathComponent()); 
			if(currentNode.getUserObject() instanceof UserGroup) {
				return null;
			}
			MutableTreeNode parent = (MutableTreeNode)(currentNode.getParent());
			if(parent != null) {
				return (User)currentNode.getUserObject();
			}
		}
		return null;
	}
	
	public DefaultMutableTreeNode addUsers(Users userChild) {
		DefaultMutableTreeNode parentNode = null;
		TreePath path = userTree.getSelectionPath();
		if(path == null) {
			parentNode = root;
		}
		else {
			parentNode = (DefaultMutableTreeNode)(path.getLastPathComponent());
		}
		return addUsers(parentNode, userChild, true);
	}
	
	public DefaultMutableTreeNode addUsers(DefaultMutableTreeNode parent, Users userChild, boolean visibility) {
		DefaultMutableTreeNode childNode = new DefaultMutableTreeNode(userChild);
		if(parent == null) {
			parent = root;
		}
		if(parent.getUserObject() instanceof User) {
			return null;
		}
		userTreeModel.insertNodeInto(childNode, parent, parent.getChildCount());
		if(visibility) {
			userTree.scrollPathToVisible(new TreePath(childNode.getPath()));
		}
		return childNode;
	}
}
