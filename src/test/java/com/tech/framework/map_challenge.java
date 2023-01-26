package com.tech.framework;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

public class map_challenge {
	public Map<String, Integer> countWords(String words){
		// parse the sentence using a space as the delimiter
		// count how many times each word exists in the sentence and return the object that contains the words and count
		Map<String, Integer> hm = new HashMap<String, Integer>();
		String[] wordsArr = words.split("\\s");
		for(int i=0;i<wordsArr.length-1;i++) {
			if(!(hm.containsKey(wordsArr[i]))) {
				hm.put(wordsArr[i], 1);
			}else if(hm.containsKey(wordsArr[i])) {
				Integer intCount = hm.get(wordsArr[i]);
				hm.put(wordsArr[i], intCount+1);
			}
		}
		return hm;
	}

	@Test
	public void test1(){
		String sentence = "I'm trying to make a program on word count which I have partially made and it is giving the correct result but the moment I enter space or more than one space in the string, the result of word count show wrong results because I am counting words on the basis of spaces used. I need help if there is a solution in a way that no matter how many spaces are I still get the correct result. I'm mentioning the code below.";
		Assert.assertEquals(7, (countWords(sentence).get("the").intValue()));
	}

	@Test
	public void test2(){
		String sentence = "3 3 3 4 4 4 4 5 5 5 5 5 6 6 6 6 6";
		Assert.assertEquals(5, (countWords(sentence).get("5").intValue()));
	}

	@Test
	public void test3(){
		String sentence = "a B c b d e a b b B B B a b";
		Assert.assertEquals(1, (countWords(sentence).get("e").intValue()));
	}

}
