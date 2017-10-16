package program; 

import java.io.File;  
import java.io.BufferedReader;  
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import program.line;

public class Test1 {
	
	private static String[] str = null;
	private static String[][] str1 = null;
	private static ArrayList<line> G;
	
	public static String txt2String(File file){
        StringBuilder result = new StringBuilder();
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader类来读取文件
            String s = null;
            while((s = br.readLine())!=null){//使用readLine方法，一次读一行
                result.append(s);
            }
            br.close();    
        }catch(Exception e){
            e.printStackTrace();
        }
        return result.toString();
    }

    public static void main(String[] args){
    	line myline;
    	line before;
    	String txt,word1,word2,inputText;
    	Integer a;
    	do {
    		System.out.print("1.展示有向图\n2.查询桥接词(bridge words)\n3.根据bridge word生成新文本\n4.计算两个单词之间的最短路径\n5.随机游走\n");
            Scanner sc = new Scanner(System.in);
    	    a = sc.nextInt();
    	    switch (a){
    	     	case 1:
    	     		System.out.print("展示有向图\n");
    	     		showDirectedGraph();
    	     		break;
    	     	case 2:
    	     		System.out.print("查询桥接词(bridge words)\n");
    	     		word1=sc.next();
    	     		word2=sc.next();
    	     		queryBridgeWords(word1,word2);
    	     		break;
    	     	case 3:
    	     		System.out.print("根据bridge word生成新文本\n");
    	     		inputText=sc.nextLine();
    	     		generateNewText(inputText);
    	     		break;
    	     	case 4:
    	     		System.out.print("计算两个单词之间的最短路径\n");
    	     		break;
    	     	case 5:
    	     		System.out.print("随机游走\n");
    	     		break;
    	     	default:
    	     		System.out.print("再见\n");
    	     		break;
    	     }
    	}while(a!=0);
    	
        File file = new File("H:/text.txt");
        txt=txt2String(file).replaceAll("\\pP", " ");
        str=txt.split(" +");
        //System.out.print(txt);
        System.out.print(str.length);
        str1=new String[str.length][3]; 
        for (int i=0;i<str.length;i++) {
        	for (int l=0;l<3;l++) {
        		if (i+l<str.length) {
        			str1[i][l]=str[i+l];
        		}
        		else {
        			str1[i][l]="0";
        		}
        	}
        }
        for (int i=0;i<str.length;i++) {
        	System.out.print("\n");
        	for (int l=0;l<3;l++) {
        		System.out.print(" ");
        		System.out.print(str1[i][l]);
        	}
        }
        
    }
	public static void queryBridgeWords(String word1, String word2) {
    	for (int i=0;i<str.length;i++) {
			if(word1==str1[i][0]) {
    			if(word2==str1[i][2]) {
    				System.out.print(str1[i][1]);
    			}	
    		}
    	}
    }
	public static void generateNewText(String inputText) {
		String[] line1 = inputText.split(" ");
		for(int q=0;q<line1.length-1;q++){
			 for (int i=0;i<str.length;i++){
				if(line1[q]==str1[i][0] && line1[q+1]==str1[i][2]) {
					System.out.print(line1[q]+str1[i][1]);
				}
				else {
					System.out.print(line1[q]);
				}
			}
			 System.out.print(line1[line1.length-1]); 
		}
	}
	static void showDirectedGraph() {
		HashMap map = new HashMap();
		for (int i=0;i<str.length;i++) {
			if(map.containsKey(str1[i][0]+str1[i][1])) {
				Integer value = (int)map.get(str1[i][0]+str1[i][1])+1;
				map.remove(str1[i][0]+str1[i][1]);
				map.put(str1[i][0]+str1[i][1], value);
			}
			else {
				map.put(str1[i][0]+str1[i][1],1);
			}
		}
		map.entrySet();
	}
	String calcShortestPath(String word1, String word2) {
		return word2;
	}
	String randomWalk() {
		return null;
	}
    
}

