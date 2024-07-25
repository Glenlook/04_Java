package pkg3.dto;

// 인터페이스 상속 키워드 : implements (구현하다)

public class YJSCalculator implements Calculator{

	@Override
	public int plus(int a, int b) {
		if((a + b) < MIN_NUM) {
			int result = MIN_NUM;
			return result;
		}
		if((a + b) > MAX_NUM) {
			int result = MAX_NUM;
			return result;
		} else {
			int result = a + b;
			return result;
		}
	}

	@Override
	public int minus(int a, int b) {
		if((a - b) < MIN_NUM) {
			int result = MIN_NUM;
			return result;
		}
		if((a - b) > MAX_NUM) {
			int result = MAX_NUM;
			return result;
		} else {
			int result = a - b;
			return result;
		}
	}

	@Override
	public int multi(int a, int b) {
		if((a * b) < MIN_NUM) {
			int result = MIN_NUM;
			return result;
		}
		if((a * b) > MAX_NUM) {
			int result = MAX_NUM;
			return result;
		} else {
			int result = a * b;
			return result;
		}
	}

	@Override
	public int div(int a, int b) {
		if((a / b) < MIN_NUM) {
			int result = MIN_NUM;
			return result;
		}
		if((a / b) > MAX_NUM) {
			int result = MAX_NUM;
			return result;
		} else {
			int result = a / b;
			return result;
		}
	}

	@Override
	public int mod(int a, int b) {
		if((a % b) < MIN_NUM) {
			int result = MIN_NUM;
			return result;
		}
		if((a % b) > MAX_NUM) {
			int result = MAX_NUM;
			return result;
		} else {
			int result = a % b;
			return result;
		}
	}

	@Override
	public int pow(int a, int x) {
		// 거듭 제곱
		int result = 1;
		for(int i = 0; i < x; i++) {
			result *= a;
		}
		return result;
	}

	@Override
	public double areaOfCircle(double r) {
		return Calculator.PI * r * r;
	}

	@Override
	public String toBinary(int num) {
		String result = Integer.toBinaryString(num);
		return result;
	}

	@Override
	public String toHexadecimal(int num) {
		String result = Integer.toHexString(num);
		return result;
	}
	
}
