import { Moment } from 'moment';
import {Observable} from 'rxjs';

// tslint:disable-next-line:no-namespace
export namespace todoApi {

  export interface TodoDto {
    username: string;
    description: string;
    targetDate: Moment;
    isDone: boolean;
  }

  export interface TodoController {
    getAllTodos(): Observable<TodoDto[]>;
    getById(id: string): Observable<TodoDto>;
    createTodo(todoDto: TodoDto): Observable<TodoDto>;
    deleteTodo(id: string): Observable<void>;
    updateTodo(id: string, todoDto: TodoDto): Observable<TodoDto>;
  }
}
