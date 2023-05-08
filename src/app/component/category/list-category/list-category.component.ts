import { Component, OnInit } from '@angular/core';
import { Category } from 'src/app/models/category';
import { CategoryService } from 'src/app/services/category.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-list-category',
  templateUrl: './list-category.component.html',
  styleUrls: ['./list-category.component.scss']
})
export class ListCategoryComponent implements OnInit {

  categories: Category[] = [];

  constructor(private categoryService: CategoryService , private router : Router) { }

  ngOnInit(): void {
    this.loadCategories();
  }

  loadCategories(): void {
    this.categoryService.getCategorys().subscribe(
      categories => {
        this.categories = categories;
        console.log("Categories loaded successfully.");
      },
      error => console.log(error)
    );
  }

  deleteCategory(id: number): void {
    if (confirm("Are you sure you want to delete this category?")) {
      this.categoryService.removeCategory(id).subscribe(
        response => {
          console.log("Category deleted successfully.");
          this.loadCategories();
        },
        error => console.log(error)
      );
    }
  }
  UpdateCategory(id: number) {
    this.router.navigate(['/edit-category',id]);
  }
  

}
