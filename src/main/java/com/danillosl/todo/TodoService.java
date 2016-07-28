package com.danillosl.todo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Component;

@Component
public class TodoService {

	private Map<String, TodoModel> todoModels = new HashMap<>();

	public TodoService() {

		this.save(new TodoModel("formatar computador", "Formatar computadores da empresa"));
		this.save(new TodoModel("Organizar repositorio", "Organizar repositorio github"));

	}

	public TodoModel save(TodoModel todoModel) {

		if (todoModel == null) {
			throw new IllegalArgumentException("todo não pode ser null");
		}

		if (todoModel.getId() == null) {
			// adiciona uuid se o todo model for novo.
			todoModel.setId(UUID.randomUUID().toString());
		}

		return todoModels.put(todoModel.getId(), todoModel);
	}

	public boolean delete(String id) {

		return todoModels.remove(id) != null;

	}

	public List<TodoModel> list() {
		return new ArrayList<TodoModel>(todoModels.values());
	}

	public TodoModel findById(String id) {
		return this.todoModels.get(id);
	}

}
