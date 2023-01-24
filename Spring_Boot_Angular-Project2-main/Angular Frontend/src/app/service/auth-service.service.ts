import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import { Observable } from 'rxjs';
import { Book } from '../book';

const REGISTER = 'http://localhost:8080/api/';
//const deleteEmployee = 'http://localhost:8080/api/deleteBookById/';

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable({
  providedIn: 'root'
})


export class AuthServiceService {

  constructor(private http: HttpClient) { }

getAllBook(): Observable<Book[]>
{
  return this.http.get<Book[]>(REGISTER+ 'getAllBook', httpOptions);
}

register(book: Book): Observable<Book>
{
  return this.http.post<Book>(REGISTER+ 'createBook',book,httpOptions);
}

deleteBookById(id: number): Observable<Object>
{
  return this.http.delete(`${REGISTER+'deleteBookById'}/${id}`);
}

}
