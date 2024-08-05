package service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import dao.TodoListDao;
import dao.TodoListDaoImpl;
import dto.Todo;

public class TodoListServiceImpl implements TodoListService{

	private TodoListDao dao = null;
	
	public TodoListServiceImpl() throws FileNotFoundException, ClassNotFoundException, IOException {
		dao = new TodoListDaoImpl();
	}
	
	@Override
	public List<Todo> getTodoList() {
		return dao.getTodoList();
	}
	
	@Override
	public boolean addTodo(String name, StringBuilder detail) throws IOException {
		List<Todo> todoList = dao.getTodoList();
		for(Todo todo : todoList) {
			if(name.equals(todo.getTitle())) {
				return false;
			}
		}
		Todo todo = new Todo(name, detail, 1, LocalDateTime.now());
		boolean result = dao.addTodo(todo);
		return result;
	}
	
	@Override
	public List<Todo> selectIndex(int input) {
		List<Todo> todoList = dao.getTodoList();
		List<Todo> searchList = new ArrayList<Todo>();
		
		for(int i = 0; i < todoList.size(); i++) {
			if(i == input) searchList.add(todoList.get(i));
		}
		return searchList;
	}
	
	@Override
	public String changeBoolean(List<Todo> searchList) {
		if(searchList.get(0).getComplete() == 1) searchList.get(0).setComplete(0);
		else searchList.get(0).setComplete(1);
		StringBuilder sb = new StringBuilder();
		sb.append("변경되었습니다");
		return sb.toString();
	}
}
