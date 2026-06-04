package co.com.test.stepsdefinitions;

import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import org.example.models.CredencialesInicioSesion;
import org.example.tasks.AbrirPagina;
import org.example.tasks.Autenticarse;
import org.example.tasks.EliminarPagina;

import java.util.List;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class EliminarPaginaStepsDefinitions {

    @Dado("^que el usuario está autenticado para eliminar una página$")
    public void queElUsuarioEstaAutenticadoParaEliminarUnaPagina(
            List<CredencialesInicioSesion> credenciales) {

        // 1. Abrir la página de inicio de sesión de Notion
        theActorInTheSpotlight().wasAbleTo(AbrirPagina.laPagina());

        // 2. Ejecutar el flujo completo de autenticación con Google
        theActorInTheSpotlight().attemptsTo(Autenticarse.aute(credenciales));
    }

    @Cuando("^el usuario elimina la primera página disponible$")
    public void elUsuarioEliminaLaPrimeraPaginaDisponible() {
        theActorInTheSpotlight().attemptsTo(EliminarPagina.alAzar());
    }

    @Entonces("^la página debería haberse eliminado correctamente$")
    public void laPaginaDeberiaHaberseEliminadoCorrectamente() {
        // Aquí puedes agregar una verificación (assertion) de que la página fue eliminada
        // Por ejemplo, verificar que ya no aparece en la barra lateral
    }
}
