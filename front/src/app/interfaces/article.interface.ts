export interface Article {
    id: number;
    title: string;
    content: string;
    createdAt: Date;

    //These are made by DTO layer. 
    theme_name: string;
    author_name: string; 
    comments: Comment[]
}
