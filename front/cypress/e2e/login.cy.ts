
describe('Testing login', () => {
  it('Visits the login page', () => {
    cy.visit('/');
    cy.get('button').should("contain", "Se connecter");
    cy.get('button').should("contain", "S'inscrire");

    cy.visit('/login')
    cy.get('label').should("contain", "E-mail");

    cy.get('input[formControlName=email]').type("test@test.com")
    cy.get('input[formControlName=password]').type(`${"Test!1234"}{enter}{enter}`)

    cy.url().should('include', '/feed')


  })
})
