import java.util.ArrayList;
import java.util.Scanner;
//Symbol table/Dictionary
//Task:- Implementing 
public  class TASK1 {
	class TreeNode{
		String name;
		TreeNode left,right;
		int cnt;
		ArrayList<Integer> poslist;
		TreeNode(String n,int pos){
			poslist=new ArrayList<Integer>();
			cnt=1;
			name=n;
			poslist.add(pos);
			left=null;
			right=null;
		}
	}
	TreeNode root;
	void addNode(String str,int p) {
		int status=0;
		if(root==null) {
			TreeNode tn=new TreeNode(str,p);
			System.out.println(str+" root node");
			root=tn;
		}
		else {
			TreeNode temp=root;
			while(temp!=null) {
				int res=temp.name.compareTo(str);
				if(res==0) {
					temp.cnt=temp.cnt+1;
					temp.poslist.add(p);
					status=1;
					System.out.println(str+" repeat node");
					break;
				}
				else if(res<0) {
					if(temp.right!=null)
						temp=temp.right;
					else {
						status=2;
						break;
					}
				}
				else {
					if(temp.left!=null)
						temp=temp.left;
					else {
						status=3;
						break;
					}
				}
			}
			if(status==2) {
				TreeNode tn=new TreeNode(str,p);
				System.out.println(str+" new left node");
				temp.right=tn;
			}
			if(status==3) {
				TreeNode tn=new TreeNode(str,p);
				System.out.println(str+" new right node");
				temp.left=tn;
			}
		}
	}
	void show() {
		TreeNode temp=root;
		inorder(temp);
	}
	
	public void inorder(TreeNode cur) {
		if(cur!=null) {
			inorder(cur.left);
			System.out.println(cur.name+" "+cur.cnt+" "+cur.poslist);
			inorder(cur.right);
		}
	}
	public static void main(String[] args) {
		System.out.println("Hello World");
		String s[]=new String[20];
		Scanner sc=new Scanner(System.in);
		TASK1 o=new TASK1();
		for(int i=0;i<10;i++) {
			o.addNode(s[i], i);
		}
	}

}
