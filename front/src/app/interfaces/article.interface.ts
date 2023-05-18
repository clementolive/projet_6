export interface Article {
    id: number;
    title: string;
    content: string;
    createdAt: Date;

    //External keys. An article is linked to one Theme. 
    theme_name: string;
    author_name: string; 
    comments: Comment[]
}
