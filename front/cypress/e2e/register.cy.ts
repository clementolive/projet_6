describe('Testing register', () => {
    it('Visits the register page', () => {

      cy.intercept('POST', '/api/auth/register', {
        body: [
        
    ]
    })

      cy.visit('/register');
  
      cy.get('input[formControlName=username]').type("test")
      cy.get('input[formControlName=email]').type("test@test.com")
      cy.get('input[formControlName=password]').type(`${"Test!1234"}{enter}{enter}`)
  
      cy.get('button').should("contain", "Se connecter");
  
    })
  })