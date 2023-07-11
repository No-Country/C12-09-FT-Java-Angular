import { Component, VERSION, ViewChild, ElementRef, Renderer2, HostListener } from "@angular/core";

@Component({
  selector: 'app-carousel-product',
  templateUrl: './carousel-product.component.html',
  styleUrls: ['./carousel-product.component.css']
})
export class CarouselProductComponent {

  private divWidth!: number;
  private divHeight!: number;

  name = "Angular " + VERSION.major;

  @ViewChild('myContainer', { static: true }) myContainer!: ElementRef;
 
  

  @ViewChild('mySlider', { static: true }) mySlider!: ElementRef;
  @ViewChild('buttonLeft', { static: true }) buttonLeft!: ElementRef;
  @ViewChild('buttonRight', { static: true }) buttonRight!: ElementRef;

  // @HostListener('document:click', ['$event'])
  // onClick(event: MouseEvent): void {
  //      if (this.buttonLeft.nativeElement.contains(event.target )){
          
  //         console.log('hola')
  //     } else{
  //        console.log('adios')
  //     }
        
        
      

  // }

  @HostListener('window:resize')
  onWindowResize(){
    this.medirMycontainer();
  }

constructor(private renderer2:Renderer2,private elem: ElementRef) {
}

ngOnInit(){
  const divElement = this.myContainer.nativeElement;
  const redimension = divElement.getBoundingClientRect();
  const width = redimension.width;
  const height = redimension.height;

  console.log('Ancho:', width);
  console.log('Alto:', height);

  this.medirMycontainer();
}

medirMycontainer(){
  const divElement = this.myContainer.nativeElement;
  const redimension = divElement.getBoundingClientRect();

  this.divWidth = redimension.width;
  this.divHeight = redimension.height;

  console.log("ancho es rise",this.divWidth)
  console.log("alto es rise",this.divHeight)

}


setNext(){
 
}

setBack(){

}
  
}
