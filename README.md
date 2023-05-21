# P6-Full-Stack-reseau-dev

This application is made for developers. They can create posts, subscribe to topics and get related posts in a feed.
It is made by an Angular frontend and a Java Spring backend.

## Front

This project was generated with [Angular CLI](https://github.com/angular/angular-cli) version 14.1.3.

`git clone https://github.com/achmoye/Developpez-une-application-full-stack-complete`

`cd Developpez-une-application-full-stack-complete/front `

Don't forget to install your node_modules before starting (`npm install`).

### Development server

Run `ng serve` for a dev server. Navigate to `http://localhost:4200/`. The application will automatically reload if you change any of the source files.

### Build

Run `ng build` to build the project. The build artifacts will be stored in the `dist/` directory.

### Run the tests (Jest)
Launching test:

> npm run test

Generating Jest coverage:

> npm test -- --coverage

Check the coverage here :
> /front/coverage/jest/lcov-report/index.html

### End-to-end tests (Cypress)
> npm run e2e
>
Then generate coverage:
> npm run e2e:coverage

Check coverage here :
> /front/coverage/lcov-report/index.html

## Backend

Go to Developpez-une-application-full-stack-complete/back folder and run:
> mvn clean install
>
### Run the app :
With your IDE, open this folder : back/src/main/java/com.openclassrooms.mddapi
- Load maven build script
- Enable annotation processing for Lombok
- run SpringBootSecurityJwtApplication.java

This is going to create the database, with tables and relations.
Run script.sql in front/src/resources to add a user (test@test.com, password: Test!1234) and some topics

Now you can try the app: Login, create an article, update username and email in profile, comment articles, subscribe to a topic, or unsubscribe from profile.
If you subscribe to "SQL" topic and create a "SQL" article, you will see it in the feed. 


