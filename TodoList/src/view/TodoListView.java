package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import dto.Todo;
import service.TodoListService;
import service.TodoListServiceImpl;

public class TodoListView {
	private TodoListService service = null;
	private BufferedReader br = null;
	
	public TodoListView() {
		try {
			service = new TodoListServiceImpl();
			
			br = new BufferedReader(new InputStreamReader(System.in));
		} catch(Exception e) {
			System.out.println("*** 프로그램 실행 중 오류 발생 ***");
			e.printStackTrace();
			System.exit(0);
		}
	}
	
	public void mainMenu() {
		int input = 0;
		do {
			
			try {
				input = selectMenu();
				
				switch(input) {
				case 1: fullView(); break;
				case 2: detailView(); break;
				case 3: addTodo(); break;
				case 4: completeTodo(); break;
				case 5: break;
				case 6: break;
				case 0: System.out.println("*** 프로그램 종료 ***"); break;
				default : System.out.println("### 메뉴에 작성된 번호만 입력해주세요 ###");
				}
				
						
			} catch(NumberFormatException e) {
				System.out.println("\n### 숫자만 입력해주세요 ###\n");
				input = -1;
				
			} catch(IOException e) {
				System.out.println("\n### 입출력 관련 예외 발생 ###\n");
				e.printStackTrace();
				
			} catch(Exception e) {
				e.printStackTrace();
			}
		} while(input != 0);
	}
	
	private int selectMenu() throws NumberFormatException, IOException {
		
		System.out.println("\n===== Todo List =====\n");
		System.out.println("1. Todo List Full View");
		System.out.println("2. Todo Detail View");
		System.out.println("3. Todo Add");
		System.out.println("4. Todo Complete");
		System.out.println("5. Todo Update");
		System.out.println("6. Todo Delete");
		System.out.println("0. EXIT");
		
		System.out.print("메뉴 선택 >>> ");
		
		int input = Integer.parseInt(br.readLine());
		System.out.println();
		
		return input;
	}
	
	private void fullView() {
		System.out.println("\n\n===============[1. Todo List Full View]===============\n\n");
		List<Todo> todoList = service.getTodoList();
		
		if(todoList.isEmpty()) {
			System.out.println("\n### List is empty ###\n");
			return;
		}
		
		String[] completeArr = {"O", "X"};
		
		System.out.println("[ 완료된 Todo 개수 / 전체 Todo 수 : 4 / 4 ]");
		System.out.println("--------------------------------------------------------------");
		System.out.printf("%-5s %-7s %s %4s\n", "인덱스", "등록일", "완료 여부", "할 일 제목");
		System.out.println("--------------------------------------------------------------");
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		
		for(int i = 0; i < todoList.size(); i++) {
			String s1 = todoList.get(i).getRegDate().format(formatter);
			String s2 = todoList.get(i).getTitle();
			String s3 = completeArr[todoList.get(i).getComplete()];
			System.out.printf("[%d] %-12s %8s %5s \n", i, s1, s3, s2);
		}
		
	}
	
	private void detailView() throws IOException {
		System.out.println("\n===============[2. Todo Detail View]===============\n");
		System.out.print("인덱스 번호 입력 : ");
		int input = Integer.parseInt(br.readLine());
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		
		List<Todo> searchList = service.selectIndex(input);
		
		String[] completeArr = {"O", "X"};
		
		if(searchList.isEmpty()) {
			System.out.println("\n### wrong index number try again ###\n");
			return;
		}
		
		for(Todo todo : searchList) {
			System.out.println("-----------------------------------------------");
			System.out.printf("제목 : %s\n", todo.getTitle());
			System.out.printf("등록일 : %s\n", todo.getRegDate().format(formatter));
			System.out.printf("완료여부 : %s\n\n", completeArr[todo.getComplete()]);
			System.out.println("[세부 내용]\n---------------------------------------------");
			System.out.println(todo.getDetail());
		}
	}
	
	private void addTodo() throws IOException{
		System.out.println("\n==========[3. Todo Add]==========\n");
		System.out.print("할 일 제목 입력 : ");
		String name = br.readLine();
		
		StringBuilder detail = new StringBuilder();
		System.out.print("세부 내용 작성 (입력 종료 시 !wq 작성 후 엔터)\n------------------------------------------------------\n");
		while (true) {
			String sb = br.readLine();
			if(sb.equals("!wq")) break;
			
			detail.append(sb);
			detail.append("\n");
		}
		
		boolean result = service.addTodo(name, detail);
		List<Todo> todoList = service.getTodoList();
		
		if(result) {
			System.out.println("-----------------------------------------------");
			System.out.printf("[%d] 인덱스에 추가 되었습니다", todoList.size() -1);
		} else {
			System.out.println("중복된 이름입니다.");
		}
	}
	
	private void completeTodo() throws NumberFormatException, IOException {
		System.out.println("\n==========[4. Todo Complete]==========\n\n");
		System.out.print("O <-> X 변경할 인덱스 번호 입력 : ");
		int input = Integer.parseInt(br.readLine());
		
		List<Todo> searchList = service.selectIndex(input);
		
		String result = service.changeBoolean(searchList);
		
		System.out.println(result);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
