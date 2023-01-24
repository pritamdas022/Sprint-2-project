import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BookListComponent } from './book-list/book-list.component';
import { HomeComponent } from './home/home.component';
import { RegisterBookComponent } from './Add book Details/register-book.component';

const routes: Routes = [
  {path:"booklist", component: BookListComponent},
  {path:"home", component: HomeComponent},
  {path:"createbook", component:RegisterBookComponent},
  {path:" ", redirectTo:"/home"}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
