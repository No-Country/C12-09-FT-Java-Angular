import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SharedService {
  private categorySelectedSource = new Subject<string>();
  categorySelected$ = this.categorySelectedSource.asObservable();

  constructor() {}

  selectCategory(category: string){
    this.categorySelectedSource.next(category);
  }
}