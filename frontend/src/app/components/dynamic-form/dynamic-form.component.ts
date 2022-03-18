import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AlertController, ModalController } from '@ionic/angular';
import { Employee } from 'src/app/domain/Employee';
import { JsonFormData } from 'src/app/domain/JsonFormData';
import { JsonFormFields } from 'src/app/domain/JsonFormFields';

@Component({
  selector: 'app-dynamic-form',
  templateUrl: './dynamic-form.component.html',
  styleUrls: ['./dynamic-form.component.scss'],
})
export class DynamicFormComponent implements OnInit {
  formData: JsonFormData;
  customerId: number;
  myForm: FormGroup = this.fb.group({});

  constructor(
    private fb: FormBuilder,
    private modalCtrl: ModalController,
    private http: HttpClient,
    private alertCtrl: AlertController
  ) {}

  ngOnInit(): void {
    this.createForm(this.formData.fields);
  }

  createForm(fields: JsonFormFields[]) {
    for (const field of fields) {
      const validatorsToAdd = [];

      if (field.required) {
        validatorsToAdd.push(Validators.required);
      }

      this.myForm.addControl(
        field.name,
        this.fb.control(field.value, validatorsToAdd)
      );
    }
  }

  async showMessage(header, message) {
    const alert = await this.alertCtrl.create({
      header,
      message,
      buttons: ['OK'],
    });
    await alert.present();
  }

  submit() {
    const employee = new Employee(
      this.customerId,
      JSON.stringify(this.myForm.getRawValue())
    );

    this.http.post('http://localhost:8081/employees', employee).subscribe(
      () => {
        this.showMessage('Success', 'Employee Registration Successfully!');
        this.dismissModal();
      },
      () => this.showMessage('Error', 'Unable to register, try again!')
    );
  }

  dismissModal() {
    this.modalCtrl.dismiss();
  }
}
