import { ProductCategory } from 'src/app/common/product-category';
import { ProductService } from './../../service/product.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-producat-category-menu',
  templateUrl: './producat-category-menu.component.html',
  styleUrls: ['./producat-category-menu.component.css']
})
export class ProducatCategoryMenuComponent implements OnInit{

  productCategories: ProductCategory[] = [];

  constructor(private productService: ProductService){}

  ngOnInit(): void {
    this.listProductCategories() ; 
  }

  listProductCategories(){
    this.productService.listProductCategories().subscribe(
      data => {
        this.productCategories = data;
        console.log("data: ", data);
      }
    )
  }

}
