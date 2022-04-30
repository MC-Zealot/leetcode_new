package com.statsMethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NaiveBayes {
	private Map<String, Double> buildModel(List<String> input) {
		// 计算正例和负例的总数
		double count_y1 = 0;
		double count_y0 = 0;
		for (String line : input) {
			String[] ss = line.split("\t");
			String y = ss[2];
			if (Integer.parseInt(y) == 1) {
				count_y1++;
			} else {
				count_y0++;
			}
		}
		System.out.println(count_y0);
		System.out.println(count_y1);
		// 计算频次
		Map<String, Double> map = new HashMap<String, Double>();
		for (String line : input) {
			String[] ss = line.split("\t");
			String x1Key = "x1_" + ss[0] + "\t" + "y_" + ss[2];
			if (!map.containsKey(x1Key)) {
				map.put(x1Key, 1.0);
			} else {
				map.put(x1Key, map.get(x1Key) + 1);
			}

			String x2Key = "x2_" + ss[1] + "\t" + "y_" + ss[2];
			if (!map.containsKey(x2Key)) {
				map.put(x2Key, 1.0);
			} else {
				map.put(x2Key, map.get(x2Key) + 1);
			}
		}

		// 计算条件概率
		for (String key : map.keySet()) {
			String y = key.split("\t")[1].split("_")[1];
			if (y.equals("1")) {
				// System.out.println(key+"\t"+map.get(key)+"\t"+count_y1);
				map.put(key, map.get(key) / count_y1);
			} else {
				// System.out.println(key+"\t"+map.get(key)+"\t"+count_y0);
				map.put(key, map.get(key) / count_y0);
			}
		}
		map.put("y1", count_y1 / (count_y0 + count_y1));
		map.put("y0", count_y0 / (count_y0 + count_y1));
		return map;
	}

	public static void main(String[] args) {
		String s1 = "1\tS\t-1";
		String s2 = "1\tM\t-1";
		String s3 = "1\tM\t1";
		String s4 = "1\tS\t1";
		String s5 = "1\tS\t-1";
		String s6 = "2\tS\t-1";
		String s7 = "2\tM\t-1";
		String s8 = "2\tM\t1";
		String s9 = "2\tL\t1";
		String s10 = "2\tL\t1";
		String s11 = "3\tL\t1";
		String s12 = "3\tM\t1";
		String s13 = "3\tM\t1";
		String s14 = "3\tL\t1";
		String s15 = "3\tL\t-1";
		List<String> input = new ArrayList<String>();
		input.add(s1);
		input.add(s2);
		input.add(s3);
		input.add(s4);
		input.add(s5);
		input.add(s6);
		input.add(s7);
		input.add(s8);
		input.add(s9);
		input.add(s10);
		input.add(s11);
		input.add(s12);
		input.add(s13);
		input.add(s14);
		input.add(s15);

		NaiveBayes nb = new NaiveBayes();
		Map<String, Double> param = nb.buildModel(input);
		System.out.println("=========");
		for (String key : param.keySet()) {
			System.out.println(key + ": " + param.get(key));
		}

		String x = "2\tS";
		// 计算y=1的时候
		double y1_x1 = param.get("x1_" + x.split("\t")[0] + "\t" + "y_1");
		double y1_x2 = param.get("x2_" + x.split("\t")[1] + "\t" + "y_1");
		double y1 = param.get("y1");
		double p1 = y1_x1 * y1_x2 * y1;
		System.out.println(p1);
		// 当y=-1的时候

		double y0_x1 = param.get("x1_" + x.split("\t")[0] + "\t" + "y_-1");
		double y0_x2 = param.get("x2_" + x.split("\t")[1] + "\t" + "y_-1");
		double y0 = param.get("y0");
		double p0 = y0_x1 * y0_x2 * y0;
		System.out.println(p0);
		if (p1 >= p0) {
			System.out.println("是正例");
		} else {
			System.out.println("是负例");
		}

	}
}
