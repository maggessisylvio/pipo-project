import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouteReuseStrategy } from '@angular/router';

import { IonicModule, IonicRouteStrategy } from '@ionic/angular';

import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { CpfCnpjPipe } from './pipes/cpfCnpj.pipe';
import { DynamicFormComponent } from './components/dynamic-form/dynamic-form.component';
import { SelectCustomerComponent } from './components/select-customer/select-customer.component';
import { KeysPipe } from './pipes/keys.pipe';

@NgModule({
  declarations: [AppComponent, CpfCnpjPipe, SelectCustomerComponent],
  entryComponents: [],
  imports: [BrowserModule, IonicModule.forRoot(), AppRoutingModule],
  providers: [{ provide: RouteReuseStrategy, useClass: IonicRouteStrategy }],
  bootstrap: [AppComponent],
})
export class AppModule {}
