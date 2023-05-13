import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { ThemesComponent } from './features/themes/themes/themes.component';
import { HttpClientModule } from '@angular/common/http';
import { LoginComponent } from './features/auth/login/login.component';
import { RegisterComponent } from './features/auth/register/register.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { ArticlesComponent } from './features/articles/articles.component';
import { ProfileComponent } from './features/profile/profile.component';
import { CreateArticleComponent } from './features/create-article/create-article.component';

@NgModule({
  declarations: [AppComponent, HomeComponent, ThemesComponent, LoginComponent, RegisterComponent, NavbarComponent, ArticlesComponent, ProfileComponent, CreateArticleComponent],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
