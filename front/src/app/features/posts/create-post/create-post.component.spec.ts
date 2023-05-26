import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreatePostComponent } from './create-post.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import {
  getByTestId, screen
} from '@testing-library/dom'
import { RouterTestingModule } from '@angular/router/testing';
import { Routes } from '@angular/router';
import { FeedComponent } from '../feed/feed.component';
import { By } from '@angular/platform-browser';

const routes: Routes = [
  {path: 'feed', component: FeedComponent}
]

describe('CreatePostComponent', () => {
  let component: CreatePostComponent;
  let fixture: ComponentFixture<CreatePostComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreatePostComponent ], 
      imports: [FormsModule, ReactiveFormsModule, HttpClientModule, RouterTestingModule.withRoutes(routes)]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CreatePostComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
    const title = fixture.debugElement.query(By.css('h1')).nativeElement;
    expect(title.innerHTML).toBe('Créer un nouvel article');
  });

  it('should go back with window.history', () => {
    let window_state = window.history.state;
    if(window.history.length > 1){
      component.back();
      expect(window_state).not.toBe(window.history.state);
    }else{
      component.back(); 
      expect(window_state).toBe(window.history.state);
    }
  });


});
