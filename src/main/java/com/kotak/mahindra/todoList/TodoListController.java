package com.kotak.mahindra.todoList;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kotak.mahindra.enitity.TodoList;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("api/v1/todo")
@Api(tags = "todo task management", value = "todo task System")

public class TodoListController {
	@Autowired
	private TodoListRepository repository;

	@PostMapping
	@ApiOperation(value = "API For Add Skill in todo List", notes = " This Api for Add Task in todo List")	
	public TodoList create(@RequestBody TodoList todoList) {
		try {
			repository.save(todoList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return todoList;
	}
	@GetMapping
	@ApiOperation(value = "API for get All todo Tasks or List", notes = " This Api is for get all todo list")	
	public List<TodoList> getTodoList(){
		List<TodoList> list= new ArrayList<>();
		try {
			list = repository.findAll();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	@PutMapping("/{todoId}")
	@ApiOperation(value = "API for Update the tasks", notes = "This Api for Updating the task")
	public TodoList update(@RequestBody TodoList todoList,@PathVariable(name="todoId",required = true) long todoId) {
		try {
			todoList.setId(todoId);
			repository.save(todoList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return todoList;
	}
	@DeleteMapping("/{todoId}")
	@ApiOperation(value = "API for Delete the todo tasks", notes = "This API for delete the todo tasks")
	public boolean delete(@PathVariable(name="todoId",required = true) long todoId) {
		try {
			repository.deleteById(todoId);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
