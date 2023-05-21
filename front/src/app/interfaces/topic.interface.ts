export interface Topic {
    topic_id: number;
    title: string;
    description: string;
    
    subscribed: boolean; //Not used yet, useful if we need to show subscribed topics in Topics page 
}
