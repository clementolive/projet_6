import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { ThemesComponent } from './features/themes/themes/themes.component';
import { LoginComponent } from './features/auth/login/login.component';
import { RegisterComponent } from './features/auth/register/register.component';
import { ArticlesComponent } from './features/articles/articles.component';
import { ProfileComponent } from './features/profile/profile.component';
import { CreateArticleComponent } from './features/create-article/create-article.component';
import { DetailArticleComponent } from './features/detail-article/detail-article.component';

// consider a guard combined with canLoad / canActivate route option
// to manage unauthenticated user to access private routes
const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'themes', component: ThemesComponent },
  { path: 'articles', component: ArticlesComponent },
  { path: 'profile', component: ProfileComponent },
  { path: 'createArticle', component: CreateArticleComponent},
  { path: 'detailArticle', component: DetailArticleComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
