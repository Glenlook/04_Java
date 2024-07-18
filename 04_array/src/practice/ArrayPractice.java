package practice;

import java.util.Scanner;

public class ArrayPractice {
	
	Scanner sc = new Scanner(System.in);
	
	
	/* [실습 문제 1]
		길이가 9인 배열을 선언 및 할당하고, 
		1부터 9까지의 값을 반복문을 이용하여
		순서대로 배열의 각 인덱스 요소에 대입하고 출력한 후
		짝수 번째 인덱스 값의 합을 출력하세요. 
		(0 번째 인덱스는 짝수로 취급)
	*/
	public void practice1(){
		int[] arr = new int[9];
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = i + 1;
		}
		
		int sum = 0;
		
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
			
			if(i % 2 == 0) {
				sum += arr[i];
			}
		}
		
		System.out.println("\n짝수 번째 인덱스 합 : " + sum);
	}
	
	/* [실습 문제 2]
	    길이가 9인 배열을 선언 및 할당하고, 9부터 1까지의 값을 반복문을 이용하여
        순서대로 배열의 각 인덱스 요소에 대입하고 출력한 후
        홀수 번째 인덱스 값의 합을 출력하세요. (0 번째 인덱스는 짝수로 취급)
	*/
	public void practice2() {
		int[] arr = new int[9];
		
		int sum = 0;
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = arr.length - i;
			System.out.print(arr[i] + " ");
			if(i % 2 == 1) {
				sum += arr[i];
			}
		}
		System.out.println("\n홀수 번째 인덱스 합 : " + sum);
		
		System.out.println("-------------------------------");
		
		int[] arr2 = new int[9];
		
		int sum2 = 0;
		
		// 대입은 역방향
		for(int i = arr2.length - 1 ; i >= 0 ; i--) {
			arr2[i] = arr2.length - i;
			if(i % 2 == 1)  sum2 += arr2[i];
		}
		
		// 출력은 정방향
		for(int num : arr2) {
			System.out.print(num + " ");
		}
		
		System.out.println("\n홀수 번째 인덱스 합 : " + sum2);
	}
	
	/* [실습 문제 3]
	    사용자에게 입력 받은 양의 정수만큼 배열 크기를 할당하고
        1부터 입력 받은 값까지 배열에 초기화한 후 출력하세요.
	*/
	public void practice3() {
		System.out.print("배열 길이 입력 : ");
		int num = sc.nextInt();
		
		int[] arr = new int[num];
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = i + 1;
			System.out.print(arr[i] + " ");
		}	
	}
	
	/* [실습 문제 4]
	    정수 5개를 입력 받아 배열을 초기화 하고
        검색할 정수를 하나 입력 받아 배열에서 같은 수가 있는 인덱스를 찾아 출력.
        배열에 같은 수가 없을 경우 “일치하는 값이 존재하지 않습니다“ 출력
	*/
	public void practice4() {
		int[] arr = new int[5];
		
		for(int i = 0; i < arr.length; i++) {
			System.out.printf("입력 %d : ", i);
			arr[i] = sc.nextInt();
		}
		
		System.out.print("검색할 값 : ");
		int ran = sc.nextInt();
		
		boolean flag = true; // if문 실행된적 없음
		
		for(int i = 0; i < arr.length; i++) {
			if(ran == arr[i]) {
				System.out.printf("인덱스 : %d", i);
				flag = false;
			}
		}
		
		if(flag) {
			System.out.print("일치하는 값이 존재하지 않습니다.");
		}
	}
	
	/* [실습 문제 5]
	    사용자가 배열의 길이를 직접 입력하여 그 값만큼 정수형 배열을 선언 및 할당하고
        배열의 크기만큼 사용자가 직접 값을 입력하여 각각의 인덱스에 값을 초기화 하세요.
        그리고 배열 전체 값을 나열하고 각 인덱스에 저장된 값들의 합을 출력하세요.
	*/
	public void practice5() {
		System.out.print("입력 : ");
		int num = sc.nextInt();
		
		int[] arr = new int[num];
		int sum = 0;
		
		for(int i = 0; i < arr.length; i++) {
			System.out.printf("배열 %d번째 인덱스에 넣을 값 : ", i);
			arr[i] = sc.nextInt();
			sum += arr[i];
		}
		
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		
		System.out.println();
		
		System.out.printf("총 합 : %d", sum);
	}
	
	public void practice6() {
		char[] arr = new char[14];
		System.out.print("주민등록번호(-포함) : ");
		String str = sc.next(); 
		
		for(int i = 0; i < str.length();i++) {
			arr[i] = str.charAt(i);
			if(i <= 7) arr[i] = str.charAt(i);
			else       arr[i] = '*';
			
			System.out.print(arr[i]);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

