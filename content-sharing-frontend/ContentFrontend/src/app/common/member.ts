import { Post } from "./post";

export class Member {
    id!:number;
    username: string="";
    password: string = "";

    role: string = "";
    posts:Post[]=[];

    users:Member[]=[];

}
