package co.com.test.stepsdefinitions;


import org.example.tasks.AbrirPagina;
import org.example.tasks.Autenticarse;
import cucumber.api.PendingException;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import org.example.models.CredencialesInicioSesion;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public  class LoginStepsDefinitions {

    @Dado("^que el usuario está en la página de inicio de sesión$")
    public void queElUsuarioEstáEnLaPáginaDeInicioDeSesión() {
        // Write code here that turns the phrase above into concrete actions
        theActorInTheSpotlight().wasAbleTo(AbrirPagina.laPagina());
    }

    @Cuando("^el usuario ingresa credenciales válidas$")
    public void elUsuarioIngresaCredencialesVálidas(
            List<CredencialesInicioSesion> credenciales) {
            theActorInTheSpotlight()
                    .attemptsTo(Autenticarse.aute(credenciales));
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
        // E,K,V must be a scalar (String, Integer, Date, enum etc).
        // Field names for YourType must match the column names in
        // your feature file (except for spaces and capitalization).
    }

    @Entonces("^el usuario debería estar en la pagina de bienvenida$")
    public void elUsuarioDeberíaEstarEnLaPaginaDeBienvenida() {
        // Write code here that turns the phrase above into concrete actions

    }
}