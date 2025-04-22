import { User } from 'src/app/common/user';
import { Link } from './../common/link';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map, Observable } from 'rxjs';
import { Course } from '../common/course';
import { Education } from '../common/education';

@Injectable({
  providedIn: 'root'
})
export class UserDataService {

  private baseUrl = "http://localhost:8080";

  constructor(private httpclient:HttpClient) { }









  getUserData(id:number):Observable<User>{
    const userUrl = `${this.baseUrl}/users/${id}`
    return this.httpclient.get<User>(userUrl);
  }
  updateUserData(id:number, user?:User):Observable<User>{
    const userUrl = `${this.baseUrl}/users/${id}`
    return this.httpclient.put<User>(userUrl, user);
  }











  getCoursesData(userId:number):Observable<Course[]>{
    const searchUrl = `${this.baseUrl}/courses/search/findByUserId?userId=${userId}`;
    return this.httpclient.get<getCoursesRes>(searchUrl).pipe(
      map(res => res._embedded.courses)
    )
  }
  updateCourseData(userId:number,courseId?:number,course?:Course):Observable<Course>{
    const searchUrl = `${this.baseUrl}/courses/updateCourse/${userId}/${courseId}`
    return this.httpclient.put<Course>(searchUrl,course)
  }
  deleteCourse(userId:number,courseId?:number):Observable<number>{
    const url = `${this.baseUrl}/courses/deleteCourse?userId=${userId}&courseId=${courseId}`
    return this.httpclient.delete<number>(url)
  }
  addCourseData(userId:number,course?:Course):Observable<Course>{
     const url = `${this.baseUrl}/courses/addCourse/${userId}`
     return this.httpclient.post<Course>(url,course);
  }
  
  






  getEducationsData(userId:number):Observable<Education[]>{
    const searchUrl = `${this.baseUrl}/educations/search/findByUserId?userId=${userId}`
    return this.httpclient.get<getEducatoinsRes>(searchUrl).pipe(
      map(res => res._embedded.educations)
    )
  }
  updateEductionData(userId:number,eduId?:number,edu?:Education):Observable<Education>{
    const searchUrl = `${this.baseUrl}/educations/updateEducation?userId=${userId}&eduId=${eduId}`
    return this.httpclient.put<Education>(searchUrl,edu)
  }
  deleteEductionData(userId:number,eduId?:number):Observable<number>{
    const url = `${this.baseUrl}/educations/deleteEducation?userId=${userId}&eduId=${eduId}`
    return this.httpclient.delete<number>(url)
  }
  addEducationData(userId:number,education?:Education):Observable<Education>{
     const url = `${this.baseUrl}/educations/addEducation?userId=${userId}`
     return this.httpclient.post<Education>(url,education);
  }
  













  getLinksData(userId:number):Observable<Link[]>{
    const searchUrl = `${this.baseUrl}/links/search/findByUserId?userId=${userId}`
    return this.httpclient.get<getLinksRes>(searchUrl).pipe(
      map(res => res._embedded.links)
    )
  }
  updateLinkData(userId:number,urlId?:number,link?:Link):Observable<Link>{
    const searchUrl = `${this.baseUrl}/links/updateLinkByUserId?urlId=${urlId}&userId=${userId}`
    return this.httpclient.put<Link>(searchUrl,link)
  }
}








interface getCoursesRes {
  _embedded: {
    courses: Course[]
  }
}

interface getEducatoinsRes {
  _embedded: {
    educations: Education[];
  }
}

interface getLinksRes {
  _embedded: {
    links: Link[];
  }
}


