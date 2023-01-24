import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Book } from '../book';
import { AuthServiceService } from '../service/auth-service.service';

@Component({
  selector: 'app-register-book',
  templateUrl: './register-book.component.html',
  styleUrls: ['./register-book.component.css']
})
export class RegisterBookComponent implements OnInit{
  //form: any = {};
book: Book = new Book();

constructor(private authService: AuthServiceService, private router: Router){}

form = new FormGroup(
{
  bookname: new FormControl("",[Validators.required,Validators.minLength(3)]),
  authorname: new FormControl("",[Validators.required,Validators.minLength(3)]),
  bookprice: new FormControl("",[Validators.required,Validators.minLength(2)])
}
);


get f()
{
  return this.form.controls;
}

  ngOnInit(): void {
    throw new Error('Method not implemented.');
  }

  onSubmit()
  {
    this.authService.register(this.book).subscribe(
      data=> {
        console.log('SUCCESSFUL', data);
        this.goToBookList();
      }
    );
  }

  goToBookList()
  {
    this.router.navigate(['/booklist']);
  }

}
