package co.com.test.stepsdefinitions;

import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import org.example.models.CredencialesInicioSesion;
import org.example.tasks.AbrirPagina;
import org.example.tasks.Autenticarse;
import org.example.tasks.CrearPagina;

import java.util.List;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class CrearPaginaStepsDefinitions {

    @Dado("^que el usuario está autenticado en la aplicación$")
    public void queElUsuarioEstaAutenticadoEnLaAplicacion(
            List<CredencialesInicioSesion> credenciales) {

        // 1. Abrir la página de inicio de sesión de Notion
        theActorInTheSpotlight().wasAbleTo(AbrirPagina.laPagina());

        // 2. Ejecutar el flujo completo de autenticación con Google
        theActorInTheSpotlight().attemptsTo(Autenticarse.aute(credenciales));
    }

    @Cuando("^el usuario crea una nueva página$")
    public void elUsuarioCreaUnaNuevaPagina() {
        theActorInTheSpotlight().attemptsTo(CrearPagina.nueva());
    }

    @Entonces("^la página debería haberse creado correctamente$")
    public void laPaginaDeberiaHaberseCreado() {
        // Aquí puedes agregar una verificación (assertion) de que la página fue creada
        // Por ejemplo, verificar que el título aparece en la lista de páginas
    }
}

