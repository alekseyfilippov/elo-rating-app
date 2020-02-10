# elo-rating-app
1. Spring. WEB application. DB

    -Every 30 seconds a game is played between two random chess players from different schools. According to the result (the winner is chosen randomly), their Elo rating is calculated;
    
    -For chess players CRD (From the word CRUD). R as a list;
    
    -Displaying a list of five chess players with the best rating change in the last 5 minutes;

2. The monitoring library (jar) contains and processes the @Monitoring annotation (“EVENT_NAME")
    
    -Connect in all the “important” methods of the application, which was discussed above in paragraph 1.
    
    -Annotation collects 3 metrics by the method: the fact of entering the method (... _START), the fact of completion of the method (... _END), the duration of the method in milliseconds (... _DURATION).

The task: It is necessary to implement both points: application and library.
