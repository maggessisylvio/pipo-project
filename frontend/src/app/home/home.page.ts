import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ModalController } from '@ionic/angular';
import { DynamicFormComponent } from '../components/dynamic-form/dynamic-form.component';
import { EmployeeListComponent } from '../components/employee-list/employee-list.component';
import { SelectBenefitComponent } from '../components/select-benefit/select-benefit.component';
import { SelectCustomerComponent } from '../components/select-customer/select-customer.component';
import { Benefit } from '../domain/Benefit';
import { BenefitsId } from '../domain/BenefitsId';
import { Customer } from '../domain/Customer';
import { JsonFormData } from '../domain/JsonFormData';

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})
export class HomePage implements OnInit {
  constructor(private http: HttpClient, private modalCtrl: ModalController) {}

  ngOnInit() {}

  async openSelectCustomerModal(action: string) {
    const modal = await this.modalCtrl.create({
      component: SelectCustomerComponent,
    });
    modal.onDidDismiss().then(async (response) => {
      if (response.data) {
        this.openSelectBenefit(response.data, action);
      }
    });
    modal.present();
  }

  async openSelectBenefit(customer: Customer, action: string) {
    const modal = await this.modalCtrl.create({
      component: SelectBenefitComponent,
      componentProps: { customerId: customer.id, action },
    });
    modal.onDidDismiss().then(async (response) => {
      if (response.data) {
        if (action === 'register') {
          this.requestForm(customer.id, response.data);
        }

        if (action === 'report') {
          this.openEmployeeListModal(customer, response.data);
        }
      }
    });
    modal.present();
  }

  async requestForm(customerId: number, benefitsId: number[]) {
    const benefits = new BenefitsId(benefitsId);
    this.http
      .post('http://localhost:8080/fields', benefits)
      .subscribe((formData: JsonFormData) => {
        this.openRegisterEmployeeModal(formData, customerId);
      });
  }

  async openRegisterEmployeeModal(formData: JsonFormData, customerId: number) {
    const modal = await this.modalCtrl.create({
      component: DynamicFormComponent,
      componentProps: { formData, customerId },
    });
    modal.onDidDismiss().then(() => {});
    modal.present();
  }

  async openEmployeeListModal(customer: Customer, benefit: Benefit) {
    const modal = await this.modalCtrl.create({
      component: EmployeeListComponent,
      componentProps: { customer, benefit },
    });

    modal.present();
  }
}
