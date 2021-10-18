import { Router } from '@angular/router';
import { RegisterService } from './../register.service';
import { Register } from './Register';
import { Component, OnInit } from '@angular/core';
import { FormGroup, Validators, FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  userForm: FormGroup;
  customers: Register[];
  constructor(private fb: FormBuilder, private service:RegisterService, private router:Router) { 
    this.customers=new Array();
  }
passValue:string;
cpassValue:string;

  ngOnInit(): void {
    this.userForm = this.fb.group({
     
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      // emailId: ['', Validators.email],
      emailId: ['',Validators.required],
      phoneNo:['', Validators.required],
      pass:['', Validators.required],
      Cpass:['', Validators.required],
      DOB:['', Validators.required],
      gender:['', Validators.required],

    });

    this.service.getRegistration().subscribe(data=>{
      this.customers = data;
    });
}
newReg:boolean = true;
addCustomer(): void {
  
  let cust:Register = new Register( 
    this.userForm.controls.firstName.value, 
    this.userForm.controls.lastName.value,this.userForm.controls.emailId.value,this.userForm.controls.phoneNo.value,
    this.userForm.controls.pass.value,this.userForm.controls.DOB.value,this.userForm.controls.gender.value
    )
    
    for (let index = 0; index < this.customers.length; index++) {
      if(this.userForm.controls.emailId.value==this.customers[index].emailId){
        this.newReg = false;
        break;
      }
    }
   if(this.newReg==true){
    this.service.addRegistration(cust).subscribe(data=>{
      //alert("data: "+JSON .stringify(this.userForm.value));
       this.customers.push(cust);
     });
     //this.router.navigate(['login-page']);
     alert("Registered Succesfully!");
     location.reload();
   }else{
     alert("Already registered");
     location.reload();
   }
}
}
