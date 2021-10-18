import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormGroup, Validators, FormBuilder } from '@angular/forms';


@Component({
  selector: 'app-passenger',
  templateUrl: './passenger.component.html',
  styleUrls: ['./passenger.component.css']
})
export class PassengerComponent implements OnInit {
  passForm: FormGroup;
  listData:any;
  fname:Array<string>=[];
  age:Array<number>=[];
  numberOfSeats: number;
  count: number=0;
  constructor(private fb: FormBuilder, private router:Router) { 
    this.listData = [];
    this.numberOfSeats = Number (sessionStorage.getItem("noOfSeats"));
  }
 
  ngOnInit(): void {
    this.passForm = this.fb.group({
   
      fname: ['', Validators.required],
      age:['', Validators.required]

    });
  }
  
    addItem() : void{
      if(this.count <= this.numberOfSeats-1)
        {
          this.listData.push(this.passForm.value);
          this.count++;
          this.passForm.reset();
        }
  
  }

  reset()
  {
    this.passForm.reset();
  }

  removeItem(element)
  {
    this.listData.forEach((value,index) =>{
      if(value==element)
      this.listData.splice(index,1);
    });
  }

  // addPassenger(){
  //   this.fname.push(this.passForm.controls.firstName.value);
  //   this.age.push(this.passForm.controls.age.value);
  //   sessionStorage.setItem("fname", JSON.stringify(this.fname));
  //   sessionStorage.setItem("age", JSON.stringify(this.age));
  //   this.router.navigate(['payment-portal'])
  // }

  paymentProceed()
  {
    this.router.navigate(['payment-portal']);
  }

}
