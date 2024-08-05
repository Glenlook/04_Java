package service;

import java.io.IOException;
import java.util.List;

import dto.Todo;

public interface TodoListService {

	public abstract List<Todo> getTodoList();

	public abstract boolean addTodo(String name, StringBuilder detail) throws IOException;

	public abstract List<Todo> selectIndex(int input);

	public abstract String changeBoolean(List<Todo> searchList);

}
