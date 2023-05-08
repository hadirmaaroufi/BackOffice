import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router  } from '@angular/router';
import { Category } from 'src/app/models/category';
import { CategoryService } from 'src/app/services/category.service';

@Component({
  selector: 'app-edit-category',
  templateUrl: './edit-category.component.html',
  styleUrls: ['./edit-category.component.scss']
})
export class EditCategoryComponent implements OnInit {

  categoryId!: number;
  category!: Category;

  constructor(
    private route: ActivatedRoute,
    private categoryService: CategoryService,
    private router: Router,
  
  ) { }

  ngOnInit(): void {
    this.categoryId = parseInt(this.route.snapshot.paramMap.get('id') ?? '0');
    this.loadCategory();
  }

  loadCategory(): void {
    this.categoryService.retrieveCategory(this.categoryId).subscribe(
      category => {
        this.category = category;
        console.log("Category loaded successfully.", category);
      },
      error => console.log(error)
    );
  }

   updateCategory(): void {
    this.categoryService.updateCategory(this.category).subscribe(
      response => {
        console.log("Category updated successfully.", response);
        this.router.navigate(['/category-list']);
      },

      error => console.log(error)
    );
  }

}
