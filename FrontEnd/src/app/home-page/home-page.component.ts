import { Router } from '@angular/router';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Component, OnInit } from '@angular/core';
import { ModalDismissReasons, NgbModal } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent implements OnInit {

  searchForm:FormGroup;
  source: string;
  destination: string;
  busDate: Date;

  constructor(private formBuilder: FormBuilder, private router: Router) { }
  ngOnInit(): void {
    this.searchForm = this.formBuilder.group({
      from: ['', Validators.required],
      to: ['', Validators.required],
      date: ['', Validators.required]
    });
  }
  show() {
    document.getElementById('choice1').style.display = 'none';
    document.getElementById('choice2').style.display = 'block';
    this.source=this.searchForm.controls.from.value;
    this.destination=this.searchForm.controls.to.value;
    this.busDate=this.searchForm.controls.date.value;
    
    sessionStorage.setItem('source',this.searchForm.controls.from.value);
    sessionStorage.setItem('dest',this.searchForm.controls.to.value);
    sessionStorage.setItem('date',this.searchForm.controls.date.value);
  }
  show2() {
    document.getElementById('choice1').style.display = 'block';
    document.getElementById('choice2').style.display = 'none';
  }
  
  search(){
    //alert(this.source)
   // alert(sessionStorage.setItem('date',this.searchForm.controls.date.value))
    //this.router.navigate(['unauthorised',{ queryParams: { val: this.searchForm.controls.from.value } }]);
    if(this.searchForm.controls.from.value==this.searchForm.controls.to.value){
      alert("Source and Destination should not be same")
    }
    else{
    this.router.navigate(['unauthorised']);
    }
  }
}
