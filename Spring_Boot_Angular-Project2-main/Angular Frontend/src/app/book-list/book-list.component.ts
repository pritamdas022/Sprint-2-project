import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { Book } from '../book';
import { AuthServiceService } from '../service/auth-service.service';

@Component({
  selector: 'app-book-list',
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.css']
})
export class BookListComponent implements OnInit{

  book: Book[] | undefined;

  constructor (private authService: AuthServiceService, private router: Router){}

  ngOnInit(): void {
    this.getBook();
  }

  private getBook()
  {
    this.authService.getAllBook().subscribe(
      data=>{
        this.book=data;
      }
    );
  }

  deleteBook(id: number)
  {
    this.authService.deleteBookById(id).subscribe(
      data=>
      {
        console.log(data);
        window.location.reload();
      }
    );
  }

  
    
}
