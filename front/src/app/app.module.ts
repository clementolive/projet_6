import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { TopicsComponent } from './features/topics/topics.component';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { LoginComponent } from './features/auth/login/login.component';
import { RegisterComponent } from './features/auth/register/register.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { ProfileComponent } from './features/profile/profile.component';
import { CreatePostComponent } from './features/posts/create-post/create-post.component';
import { DetailPostComponent } from './features/posts/detail-post/detail-post.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { JwtInterceptor } from './interceptors/jwt.interceptor';
import { FeedComponent } from './features/posts/feed/feed.component';
import { AuthNavbarComponent } from './features/auth/auth-navbar/auth-navbar.component';

@NgModule({
  declarations: [AppComponent, HomeComponent, TopicsComponent, LoginComponent,
     RegisterComponent, NavbarComponent,
      FeedComponent, ProfileComponent, CreatePostComponent, DetailPostComponent, AuthNavbarComponent],
  imports: [BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    HttpClientModule, ReactiveFormsModule, FormsModule],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: JwtInterceptor, multi: true },
  ],
  bootstrap: [AppComponent],
})
export class AppModule {}
