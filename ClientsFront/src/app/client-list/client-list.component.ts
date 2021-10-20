import { Component, Input, OnInit } from '@angular/core';
import { Client } from '../client'
import { ClientService } from '../client.service'
import { Router } from '@angular/router';
import { NgbModal} from '@ng-bootstrap/ng-bootstrap';
import { UpdateClientComponent } from '../update-client/update-client.component';
@Component({
  selector: 'app-client-list',
  templateUrl: './client-list.component.html',
  styleUrls: ['./client-list.component.css']
})
export class ClientListComponent implements OnInit {
  
  clients: Client[];
  closeModal: any;
  constructor(private clientService: ClientService,
    private router: Router, public modalService: NgbModal) { }

  ngOnInit(): void {
    this.getClients();
  }

  private getClients(){
    this.clientService.getClientsList().subscribe(data => {
      this.clients = data;
    });
  }
  
 

  deleteClient(id: number){
    this.clientService.deleteClient(id).subscribe( data => {
      console.log(data);
      this.getClients();
    })
  }

  openModal(id: number) {    
    const modalRef = this.modalService.open(UpdateClientComponent,
      {
        scrollable: true,
        windowClass: 'myCustomModalClass',
      });
      modalRef.componentInstance.id = id;

    modalRef.result.then((result:any) => {
      console.log(result);
    }, (reason:any) => {
    });    
  }

}
