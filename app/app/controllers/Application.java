package controllers;

import Services.PaysDonneesService;
import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends Controller {

    public static void index() {
        List<PaysDonnees> donnees = PaysDonneesService.chercherDonneesPays("France");
        render(donnees);
    }

}