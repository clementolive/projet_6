export interface Post {
    id: number;
    title: string;
    content: string;
    createdAt: Date;

    //These are made by DTO layer. 
    theme_name: string;
    author_name: string; 
    comments: {author_name:string, content:string}[]; //Comment interface added manually because it wouldn't work 
}
