package br.com.hamamoto.sorting;

import java.util.Map;
import java.util.TreeMap;

public class CountingSorter implements Sorter {
    @Override
    public void sort(int[] arr) {
        Map<Integer, Integer> map = new TreeMap<>();

        for (var i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(i, 0) + 1);
        }

        var keys = map.keySet();

        var n = 0;
        for (var k : keys) {
            for (var i = 0; i < map.get(k); i++) {
                arr[n] = k;
                n++;
            }
        }


    }
}
