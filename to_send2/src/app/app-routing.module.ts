import { ChangePasswordComponent } from './change-password/change-password.component';
import { ForgotPasswordComponent } from './forgot-password/forgot-password.component';
import { CongratulationComponent } from './congratulation/congratulation.component';
import { LandingPageComponent } from './landing-page/landing-page.component';
import { LoginComponent } from './login/login.component';
import { RegistrationComponent } from './registration/registration.component';
import { FlightSearchComponent } from './flight-search/flight-search.component';
import { FlightSelectComponent } from './flight-select/flight-select.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PaymentComponent } from './payment/payment.component';

const routes: Routes = [
  {path:'flightsearch',component:FlightSearchComponent},
  {path:'flighselect',component:FlightSelectComponent},
  {path:'register',component:RegistrationComponent},
  {path:'login',component:LoginComponent},
  {path:'',component:LandingPageComponent},
  {path:'payment',component:PaymentComponent},
  {path:'congratulation',component:CongratulationComponent},
  {path:'forgotpassword',component:ForgotPasswordComponent},
  {path:'changepassword',component:ChangePasswordComponent}


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const routingComponent=[LandingPageComponent,FlightSelectComponent,FlightSearchComponent
  ,RegistrationComponent,LoginComponent,PaymentComponent
  ,CongratulationComponent,ForgotPasswordComponent,ChangePasswordComponent]