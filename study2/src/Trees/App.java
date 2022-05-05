package Trees;

import java.util.ArrayList;
import java.util.LinkedList;

public class App {
    public static void main(String[] args) {
        Tree tree = new Tree();
        // вставляем узлы в дерево:
        tree.insertNode(6);
        tree.insertNode(8);
        tree.insertNode(5);
        tree.insertNode(8);
        tree.insertNode(2);
        tree.insertNode(9);
        tree.insertNode(7);
        tree.insertNode(4);
        tree.insertNode(10);
        tree.insertNode(3);
        tree.insertNode(1);
        // отображение дерева:
        tree.printTree();

        // удаляем один узел и выводим оставшееся дерево в консоли
        tree.deleteNode(5);
        tree.printTree();

        // находим узел по значению и выводим его в консоли
        TreeNode foundTreeNode = tree.findNodeByValue(7);
        foundTreeNode.printNode();
        ArrayList<LinkedList<TreeNode>> levels = tree.createLevelList(tree.rootTreeNode);
        for (LinkedList<TreeNode> level : levels) {
            System.out.println();
            for(TreeNode node : level) {
                System.out.print(node.getValue()+ " ");
            }
        }

    }
}
