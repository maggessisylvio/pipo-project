import { HttpClient, HttpParams } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ModalController } from '@ionic/angular';
import { Benefit } from 'src/app/domain/Benefit';

@Component({
  selector: 'app-select-benefit',
  templateUrl: './select-benefit.component.html',
  styleUrls: ['./select-benefit.component.scss'],
})
export class SelectBenefitComponent implements OnInit {
  benefits: Benefit[];
  customerId: number;
  benefitsSelected: number[] = [];
  action: string;

  constructor(private http: HttpClient, private modalCtrl: ModalController) {}

  ngOnInit() {
    const params = new HttpParams().set('customerId', this.customerId);
    this.http
      .get('http://localhost:8080/benefits/findBenefitByCustomer', { params })
      .subscribe((benefits) => {
        this.benefits = benefits as Benefit[];
      });
  }

  setBenefit(benefit: Benefit) {
    this.modalCtrl.dismiss(benefit);
  }

  addBenefit(event, benefitId: number) {
    const status: boolean = event.detail.checked;

    if (status) {
      this.benefitsSelected.push(benefitId);
    } else {
      this.benefitsSelected = this.benefitsSelected.filter(
        (element) => element !== benefitId
      );
    }
  }

  submit() {
    this.modalCtrl.dismiss(this.benefitsSelected);
  }

  dismissModal() {
    this.modalCtrl.dismiss();
  }
}
