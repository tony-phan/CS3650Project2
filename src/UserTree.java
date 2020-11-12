import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

public class UserTree extends JPanel {
	
	private DefaultMutableTreeNode root;
	private JTree tree;
	private DefaultTreeModel treeModel;
	
	/**
	 * Create the panel.
	 */
	public UserTree() {
		super(new GridLayout(1,0));
		root = new DefaultMutableTreeNode("Root"); 
		treeModel = new DefaultTreeModel(root);
		tree = new JTree(treeModel);
		tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		tree.setShowsRootHandles(true);
		
		JScrollPane pane = new JScrollPane(tree);
		add(pane);

	}
	
	private DefaultMutableTreeNode addedUser(boolean visibility, DefaultMutableTreeNode parentNode, Users childNode) {
		DefaultMutableTreeNode child = new DefaultMutableTreeNode(childNode);
        if (parentNode == null) {
        	parentNode = root;
        }
        if(parentNode.getUserObject() instanceof User) {
            return null;
        }
        treeModel.insertNodeInto(child, parentNode, parentNode.getChildCount());
        if (visibility) {
            tree.scrollPathToVisible(new TreePath(child.getPath()));
        }
        return child;
    }

	public DefaultMutableTreeNode addUser(Users childNode) {
		DefaultMutableTreeNode parentNode = null;
        TreePath parent = tree.getSelectionPath();

        if (parent == null) {
            parentNode = root;
        }
        else {
            parentNode = (DefaultMutableTreeNode)(parent.getLastPathComponent());
        }
        DefaultMutableTreeNode nodeAdded = addedUser(true, parentNode, childNode);
        return nodeAdded;
	}
	
	public Users getCurrentNode() {
        TreePath selectedPath = tree.getSelectionPath();
        if (selectedPath != null) {
            DefaultMutableTreeNode currentNode = (DefaultMutableTreeNode) (selectedPath.getLastPathComponent());
            if(currentNode.getUserObject() instanceof UserGroup){
                return null;
            }
            MutableTreeNode parentNode = (MutableTreeNode) (currentNode.getParent());
            if (parentNode != null) {
                return (User) currentNode.getUserObject();
            }
        }
        return null;
    }
}
