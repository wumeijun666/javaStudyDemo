package opp;

import java.util.*;

/**
 * Copyright: 2022 RockWell Automation Inc.(c)
 * Company: RockWell Automation
 *
 * @Description:
 * @Author: Seven Wu
 * @Time: 2022-06-22 15:20
 */
public class TestRepeat {
	public static void main(String[] args) {
		//判断java对象属性值是否重复
		List<A> aList = new ArrayList<>();
		aList.add(new A("B0001", "90001"));
		aList.add(new A("B0001", "90002"));
		aList.add(new A("B0001", "90001"));
		aList.add(new A("B0002", "90001"));
		Map<String, Set<String>> sapBarCodeMap = new HashMap<>();
		for (int i = 0; i < aList.size(); i++) {
			if (sapBarCodeMap.containsKey(aList.get(i).getBatchNo()) && sapBarCodeMap.get(aList.get(i).getBatchNo()).contains(aList.get(i).getSapBarCode())) {
				System.out.println("重复了"+aList.get(i).getBatchNo()+"  "+aList.get(i).getSapBarCode());
			}else{
				if(!sapBarCodeMap.containsKey(aList.get(i).getBatchNo())){
					sapBarCodeMap.put(aList.get(i).getBatchNo(), new HashSet<>());
				}
				sapBarCodeMap.get(aList.get(i).getBatchNo()).add(aList.get(i).getSapBarCode());
			}

		}
		System.out.println(sapBarCodeMap);
	}

}

class A {
	String batchNo;
	String sapBarCode;

	public A(String batchNo, String sapBarCode) {
		this.batchNo = batchNo;
		this.sapBarCode = sapBarCode;
	}

	@Override
	public String toString() {
		return "A{" +
				"batchNo='" + batchNo + '\'' +
				", sapBarCode='" + sapBarCode + '\'' +
				'}';
	}

	public String getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	public String getSapBarCode() {
		return sapBarCode;
	}

	public void setSapBarCode(String sapBarCode) {
		this.sapBarCode = sapBarCode;
	}
}
