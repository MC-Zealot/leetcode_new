package com.statsMethod;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 给定二维数据集，
 * 输入目标点，找到其最近邻数据点
 * 
 * @author Zealot
 * @date 2017年1月19日 下午6:44:20 
 *
 */
public class KdTree {
	private KdTreeNode buildTree(List<PairWiseNode> list, int depth) {
		if(list==null|| list.size()==0){
			return null;
		}
		int zuobiao = depth % 2 + 1;
		PairWiseNode midNode = new PairWiseNode();
		if(zuobiao==2){
			midNode = findMediumY(list);
		}else {
			midNode = findMediumX(list);
		}
		KdTreeNode kdTreeNode = new KdTreeNode();
		kdTreeNode.node = midNode;
		
		kdTreeNode.left = buildTree(list.subList(0, list.size()/2), depth+1);
		kdTreeNode.right = buildTree(list.subList(list.size()/2 + 1, list.size()), depth+1);
		return kdTreeNode;
	}
	private PairWiseNode findMediumX(List<PairWiseNode> list) {
		//排序
		Collections.sort(list, new Comparator<PairWiseNode>(){

			@Override
			public int compare(PairWiseNode p1, PairWiseNode p2) {
				if(p1.x > p2.x){
					return 1;
				}else if(p1.x < p2.x){
					return -1;
				}else{
					return 0;
				}
			}
			
		});
		return list.get(list.size()/2);
	}
	private PairWiseNode findMediumY(List<PairWiseNode> list) {
		if(list.size()==1){
			list.get(0);
		}
		//排序
		Collections.sort(list, new Comparator<PairWiseNode>(){

			@Override
			public int compare(PairWiseNode p1, PairWiseNode p2) {
				if(p1.y > p2.y){
					return 1;
				}else if(p1.y < p2.y){
					return -1;
				}else{
					return 0;
				}
			}
			
		});
		return list.get(list.size()/2);
	}
	static PairWiseNode curBest = new PairWiseNode();
	
	/**
	 * 用前序遍历，就可以解决回溯的问题。判断应该进入左子树，还是右子树，还是回退。
	 * @date 2017年1月23日 上午10:42:56
	 * @param node
	 * @param target
	 * @param depth
	 */
	private void findBottomAndTurnBack(KdTreeNode node, PairWiseNode target, int depth) {
		System.out.println(node.node.x + ", " + node.node.y);
		if (node.left == null && node.right == null) {
			
			
			
			curBest.x = node.node.x;
			curBest.y = node.node.y;
			return;
		}
		int zuobiaozhou = depth % 2 + 1;
		int leftorright=0;
		if(zuobiaozhou == 2){
			//在y轴上继续搜索
			if(target.y > node.node.y){
				findBottomAndTurnBack(node.right, target, depth+1);
				leftorright = 2;
			}else{
				findBottomAndTurnBack(node.left, target, depth+1);
				leftorright = 1;
			}
			
			
		}else{
			//在x轴上继续搜索
			if(target.x > node.node.x){
				findBottomAndTurnBack(node.right, target, depth+1);
				leftorright = 2;
			}else{
				findBottomAndTurnBack(node.left, target, depth+1);
				leftorright = 1;
			}
			
			
		}
		
		
		
		System.out.println(node.node.x + ", " + node.node.y);
		//另一个子节点所覆盖的范围，与当前最小圆是否相交
		if(leftorright == 1 && node.right.node.x < target.x){
			findBottomAndTurnBack(node.right, target, depth+1);
		}else if(node.left.node.y < target.y){
			findBottomAndTurnBack(node.left, target, depth+1);
		}
	}
	
	public static void main(String[] args) {
		KdTree kdTree = new KdTree();
		List<PairWiseNode> list = new ArrayList<PairWiseNode>();
		list.add(new PairWiseNode(2, 3));
		list.add(new PairWiseNode(5, 4));
		list.add(new PairWiseNode(9, 6));
		list.add(new PairWiseNode(4, 7));
		list.add(new PairWiseNode(8, 1));
		list.add(new PairWiseNode(7, 2));
		
		KdTreeNode root = kdTree.buildTree(list, 0);
//		System.out.println(root.node);
//		System.out.println(root.left.node);
//		System.out.println(root.right.node);
//		System.out.println(root.left.left.node);
//		System.out.println(root.left.right.node);
//		System.out.println(root.right.left.node);
		
		PairWiseNode target = new PairWiseNode(1,2);
		kdTree.findBottomAndTurnBack(root, target, 0);
		System.out.println("best: "+curBest);
	}
	
}
