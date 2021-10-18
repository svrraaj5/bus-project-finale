import { SeatService } from './seat.service';
import { PaymentService } from './payment.service';
import { ReservationService } from './reservation.service';
import { BusService } from './bus.service';
import { AdminloginService } from './adminlogin.service';
import { UserloginService } from './userlogin.service';
import { RegisterService } from './register.service';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomePageComponent } from './home-page/home-page.component';
import { AboutUsComponent } from './about-us/about-us.component';
import { ContactUsComponent } from './contact-us/contact-us.component';
import { LoginComponent } from './login/login.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RegisterComponent } from './register/register.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { SeatLayoutComponent } from './seat-layout/seat-layout.component';
import { SearchBusComponent } from './search-bus/search-bus.component';
import { PaymentComponent } from './payment/payment.component';
import { ForgetPasswordComponent } from './forget-password/forget-password.component';
import { AdminComponent } from './admin/admin.component';
import { CancelTicketComponent } from './cancel-ticket/cancel-ticket.component';
import { PaymentSuccessfulComponent } from './payment-successful/payment-successful.component';
import { UnauthorisedComponent } from './unauthorised/unauthorised.component';
import { AfterCancelComponent } from './after-cancel/after-cancel.component';
import { HireBusComponent } from './hire-bus/hire-bus.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { PassengerComponent } from './passenger/passenger.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatIcon, MatIconModule} from '@angular/material/icon';
import {MatButtonModule} from '@angular/material/button';
import { ViewTicketComponent } from './view-ticket/view-ticket.component';
import { NgxPrintModule } from 'ngx-print';
@NgModule({
  declarations: [
    AppComponent,
    HomePageComponent,
    AboutUsComponent,
    ContactUsComponent,
    LoginComponent,
    RegisterComponent,
    DashboardComponent,
    SeatLayoutComponent,
    SearchBusComponent,
    PaymentComponent,
    ForgetPasswordComponent,
    AdminComponent,
    CancelTicketComponent,
    PaymentSuccessfulComponent,
    UnauthorisedComponent,
    AfterCancelComponent,
    HireBusComponent,
    PassengerComponent,
    ViewTicketComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    NgbModule,
    BrowserAnimationsModule,
    MatIconModule,
    MatButtonModule,
    NgxPrintModule
  ],
  providers: [RegisterService, UserloginService, AdminloginService, BusService, ReservationService, PaymentService, SeatService],
  bootstrap: [AppComponent]
})
export class AppModule { }
