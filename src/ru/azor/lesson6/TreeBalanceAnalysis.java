package ru.azor.lesson6;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TreeBalanceAnalysis {

    private static final int NUMBER_OF_TREES = 20;
    private static final int TREE_DEPTH = 4;
    private static final Random random = new Random();

    public static void main(String[] args) {
        List<TreeImpl<Integer>> forest = treeFactory(NUMBER_OF_TREES, TREE_DEPTH);
        for (TreeImpl<Integer> tree : forest) {
            tree.display();
            System.out.println("Количество уровней: " + tree.getLevel());
            System.out.println("Дерево сбалансировано: " + tree.isTreeBalanced());
        }
        balanceAnalysis(forest);
    }

    private static List<TreeImpl<Integer>> treeFactory(int number, int depth) {
        List<TreeImpl<Integer>> treeList = new ArrayList<>();
        int count = 0;
        while (count < number) {
            TreeImpl<Integer> tree = new TreeImpl<>();
            while (tree.getLevel() < depth){
                int value = random.nextInt(-25, 26);
                if (!tree.contains(value)){
                    tree.add(value);
                }
            }
            treeList.add(tree);
            count++;
        }
        return treeList;
    }

    private static void balanceAnalysis(List<TreeImpl<Integer>> treeList){
        System.out.println("................................................................");
        int isBalanced = 0;
        int notBalanced = 0;
        for (TreeImpl<Integer> tree : treeList) {
            if (tree.isTreeBalanced()){
                isBalanced ++;
            }else {
                notBalanced ++;
            }
        }
        System.out.println("Несбалансированных деревьев: " + notBalanced);
        System.out.println("Сбалансированных деревьев: " + isBalanced);
        int percent = (notBalanced*100/ NUMBER_OF_TREES);
        System.out.println("Процент несбалансированных деревьев: " + percent + " %");
    }
}
