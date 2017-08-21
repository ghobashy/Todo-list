import { Injectable } from '@angular/core';
import { LOCAL_STORAGE } from '../commons/Defines';
import { Http, Response } from "@angular/http";
import { Observable } from 'rxjs';
import 'rxjs/add/operator/map'
import { StorageService } from "app/shared/services/storage.service";
import { API_URLS } from "app/shared/config/routes.cofig";

@Injectable()
export class AuthenticationService {

  private token: string;
  private CURRENT_USER;


  constructor(private http: Http, private storageService:StorageService) {
    this.CURRENT_USER = storageService.getLocalStorage(LOCAL_STORAGE.PROFILE_NAME);
    this.token = this.CURRENT_USER && this.CURRENT_USER.token;
  }

  /**
   *  Login the user and set token to local storage
   * @param username 
   * @param password 
   */
  public login(username: string, password: string): Observable<boolean> {
    return this.http.post(API_URLS.LOGIN, { username: username, password: password })
      .map((response: Response) => {
        let token = response.headers.get("Authorization");
        if (token) {
          this.token = token;
          this.CURRENT_USER = { username: username, token: token };
          this.storageService.setStorageData(LOCAL_STORAGE.PROFILE_NAME, this.CURRENT_USER);
          // return true to indicate successful login
          return true;
        } else {
          // return false to indicate failed login
          return false;
        }
      });
  }

  private logout(): void {
    // clear token remove user from local storage to log user out
    this.token = null;
    localStorage.removeItem(LOCAL_STORAGE.PROFILE_NAME);
  }

  public isAuthenticated(){
    return !!this.storageService.getLocalStorage(LOCAL_STORAGE.PROFILE_NAME);
  }

}
