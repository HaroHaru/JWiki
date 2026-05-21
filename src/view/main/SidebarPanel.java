package src.view.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;

import src.etc.Header;

public class SidebarPanel extends JPanel {
    JTree TOC;
    DefaultTreeModel treeModel;
    DefaultMutableTreeNode root;

    public SidebarPanel(int width) {
        root = new DefaultMutableTreeNode("Table of Contents");
        treeModel = new DefaultTreeModel(root);
        TOC = new JTree(treeModel);

        DefaultTreeCellRenderer renderer = new DefaultTreeCellRenderer();
        renderer.setLeafIcon(null);
        renderer.setOpenIcon(null);
        renderer.setClosedIcon(null);

        TOC.setCellRenderer(renderer);

        setLayout(new BorderLayout());

        add(new JScrollPane(TOC), BorderLayout.CENTER);

        setPreferredSize(new Dimension(width, 0));
        setBackground(Color.WHITE);
    }

    public void setTree(List<Header> list) {
        root.removeAllChildren();
        treeModel.reload();

        DefaultMutableTreeNode[] parentList = new DefaultMutableTreeNode[4];
        parentList[0] = root;

        for (Header h : list) {
            DefaultMutableTreeNode node = new DefaultMutableTreeNode(h.title);

            int level = h.level;

            DefaultMutableTreeNode parent = null;

            for (int i = level - 1; i >= 0; i--) {
                if (parentList[i] != null) {
                    parent = parentList[i];
                    break;
                }
            }

            treeModel.insertNodeInto(node, parent, parent.getChildCount());
            parentList[level] = node;

            for (int i = level + 1; i < parentList.length; i++) {
                parentList[i] = null;
            }
        }

        for (int i = 0; i < TOC.getRowCount(); i++) {
            TOC.expandRow(i);
        }
    }
}
