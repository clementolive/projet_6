export interface Article {
    id: number;
    title: string;
    description: string;
    createdAt: Date;

    //External key. An article is linked to one Theme. 
    theme_id: number;
}
