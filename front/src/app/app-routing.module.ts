import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { TopicsComponent } from './features/topics/topics.component';
import { LoginComponent } from './features/auth/login/login.component';
import { RegisterComponent } from './features/auth/register/register.component';
import { ProfileComponent } from './features/profile/profile.component';
import { CreatePostComponent } from './features/posts/create-post/create-post.component';
import { DetailPostComponent } from './features/posts/detail-post/detail-post.component';
import { AuthGuard } from './guards/auth.guard';
import { UnauthGuard } from './guards/unauth.guard';
import { FeedComponent } from './features/posts/feed/feed.component';

/** No UnauthGuard for Register : A logged in  user might want to create a new account */
const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'login', component: LoginComponent, canActivate: [UnauthGuard] },
  { path: 'register', component: RegisterComponent },
  { path: 'topics', component: TopicsComponent, canActivate: [AuthGuard] },
  { path: 'feed', component: FeedComponent, canActivate: [AuthGuard] },
  { path: 'profile', component: ProfileComponent, canActivate: [AuthGuard] },
  { path: 'createPost', component: CreatePostComponent, canActivate: [AuthGuard] },
  { path: 'detailPost/:id', component: DetailPostComponent, canActivate: [AuthGuard] }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
