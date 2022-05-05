package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class Tree {
    public TreeNode rootTreeNode; // корневой узел

    public Tree() { // Пустое дерево
        rootTreeNode = null;
    }

    public TreeNode findNodeByValue(int value) {
        TreeNode currentTreeNode = rootTreeNode;
        while (currentTreeNode.getValue() != value) { // поиск покуда не будет найден элемент или не будут перебраны все
            if (value < currentTreeNode.getValue()) {
                currentTreeNode = currentTreeNode.getLeftChild();
            } else {
                currentTreeNode = currentTreeNode.getRightChild();
            }
            if (currentTreeNode == null) {
                return null;
            }
        }
        return currentTreeNode;
    }

    public void insertNode(int value) {
        TreeNode newTreeNode = new TreeNode();
        newTreeNode.setValue(value);
        if (rootTreeNode == null) {
            rootTreeNode = newTreeNode;
        }
        else { // корневой узел занят
            TreeNode currentTreeNode = rootTreeNode;
            TreeNode parentTreeNode;
            while (true)
            {
                parentTreeNode = currentTreeNode;
                if(value == currentTreeNode.getValue()) {
                    return;
                }
                else  if (value < currentTreeNode.getValue()) {
                    currentTreeNode = currentTreeNode.getLeftChild();
                    if (currentTreeNode == null){
                        parentTreeNode.setLeftChild(newTreeNode);
                        return;
                    }
                }
                else {
                    currentTreeNode = currentTreeNode.getRightChild();
                    if (currentTreeNode == null) {
                        parentTreeNode.setRightChild(newTreeNode);
                        return;
                    }
                }
            }
        }
    }

    public boolean deleteNode(int value) // Удаление узла с заданным ключом
    {
        TreeNode currentTreeNode = rootTreeNode;
        TreeNode parentTreeNode = rootTreeNode;
        boolean isLeftChild = true;
        while (currentTreeNode.getValue() != value) { // начинаем поиск узла
            parentTreeNode = currentTreeNode;
            if (value < currentTreeNode.getValue()) { // Определяем, нужно ли движение влево?
                isLeftChild = true;
                currentTreeNode = currentTreeNode.getLeftChild();
            }
            else { // или движение вправо?
                isLeftChild = false;
                currentTreeNode = currentTreeNode.getRightChild();
            }
            if (currentTreeNode == null)
                return false; // yзел не найден
        }

        if (currentTreeNode.getLeftChild() == null && currentTreeNode.getRightChild() == null) { // узел просто удаляется, если не имеет потомков
            if (currentTreeNode == rootTreeNode) // если узел - корень, то дерево очищается
                rootTreeNode = null;
            else if (isLeftChild)
                parentTreeNode.setLeftChild(null); // если нет - узел отсоединяется, от родителя
            else
                parentTreeNode.setRightChild(null);
        }
        else if (currentTreeNode.getRightChild() == null) { // узел заменяется левым поддеревом, если правого потомка нет
            if (currentTreeNode == rootTreeNode)
                rootTreeNode = currentTreeNode.getLeftChild();
            else if (isLeftChild)
                parentTreeNode.setLeftChild(currentTreeNode.getLeftChild());
            else
                parentTreeNode.setRightChild(currentTreeNode.getLeftChild());
        }
        else if (currentTreeNode.getLeftChild() == null) { // узел заменяется правым поддеревом, если левого потомка нет
            if (currentTreeNode == rootTreeNode)
                rootTreeNode = currentTreeNode.getRightChild();
            else if (isLeftChild)
                parentTreeNode.setLeftChild(currentTreeNode.getRightChild());
            else
                parentTreeNode.setRightChild(currentTreeNode.getRightChild());
        }
        else { // если есть два потомка, узел заменяется преемником
            TreeNode heir = receiveHeir(currentTreeNode);// поиск преемника для удаляемого узла
            if (currentTreeNode == rootTreeNode)
                rootTreeNode = heir;
            else if (isLeftChild)
                parentTreeNode.setLeftChild(heir);
            else
                parentTreeNode.setRightChild(heir);
        }
        return true; // элемент успешно удалён
    }

    // метод возвращает узел со следующим значением после передаваемого аргументом.
    // для этого он сначала переходим к правому потомку, а затем
    // отслеживаем цепочку левых потомков этого узла.
    private TreeNode receiveHeir(TreeNode treeNode) {
        TreeNode parentTreeNode = treeNode;
        TreeNode heirTreeNode = treeNode;
        TreeNode currentTreeNode = treeNode.getRightChild(); // Переход к правому потомку
        while (currentTreeNode != null) // Пока остаются левые потомки
        {
            parentTreeNode = heirTreeNode;// потомка задаём как текущий узел
            heirTreeNode = currentTreeNode;
            currentTreeNode = currentTreeNode.getLeftChild(); // переход к левому потомку
        }
        // Если преемник не является
        if (heirTreeNode != treeNode.getRightChild()) // правым потомком,
        { // создать связи между узлами
            parentTreeNode.setLeftChild(heirTreeNode.getRightChild());
            heirTreeNode.setRightChild(treeNode.getRightChild());
        }
        return heirTreeNode;// возвращаем приемника
    }

    public void printTree() {
        Stack globalStack = new Stack(); // общий стек для значений дерева
        globalStack.push(rootTreeNode);
        int gaps = 32; // начальное значение расстояния между элементами
        boolean isRowEmpty = false;
        String separator = "-----------------------------------------------------------------";
        System.out.println(separator);
        while (isRowEmpty == false) {
            Stack localStack = new Stack();
            isRowEmpty = true;

            for (int j = 0; j < gaps; j++)
                System.out.print(' ');
            while (globalStack.isEmpty() == false) {
                TreeNode temp = (TreeNode) globalStack.pop();
                if (temp != null) {
                    System.out.print(temp.getValue());
                    localStack.push(temp.getLeftChild());
                    localStack.push(temp.getRightChild());
                    if (temp.getLeftChild() != null ||
                            temp.getRightChild() != null)
                        isRowEmpty = false;
                }
                else {
                    System.out.print("__");// - если элемент пустой
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < gaps * 2 - 2; j++)
                    System.out.print(' ');
            }
            System.out.println();
            gaps /= 2;
            while (localStack.isEmpty() == false)
                globalStack.push(localStack.pop());
        }
        System.out.println(separator);
    }

    TreeNode createMinBST(int array[]){
        return createMinBST(array, 0 , array.length-1);
    }

    TreeNode createMinBST(int arr[], int start, int end){
        if(end<start){
            return null;
        }
        int mid = (start+end)/2;
        TreeNode n = new TreeNode();
        rootTreeNode = n;
        insertNode(arr[mid]);
        n.setLeftChild(createMinBST(arr, start, mid-1));
        n.setRightChild(createMinBST(arr, mid+1, end));
        return n;
    }

    ArrayList<LinkedList<TreeNode>> createLevelList(TreeNode root){
        ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();

        LinkedList<TreeNode> current = new LinkedList<TreeNode>();
        if (root != null){
            current.add(root);
        }

        while (current.size()>0){
            result.add(current);
            LinkedList<TreeNode> parents = current;
            current = new LinkedList<TreeNode>();
            for (TreeNode parent: parents){
                if(parent.getLeftChild() != null){
                    current.add(parent.getLeftChild());
                }
                if(parent.getRightChild() != null){
                    current.add(parent.getRightChild());
                }
            }
        }
        return result;
    }

    void createLevelList2(TreeNode root, ArrayList<LinkedList<TreeNode>> lists, int level){
        if(root == null) return;

        LinkedList<TreeNode> list = null;

        if(lists.size() == level){
            list = new LinkedList<TreeNode>();
            lists.add(list);
        } else {
            list = lists.get(level);
        }
        list.add(root);
    }
}
