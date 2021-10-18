export class Register{
    
    firstName:string;
    lastName:string;
    emailId:string;
    phoneNo:string;
    pass:string;
    dob:Date;
    gender:string;
    noOfBookings:number;
    wallet:any;
    
    constructor(firstName:string,lastName:string,emailId:string,phoneNo:string,pass:string,dob:Date,
        gender:string)
    {
        
        this.firstName=firstName;
        this.lastName=lastName;
        this.emailId=emailId;
        this.phoneNo=phoneNo;
        this.pass=pass;
        this.dob=dob;
        this.gender=gender;
    }
}