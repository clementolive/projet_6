export interface Article {
    id: number;
    title: string;
    content: string;
    createdAt: Date;

    //External key. An article is linked to one Theme. 
    theme_id: number;
}
