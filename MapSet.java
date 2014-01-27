/*
given Map<K,V> hashMap and Set<K> hashSet, if hashMap contains same key 
as that in hashSet, delete from hashMap the element corresponding to the key, 
return the modified hashMap.
*/

package mapSetTest;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MapSet<K,V> {
	public Map<K,V> modifyMap(Map<K,V> hashMap, Set<K> hashSet){
		for(K key:hashSet)
			//if(hashMap.keySet().contains(key))//not necessary
				hashMap.remove(key);
		return hashMap;
	}
	
/*	The following code will throw java.util.ConcurrentModificationException,
 	because during iteration, the keySet is not allowed to change by method
 	other than the own method of the iterator. 
	public Map<K,V> modifyMap(Map<K,V> hashMap, Set<K> hashSet){
		for(K key:hashMap.keySet())
			if(hashSet.contains(key))
				hashMap.remove(key);
		return hashMap;
	}*/
	public static void main(String[] args){
		Map<String, Integer> hashMap=new HashMap<String, Integer>();
		hashMap.put("s1",1);
		hashMap.put("s2",2);
		hashMap.put("s3",3);
		Set<String> hashSet=new HashSet<String>();
		hashSet.add("s2");
		
		System.out.println(hashMap);
		Map<String, Integer> map=
				new MapSet<String, Integer>().modifyMap(hashMap,hashSet);
		System.out.println(map);
	}
}

/*output:
{s2=2, s1=1, s3=3}
{s1=1, s3=3}*/

