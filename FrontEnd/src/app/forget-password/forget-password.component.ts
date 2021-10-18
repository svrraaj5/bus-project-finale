import { RegisterService } from './../register.service';
import { Router } from '@angular/router';
import { ForgotPassword } from './ForgotPassword';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Component, OnInit } from '@angular/core';
import { Register } from '../register/Register';

@Component({
  selector: 'app-forget-password',
  templateUrl: './forget-password.component.html',
  styleUrls: ['./forget-password.component.css']
})
export class ForgetPasswordComponent implements OnInit {
  forgotPassForm: FormGroup;
  forgotPwd: ForgotPassword[];
  otpForm: FormGroup;
  passForm: FormGroup;
  otp: string;
  users: Register[] = new Array();
  regUser: Register;
  show: boolean = false;
  constructor(private fb: FormBuilder, private router: Router, private service: RegisterService) {
    this.forgotPwd = new Array();
  }

  ngOnInit(): void {
    this.forgotPassForm = this.fb.group({
      emailId: ['', Validators.required],
    });
    this.otpForm = this.fb.group({
      Otp: ['', Validators.required]
    });

    this.passForm = this.fb.group({
      pass1: ['', Validators.required],
      pass2: ['', Validators.required],
    });

    this.service.getRegistration().subscribe(data => {
      this.users = data;
    });

  }
  forgotPass() {
    for (let u1 of this.users) {
      if (this.forgotPassForm.controls.emailId.value == u1.emailId) {
        this.regUser = u1;
        this.show = true;
      }
    }
    if (this.show == true) {
      this.service.getOtp(this.forgotPassForm.controls.emailId.value).subscribe(data => {
        //alert(data)
        this.otp = data;
      });
      
      document.getElementById('otp').style.display = 'block';
    } else {
      alert("U are not a registered user");
    }
  }
  otpEnter() {
    //alert(this.otp)
    if (this.otpForm.controls.Otp.value == this.otp) {
      
      document.getElementById('passId').style.display = 'block';
    } else {
      alert("Please enter correct Otp");
    }
  }
  newPass() {
    if (this.passForm.controls.pass1.value == this.passForm.controls.pass2.value) {
      let userForgot: Register = new Register(this.regUser.firstName, this.regUser.lastName, this.regUser.emailId, this.regUser.phoneNo, this.passForm.controls.pass1.value, this.regUser.dob, this.regUser.gender);

      this.service.resetPassword(this.regUser.emailId,userForgot).subscribe(data =>{

      });
      alert("Your Password is changed successfully");
      this.router.navigate(['login-page'])
    }else{
      alert("Password Fields do not match");
    }
  }
}
