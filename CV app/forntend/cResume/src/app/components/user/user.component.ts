import { User } from 'src/app/common/user';
import { UserDataService } from './../../services/user-data.service';
import { Component, OnInit } from '@angular/core';
import { Link } from 'src/app/common/link';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  id:number=1;
  user?:User=new User();
  links:Link[]=[];
  updatedLinksArr:Map<number|undefined,Link> = new Map<number|undefined,Link>();
  editDisabled:boolean=true; 




  constructor(private userDataService: UserDataService) { }
  ngOnInit(): void {
    this.getUserData();
    this.getLinks();
  }

  



  toggleEdit(){
    this.editDisabled=!this.editDisabled;
  }

  
  
  getUserData() {
    this.userDataService.getUserData(this.id).subscribe(
      data => {
        this.user = data;
      }
    )
  }
  updateUser() {
    this.userDataService.updateUserData(this.id, this.user).subscribe(
      data => {
        alert("User Updated Successfully")
        // console.log(data);
        
      },
      err => {
        alert("User Update Failed")
      }
    )
  }
  
  
  getLinks() {
    this.userDataService.getLinksData(this.id).subscribe(
      data=> {
        this.links = data;
      }
    )
  }
  addUpdatedLinks(link:Link){
    this.updatedLinksArr.set(link.id, link)
    // console.log(link);
  }
  updateLinkData(){
    this.updatedLinksArr?.forEach(link => {
      this.userDataService.updateLinkData(this.id,link.id,link).subscribe(
        data => {
          alert("Link Updated Successfully")
          
          
        },
        err=>{
          alert("Link Update Failed")
          console.log(err);
          
        }
      )
    });
  }
  


}
