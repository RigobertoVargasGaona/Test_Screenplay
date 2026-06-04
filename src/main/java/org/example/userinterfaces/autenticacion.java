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

    public static final Target MENSAJE_LOGIN =
            Target.the("")
                    .located(By.id(""));

}

