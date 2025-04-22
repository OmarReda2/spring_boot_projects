import { Course } from './../../common/course';
import { UserDataService } from './../../services/user-data.service';
import { Component, OnInit } from '@angular/core';
import { BehaviorSubject } from 'rxjs';


@Component({
  selector: 'app-course',
  templateUrl: './course.component.html',
  styleUrls: ['./course.component.css']
})
export class CourseComponent implements OnInit {

  id: number = 1;
  courses?: Course[];
  addedCourse?:Course = new Course();
  // courses:BehaviorSubject<Course[]>=new BehaviorSubject<Course[]>([])
  updatedCoursesArr: Map<number | undefined, Course> = new Map<number | undefined, Course>();
  editDisabled: boolean = true;
  addingEnabled: boolean = false;
  deletingEnabled: boolean = false






  constructor(private userDataService: UserDataService) { }
  ngOnInit(): void {
    this.getCourses()
  }



  toggleDeleting(): void {
    this.deletingEnabled = !this.deletingEnabled
  }
  toggleAdding(): void {
    this.addingEnabled = !this.addingEnabled
  }
  toggleEdit(): void {
    this.editDisabled = !this.editDisabled

  }
  // trackByItem(index: number, course: Course) {
  //   return course.id;
  // }







  getCourses() {
    this.userDataService.getCoursesData(this.id).subscribe(
      data => {
        this.courses = data;
        // this.courses.next(data);
      }
    )
  }
  addUpdatedCourses(course: Course) {
    this.updatedCoursesArr.set(course.id, course)
    // console.log(link);
  }
  updateCourseData() {
    this.updatedCoursesArr?.forEach(course => {
      this.userDataService.updateCourseData(this.id, course.id, course).subscribe(
        data => {
          alert("Course Updated Successfully")



        },
        err => {
          alert("Course Update Failed")
          console.log(err);
        }
      )
    });
  }
  deleteCourse(userId: number, courseId?: number) {
    this.userDataService.deleteCourse(userId, courseId).subscribe(
      data => {
        alert("Course Deleted Successfully");
        this.getCourses();

      },
      err => {
        alert("Course Delete Failed")
        console.log(err);
      }
    )
  }
  addCourse(course?:Course){
    this.addingEnabled = false
    
    this.userDataService.addCourseData(this.id,course).subscribe(
      () => {
        alert("Course Added Successfully");
        this.getCourses();
      }
    )

  }










}
