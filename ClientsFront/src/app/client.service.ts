import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { Client } from './client';
@Injectable({
  providedIn: 'root'
})
export class ClientService {
  private baseURL = "http://localhost:8080/springboot-crud-rest/api/";
  constructor(private httpClient: HttpClient) { }

  getClientsList(): Observable<Client[]>{
    return this.httpClient.get<Client[]>("http://localhost:8080/springboot-crud-rest/api/clients");
  }

  createClient(client: Client): Observable<Object>{
    return this.httpClient.post("http://localhost:8080/springboot-crud-rest/api/save-clients", client);
  }

  getClientById(id: number): Observable<Client>{
    return this.httpClient.get<Client>(`${this.baseURL}/clients/${id}`);
  }

  updateClient(id: number, client: Client): Observable<Object>{
    return this.httpClient.put(`${this.baseURL}/update-clients/${id}`, client);
  }

  deleteClient(id: number): Observable<Object>{
    return this.httpClient.delete(`${this.baseURL}/delete-clients/${id}`);
  }
}
