export interface Comment {
    id: number;
    content: string;
    createdAt: Date;

    //External keys. A comment is made on an article by a user
    user_id: number;
    article_id: number;
}
