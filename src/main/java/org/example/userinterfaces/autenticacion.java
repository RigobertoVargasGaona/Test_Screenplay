package org.example.userinterfaces;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;

public class autenticacion extends PageObject {

    public static final Target INPUT_USUARIO =
            Target.the("campo usuario")
                    .located(By.id("notion-email-input-1"));

    public static final Target INPUT_CLAVE =
            Target.the("campo clave")
                    .located(By.id("password"));

    public static final Target BTN_INICIOSESION =
            Target.the("botón iniciar sesión")
                    .located(By.id(""));

    public static final Target BTN_CONTINUAR =
            Target.the("botón continuar")
                    .located(By.xpath("//*[normalize-space(.)='Continue with email' or normalize-space(.)='Continuar con correo electrónico' or normalize-space(.)='Continue' or normalize-space(.)='Continuar']"));

    public static final Target BTN_GOOGLE =
            Target.the("botón iniciar con Google")
                    .located(By.xpath("//div[@role='button' and normalize-space(.)='Google']"));

    public static final Target BTN_CUENTA_GOOGLE =
            Target.the("cuenta de Google {0}")
                    .locatedBy("//*[contains(text(), '{0}')]");

    public static final Target INPUT_EMAIL_GOOGLE =
            Target.the("campo correo de Google")
                    .located(By.id("identifierId"));

    public static final Target BTN_SIGUIENTE_GOOGLE =
            Target.the("botón Siguiente de Google")
                    .located(By.id("identifierNext"));

    public static final Target INPUT_CLAVE_GOOGLE =
            Target.the("campo clave de Google")
                    .located(By.name("Passwd"));

    public static final Target BTN_SIGUIENTE_PASSWORD_GOOGLE =
            Target.the("botón Siguiente de contraseña de Google")
                    .located(By.id("passwordNext"));

    public static final Target BTN_AGREGAR_PAGINA =
            Target.the("botón añadir página")
                    .located(By.xpath("//div[contains(@class, 'notion-outliner-private-header')]//div[contains(@class, 'shadow-cursor-new-page-sidebar')]"));

    public static final Target INPUT_TITULO_PAGINA =
            Target.the("título de la página")
                    .located(By.xpath("//h1[@contenteditable='true']"));

    public static final Target MENSAJE_LOGIN =
            Target.the("")
                    .located(By.id(""));

}
