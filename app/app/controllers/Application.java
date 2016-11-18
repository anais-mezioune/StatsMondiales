package controllers;

import Services.PaysDonneesService;
import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends Controller {

    public static void index() {
//        List<String> listePays = new ArrayList<>();
//
//        for(long i=1; i<=100; i++){
//
//            Pays pays = Pays.findById(i);
//            if(pays == null) System.out.println("//////////////////////////////NULLLLLLL");
//            listePays.add(pays.nom);
//
//        }
//
//
//        Map<String,Double> map = PaysDonneesService.chercherDonneeForListePaysForAnne(listePays,(short)2016,"mortalite_infantile");
//        for(Double d : map.values()){
//            System.out.println("valor : "+d);
//        }
//        render(map);
    }

}