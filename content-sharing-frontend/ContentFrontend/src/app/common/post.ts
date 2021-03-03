import { Member } from "./member";

export class Post {
    id!:number;
    title: string="";
    imgUrl: string = "";

    description: string = "";
    member!:Member;
}
