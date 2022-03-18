import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ModalController } from '@ionic/angular';
import { Customer } from '../../domain/Customer';

@Component({
  selector: 'app-select-customer',
  templateUrl: './select-customer.component.html',
  styleUrls: ['./select-customer.component.scss'],
})
export class SelectCustomerComponent implements OnInit {
  customers: Customer[];

  constructor(private http: HttpClient, public modalCtrl: ModalController) {}

  ngOnInit() {
    this.http.get('http://localhost:8080/customers').subscribe((customers) => {
      this.customers = customers as Customer[];
    });
  }

  setCustomer(customer: Customer) {
    this.modalCtrl.dismiss(customer);
  }

  dismissModal() {
    this.modalCtrl.dismiss();
  }
}
