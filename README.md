# P6-Full-Stack-reseau-dev

This application is made for developers. They can create posts, subscribe to topics and get related posts in a feed.
It is made by an Angular frontend and a Java Spring backend.

## Backend

### Run the app :
With your IDE, open this folder : back/src/main/java/com.openclassrooms.mddapi
- Load maven build script
- Enable annotation processing for Lombok, and run:
> mvn clean install
- run SpringBootSecurityJwtApplication.java

This is going to create the database, with tables and relations.

Run **script.sql** from front/src/resources in your SGDB manager to add a user (test@test.com, password: Test!1234), some topics, and some articles
related to these topics.

Now you can try the app: Login, create an article, update username and email in profile, comment articles, subscribe to a topic, or unsubscribe from profile.
If you subscribe to "C++" topic and create a "C++" article, you will see it in the feed.

## Front

This project was generated with [Angular CLI](https://github.com/angular/angular-cli) version 14.1.3.

`git clone https://github.com/achmoye/Developpez-une-application-full-stack-complete`

`cd Developpez-une-application-full-stack-complete/front `

Don't forget to install your node_modules before starting (`npm install`).

### Development server

Run `ng serve` for a dev server. Navigate to `http://localhost:4200/`. The application will automatically reload if you change any of the source files.

### Build

Run `ng build` to build the project. The build artifacts will be stored in the `dist/` directory.

### Run the tests (Karma)
Launching test:

> ng test --code-coverage

Check the coverage here :
> /front/coverage/front/app/index.html

### End-to-end tests (Cypress)
> npm run e2e

