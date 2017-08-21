import { Injectable } from '@angular/core';
import { LOCAL_STORAGE } from "app/shared/commons/Defines";

@Injectable()
export class StorageService {


  private cachedSession:object={};
  constructor() { }

  public setStorageData( key: string, value: any) {
    key =  key;
    this.cachedSession[key]= value;
    if (typeof value === 'object') {
      localStorage.setItem(key, JSON.stringify(value));
    } else {
      localStorage.setItem(key, String(value));
    }
  }

  private getStorageData(key:string){
    if (this.cachedSession[key]) {
      return this.cachedSession[key];
    }
    else {
      try {
        return JSON.parse(localStorage.getItem(key));
      } catch (error) {
        return localStorage.getItem(key);
      }
    }
  }

   public getLocalStorage(key) {
     if(this.cachedSession[LOCAL_STORAGE.PROFILE_NAME]){
       return this.cachedSession[LOCAL_STORAGE.PROFILE_NAME]
     }
     this.cachedSession[LOCAL_STORAGE.PROFILE_NAME] = JSON.parse(localStorage.getItem(LOCAL_STORAGE.PROFILE_NAME));
      return this.cachedSession[LOCAL_STORAGE.PROFILE_NAME];
  }
}
