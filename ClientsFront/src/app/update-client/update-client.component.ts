import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Client } from '../client'
import { ClientService } from '../client.service'
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-update-client',
  templateUrl: './update-client.component.html',
  styleUrls: ['./update-client.component.css']
})
export class UpdateClientComponent implements OnInit {

  @Input() id: number ;
  
  client: Client=new Client();

  constructor(private clientService: ClientService,
    private route: ActivatedRoute,
    private router: Router, public activeModal: NgbActiveModal) { }

  ngOnInit(): void {
    this.id;    
    this.clientService.getClientById(this.id).subscribe(data => {
      this.client = data;
    }, error => console.log(error));
  }

  onSubmit(){
    this.clientService.updateClient(this.id, this.client).subscribe( data =>{
      
      this.closeModal();
      this.goToClientsList();
    }
    , error => console.log(error));
  }

  goToClientsList(){
    let currentUrl = ['/clients'];
      this.router.routeReuseStrategy.shouldReuseRoute = () => false;
      this.router.onSameUrlNavigation = 'reload';
      this.router.navigate([currentUrl]);
    
  }

  closeModal() {
    this.activeModal.close();
    this.goToClientsList();
  }

}
