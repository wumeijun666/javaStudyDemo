package cglibTestxinda;

public class ReceiveMaterialService {


	@APISpec(code = "MDM2001", tables = {"Part", "AT_MM_Material_Umc"})
	public void receiveMaterial(String str, int int2) {
		System.out.println("模拟信达业务11" + str + int2);
	}

}
