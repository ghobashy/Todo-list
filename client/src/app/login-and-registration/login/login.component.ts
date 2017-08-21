import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { AuthenticationService } from "app/shared/services/authentication.service";
import { AlertService } from "app/shared/services/alert.service";
import { LoginAndRegistrationService } from "app/login-and-registration/login-and-registration.service";


@Component({
    moduleId: module.id,
    templateUrl: 'login.component.html'
})

export class LoginComponent implements OnInit {
    model: any = {};
    loading = false;
    returnUrl: string;

    constructor(
        private route: ActivatedRoute,
        private router: Router,
        private loginAndRegistration: LoginAndRegistrationService,
        private alertService: AlertService) { }

    ngOnInit() {
        // reset login status
        // this.authenticationService.logout();

        // get return url from route parameters or default to '/'
        this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/pages/todo';
    }

    login() {
        this.loading = true;
        this.loginAndRegistration.login(this.model.username, this.model.password)
            .subscribe(
                data => {
                    this.loading = false;
                    this.router.navigate([this.returnUrl]);
                },
                error => {
                    let message = "Invalid login credentials";
                    this.alertService.error(message);
                    this.loading = false;
                });
    }
}
