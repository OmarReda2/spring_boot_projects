import { User } from 'src/app/common/user';
import { UserDataService } from './../../services/user-data.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {


  // ----------------------- <variables> -------------------------- //
  id:number=1;
  user?:User;


  // ----------------------- </variables> -------------------------- //

  constructor(private userDataService: UserDataService) { }

  ngOnInit(): void {

    this.getUserData()
  }



  getUserData() {
    this.userDataService.getUserData(this.id).subscribe(
      data => {
        this.user = data;
      }
    )
  }


}
