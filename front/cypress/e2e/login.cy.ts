
describe('Testing login', () => {
  it('Visits the login page', () => {

    cy.intercept('POST', '/api/auth/login', {
      body: {
        id: 1,
        username: 'userName',
        firstName: 'firstName',
        lastName: 'lastName',
      },
    })

    cy.intercept('GET', '/api/user/subscribedPosts/1', {
      body: {

      },
    })

    cy.visit('/');
    cy.get('button').should("contain", "Se connecter");
    cy.get('button').should("contain", "S'inscrire");

    cy.visit('/login')
    cy.get('label').should("contain", "E-mail");

    cy.get('input[formControlName=email]').type("test@test.com")
    cy.get('input[formControlName=password]').type(`${"Test!1234"}`)

    cy.get('button').should("contain", "Se connecter").click();

    cy.url().should('include', '/feed');

  })
})
