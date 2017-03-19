package com.lhb.barber.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetUtil {
	/**
	 * List转Set
	 * @param lists
	 * @return
	 */
	public static <T> Set<T> listToSet(List<T> lists){
		Set<T> sets=new HashSet();
		for(T t:lists){
			sets.add(t);
		}
		return sets;
	}
	/**
	 * Set转List
	 * @param sets
	 * @return
	 */
	public static <T> List<T> setToList(Set<T> sets){
		List<T> lists=new ArrayList<>();
		for(T t:sets){
			lists.add(t);
		}
		return lists;
	}
}
