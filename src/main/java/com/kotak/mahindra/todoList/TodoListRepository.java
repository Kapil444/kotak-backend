package com.kotak.mahindra.todoList;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kotak.mahindra.enitity.TodoList;

public interface TodoListRepository extends JpaRepository<TodoList, Long>{

}
