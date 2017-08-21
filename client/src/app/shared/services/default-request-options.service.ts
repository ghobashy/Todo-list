import { Injectable } from '@angular/core';
import { Headers,BaseRequestOptions } from "@angular/http";



@Injectable()
export class DefaultRequestOptions extends BaseRequestOptions {
  
  headers = new Headers({
    'Access-Control-Allow-Origin': '*',
  });
}