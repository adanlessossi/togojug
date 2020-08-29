import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {todoApi} from '../../todo-api/api/todoRestApi';
import TodoDto = todoApi.TodoDto;

@Injectable({
  providedIn: 'root'
})
export class TodoDataService implements todoApi.TodoController {

  private static readonly url: string = '/todo/api/todo';

  constructor(private httpClient: HttpClient) {
  }

  getAllTodos(): Observable<todoApi.TodoDto[]> {
    return this.httpClient.get<TodoDto[]>(TodoDataService.url);
  }

  deleteTodo(id: string): Observable<void> {
    return this.httpClient.delete<void>(TodoDataService.url + id);
  }

  getTodo(id: string): Observable<todoApi.TodoDto> {
    return this.httpClient.get<todoApi.TodoDto>(TodoDataService.url + id);

  }

  createTodo(todoDto: todoApi.TodoDto): Observable<todoApi.TodoDto> {
    return this.httpClient.post<todoApi.TodoDto>(TodoDataService.url, todoDto);
  }

  getById(id: string): Observable<todoApi.TodoDto> {
    return undefined;
  }

  updateTodo(id: string, todoDto: todoApi.TodoDto): Observable<todoApi.TodoDto> {
    return this.httpClient.put<todoApi.TodoDto>(TodoDataService.url + id, todoDto);
  }
}
