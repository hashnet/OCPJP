package a;

import java.util.*;
import java.util.function.*;

public class MapTest {
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<>();
		map.put("SAM", null);
		map.put("TOM", "SON");
		System.out.println(map);
		
		BiFunction<String, String, String> remap = (v1, v2) -> null;
		String sam = map.merge("SAM", "Father", remap);
		String tom = map.merge("TOM", "Grand Father", remap);
		
		System.out.println(sam);
		System.out.println(tom);
		System.out.println(map);
	}
}
