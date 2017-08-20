import { Injectable } from '@angular/core';
import { LOCAL_STORAGE } from '../commons/Defines';
import { Http, Response } from "@angular/http";
import { Observable } from 'rxjs';
import 'rxjs/add/operator/map'

@Injectable()
export class AuthenticationService {

  private token: string;


  constructor(private http: Http) {
    var currentUser = JSON.parse(localStorage.getItem(LOCAL_STORAGE.PROFILE_NAME));
    this.token = currentUser && currentUser.token;
  }

  /**
   *  Login the user and set token to local storage
   * @param username 
   * @param password 
   */
  public login(username: string, password: string): Observable<boolean> {
    return this.http.post('/api/authenticate', JSON.stringify({ username: username, password: password }))
      .map((response: Response) => {
        let token = response.json() && response.json().token;
        if (token) {
          this.token = token;
          localStorage.setItem(LOCAL_STORAGE.PROFILE_NAME, JSON.stringify({ username: username, token: token }));
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

}
