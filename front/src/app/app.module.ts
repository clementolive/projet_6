import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { ThemesComponent } from './features/themes/themes/themes.component';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { LoginComponent } from './features/auth/login/login.component';
import { RegisterComponent } from './features/auth/register/register.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { ProfileComponent } from './features/profile/profile.component';
import { CreateArticleComponent } from './features/articles/create-article/create-article.component';
import { DetailArticleComponent } from './features/articles/detail-article/detail-article.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { JwtInterceptor } from './interceptors/jwt.interceptor';
import { ArticlesComponent } from './features/articles/feed/articles.component';

@NgModule({
  declarations: [AppComponent, HomeComponent, ThemesComponent, LoginComponent,
     RegisterComponent, NavbarComponent,
      ArticlesComponent, ProfileComponent, CreateArticleComponent, DetailArticleComponent],
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
