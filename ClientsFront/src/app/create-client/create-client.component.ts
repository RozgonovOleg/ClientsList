import { Component, OnInit } from '@angular/core';
import { Client } from '../client'
import { ClientService } from '../client.service'
import { Router } from '@angular/router';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';


@Component({
  selector: 'app-create-client',
  templateUrl: './create-client.component.html',
  styleUrls: ['./create-client.component.css']
})
export class CreateClientComponent implements OnInit {
  
  client: Client = new Client();
  constructor(private clientService: ClientService, 
    private router: Router, public activeModal: NgbActiveModal) { }

  ngOnInit(): void {
  }
  
  saveClient() {
    this.clientService.createClient(this.client).subscribe(data => {
      console.log(data);
      this.activeModal.close();     
      this.goToClientsList();
    },
      error => console.log(error));
  }

  goToClientsList() {
    let currentUrl = ['/clients'];
      this.router.routeReuseStrategy.shouldReuseRoute = () => false;
      this.router.onSameUrlNavigation = 'reload';
      this.router.navigate([currentUrl]);
  }

  onSubmit() {
    console.log(this.client);    
    this.saveClient();
  }

  closeModal(message: string) {
    this.goToClientsList();
    this.activeModal.close();
  }

}
