import { HireBusComponent } from './hire-bus/hire-bus.component';
import { AfterCancelComponent } from './after-cancel/after-cancel.component';
import { UnauthorisedComponent } from './unauthorised/unauthorised.component';
import { AdminComponent } from './admin/admin.component';
import { CancelTicketComponent } from './cancel-ticket/cancel-ticket.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { ForgetPasswordComponent } from './forget-password/forget-password.component';
import { SearchBusComponent } from './search-bus/search-bus.component';
import { RegisterComponent } from './register/register.component';

import { LoginComponent } from './login/login.component';
import { ContactUsComponent } from './contact-us/contact-us.component';
import { AboutUsComponent } from './about-us/about-us.component';
import { HomePageComponent } from './home-page/home-page.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SeatLayoutComponent } from './seat-layout/seat-layout.component';
import { PaymentComponent } from './payment/payment.component';
import { PaymentSuccessfulComponent } from './payment-successful/payment-successful.component';
import { PassengerComponent } from './passenger/passenger.component';
import { ViewTicketComponent } from './view-ticket/view-ticket.component';

const routes: Routes = [{path:'',component:HomePageComponent},
{path:'about-page',component:AboutUsComponent},
{path:'contact-page',component:ContactUsComponent},
{path:'login-page',component:LoginComponent},
{path:'register-page',component:RegisterComponent},
{path:'search-bus-page',component:SearchBusComponent},
{path:'seat-layout',component:SeatLayoutComponent},
{path:'payment-portal',component:PaymentComponent},
{path:'forgot-password',component:ForgetPasswordComponent},
{path:'dashboard',component:DashboardComponent},
{path:'cancel-ticket',component:CancelTicketComponent},
{path:'admin-page',component:AdminComponent},
{path:'payment-success',component:PaymentSuccessfulComponent},
{path:'unauthorised',component:UnauthorisedComponent},
{path:'after-cancel',component:AfterCancelComponent},
{path:'hire-bus',component:HireBusComponent},
{path:'passenger',component:PassengerComponent},
{path:'view-ticket',component:ViewTicketComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
