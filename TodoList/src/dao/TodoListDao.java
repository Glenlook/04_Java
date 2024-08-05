package dao;

import java.io.IOException;
import java.util.List;

import dto.Todo;

public interface TodoListDao {

	List<Todo> getTodoList();
	
	boolean addTodo(Todo todo) throws IOException;
	
	void saveFile() throws IOException;
}
