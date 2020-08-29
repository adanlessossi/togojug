import { Component, OnInit } from '@angular/core';
import { TodoDataService } from '../service/data/todo-data.service';
import { Todo } from '../list-todos/list-todos.component';
import { ActivatedRoute, Router } from '@angular/router';
import {todoApi} from "../todo-api/api/todoRestApi";
import TodoDto = todoApi.TodoDto;

@Component({
  selector: 'app-todo',
  templateUrl: './todo.component.html',
  styleUrls: ['./todo.component.css']
})
export class TodoComponent implements OnInit {

  todo: TodoDto
  todos: TodoDto[];
  id: string

  constructor(private todoService: TodoDataService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit() {

    this.id = this.route.snapshot.params['id'];
    if (this.id){
      this.todoService.getById(this.id).subscribe(todo => {
        this.todo = todo;
      })
    }

    this.todoService.getAllTodos().subscribe(todos => {
      this.todos = todos;
    });
      // this.todoService.getTodo(this.id).subscribe(
      //   data => {
      //     this.todo = data;
      //   }
      // )
  }

  saveTodo() {
      // Create todo
      this.todoService.createTodo(this.todo).subscribe(
        data => {
          this.router.navigate(["todos"])
        }
      )
    }

    updateTodo(){
      this.todoService.updateTodo(this.id, this.todo).subscribe(
        data => {
          this.router.navigate(["todos"])
        }
      )
    }
}
