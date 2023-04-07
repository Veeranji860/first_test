package com.user.registration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import com.google.common.base.Predicate;
interface veera{
	//abstract void m1();
	default void m2() {
		System.out.println("Inside m2");
	}
}

interface naga{
	default void m3() {
		/*
		hey erri where i put  loggers here
		*/
		System.out.println("Inside m3");
		System.out.println("Inside m3");
		System.out.println("Inside m3");System.out.println("Inside m3");
	}
}
class Solution implements veera {
	public void get(String[] names) {
		for(int i=0;i<names.length;i++) {
			System.out.println(checkPalindrome(names[i]));
		}
	}@Override
	public void m2() {
		// TODO Auto-generated method stub
		System.out.println("Inside Class");
	}
	public void ve() {
		System.out.println("M1 reference");
	}
	public void ve1() {
		System.out.println("default reference");
	}
	public void swap(int a,int b) {
		b=a+b;//1+2
		a=b-a;//3-1
		b=b-a;//3-1
		System.out.println(a+"======>"+b);
	}
	public void duplicateChars(String s) {
		String[] s1= {"Apple","Mango","Apple","Orange","Orange"};
		/*
		 * Map<String, Long> occurrences = Arrays.stream(s1)
		 * .collect(Collectors.groupingBy(st -> st,
		 * Collectors.counting())).entrySet().stream().max(Map.Entry.comparingByValue())
		 * .get() .getKey());
		 */
		/*
		 * String maxOccurredString = occurrences.entrySet().stream()
		 * .max(Map.Entry.comparingByValue()) .get() .getKey();
		 */
		Array<String> ar=new Array<>();
		ar.add("Veera");
		BiFunction<Integer, Integer,Integer> biFunction=(a,b)->{return a+b;};
		
		System.out.println(biFunction.apply(1, 2));
		BiConsumer<Integer,Integer> biConsumer=(a,b)->System.out.println(a+b);
		biConsumer.accept(1, 2);
		BiPredicate<Integer, Integer> biPredicate=(a,b)->a==b;
		Predicate<Integer> pred=(a)->a==2;
		pred.apply(2);
		if(biPredicate.test(1, 2)) {
			System.out.println("If block");
		}else {
			System.out.println("else block");
		}
		Supplier<Integer> suppliers=()->1;
		suppliers.get();
		System.out.println("Veera"+ar);
		Character key = s.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(st -> st, Collectors.counting())).entrySet().stream().max(Map.Entry.comparingByValue())
        .get()
        .getKey();
		String result = Arrays.stream(s1)
                .reduce("", (a, b) -> a + b);
        System.out.println("Max occurred string: " + result);
        System.out.println("Max occurred string veera: " + key);
		/*
		 * Map<String, Long>
		 * map1=Arrays.stream(s1).mapToLong(c->(Long)c).collect(Collectors.groupingBy(c-
		 * >c,Collectors.counting())); map.forEach((k,v)->{ if(v>1) {
		 * System.out.println(k+"   "+v); } });
		 */
		
		char[] ch=s.toCharArray();
		Map<Character,Integer> mapList=new HashMap<>();
		System.out.println(mapList.size());
		for(int i=0;i<ch.length;i++) {
			if(mapList.size()==0) {
				mapList.put(ch[i], 1);
			}else {
				if(mapList.containsKey(ch[i])) {
					mapList.put(ch[i], mapList.get(ch[i])+1);
				}else {
					mapList.put(ch[i], 1);
				}
			}
		}
		System.out.println(mapList);
		for (Map.Entry<Character,Integer> d : mapList.entrySet()) {
			if(d.getValue()>1) {
				System.out.println(d.getKey()+"::::"+d.getValue());
			}
		}
	}
	public void getWord(String word,String sentence) {
		String[] split = sentence.split(" ");
		boolean fa=true;
		for(int i=0;i<split.length;i++) {
			if(word.equals(split[i])) {
				//fa=false;
				System.out.println("Word available");
				break;
			}
		}
		
	}

	private boolean checkPalindrome(String string) {
		int i=0;
		int j=string.length()-1;
		while(i<j) {
			if(string.charAt(i)!=string.charAt(j)) {
				return false;
			}else {
				i++;
				j--;
			}
		}
		return true;
	}
	
}

public class Test {

	public static void main(String[] args) {
		Solution so = new Solution();
		veera v1= new Solution();
		v1.m2();
		int[] nums = { 4, 2, 1, 1 };
		String[] name={"a","John","Emma"};
		int[] height={180,165,170};
		so.get(name);
		so.swap(10, 20);
		so.duplicateChars("Veerraa");
		so.getWord("Veera", "Hi This is");

	}

}
