package br.com.hermes.controller

import br.com.hermes.model.Todo
import br.com.hermes.repository.TodoRepository
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post

@Controller("/todos")
class TodoController (private val todoRepository: TodoRepository){

    @Get
    fun getTodos(): List<Todo>{
        return this.todoRepository.findAll();
    }

    @Post
    fun addTodo(todo: Todo): HttpResponse<Todo> {
        return HttpResponse.created(this.todoRepository.save(todo));
    }
}