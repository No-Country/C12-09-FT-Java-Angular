export class UserDto {

  name:string;
  lastName:string;
  email:string;
  phone:string;
  password:string;

  constructor(name:string, lastName:string, email:string, phone:string, password:string){
    this.name = name;
    this.lastName = lastName;
    this.email = email;
    this.phone = phone;
    this.password = password;
  }


}
