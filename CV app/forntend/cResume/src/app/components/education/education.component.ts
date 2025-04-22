import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Education } from 'src/app/common/education';
import { UserDataService } from 'src/app/services/user-data.service';

@Component({
  selector: 'app-education',
  templateUrl: './education.component.html',
  styleUrls: ['./education.component.css']
})
export class EducationComponent implements OnInit {

  id: number = 1;
  educations?: Education[];
  updatedEducationsArr: Map<number | undefined, Education> = new Map<number | undefined, Education>();
  editDisabled:boolean = true;
  deletingEnabled: boolean = false;
  addingEnabled:boolean = false;
  addedEducation:Education = new Education();

  constructor(private userDataService: UserDataService) { }

  ngOnInit(): void {
    this.getEducations();
  }





  toggleEdit(){
    this.editDisabled = !this.editDisabled;
  }
  toggleDelete(){
    this.deletingEnabled = !this.deletingEnabled
  }
  toggleAdding(){
    this.addingEnabled = !this.addingEnabled
  }





  getEducations() {
    this.userDataService.getEducationsData(this.id).subscribe(
      data => {
        this.educations = data;
      }
    )
  }
  addUpdatedEducations(edu: Education) {
    this.updatedEducationsArr.set(edu.id, edu)
  }
  updateEductionData() {
    this.updatedEducationsArr?.forEach(edu => {
      this.userDataService.updateEductionData(this.id, edu.id, edu).subscribe(
        data => {
          alert("Education Updated Successfully")


        },
        err => {
          alert("Education Update Failed")
          console.log(err);
        }
      )
    });
  }
  deleteEducation(eduId?:number){
    this.userDataService.deleteEductionData(this.id,eduId).subscribe(
      () => {
        alert("Education Deleted Successfully")
        this.getEducations()
        
      },
      () => {
        alert("Education Deletion Failed")
      }
    )
  }
  addEducation(edu:Education){
    this.userDataService.addEducationData(this.id, edu).subscribe(
      () => {
        alert("Education Added Successfully")
        this.getEducations();
        this.addingEnabled = false;
      },
      () => {
        alert("Education Deletion Failed")
      }
    )
  }

}
