import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { IonicModule } from '@ionic/angular';
import { DynamicFormComponent } from '../components/dynamic-form/dynamic-form.component';
import { EmployeeListComponent } from '../components/employee-list/employee-list.component';
import { SelectBenefitComponent } from '../components/select-benefit/select-benefit.component';
import { KeysPipe } from '../pipes/keys.pipe';
import { HomePageRoutingModule } from './home-routing.module';
import { HomePage } from './home.page';

@NgModule({
  imports: [
    CommonModule,
    ReactiveFormsModule,
    IonicModule,
    HomePageRoutingModule,
    HttpClientModule,
  ],
  declarations: [
    HomePage,
    DynamicFormComponent,
    EmployeeListComponent,
    SelectBenefitComponent,
    KeysPipe,
  ],
})
export class HomePageModule {}
