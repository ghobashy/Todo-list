package con.celonis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.celonis.models.AuthUser;
import com.celonis.services.ILoginService;

@Controller
@RequestMapping("login")
public class LoginController {

	@Autowired
	ILoginService loginService;
	
	@PostMapping("/")
	public ResponseEntity<Void> authenicateUser(@RequestBody AuthUser user) {
		boolean flag = loginService.authenticateUser(user);
		if (flag == false) {
			return new ResponseEntity<Void>(HttpStatus.UNAUTHORIZED);
		}
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
